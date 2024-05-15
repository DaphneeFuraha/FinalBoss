package com.example.finalboss

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalboss.model.dataclass
import com.example.finalboss.ui.theme.FinalBossTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity8 : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalBossTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val taskList = mutableStateListOf<dataclass?>()
                    val db = Firebase.firestore
                    db.collection("dataclass").get().addOnSuccessListener{
                            queryDocumentSnapshots ->
                        if(!queryDocumentSnapshots.isEmpty){
                            val list = queryDocumentSnapshots.documents
                            for (jay in list){
                                val d:dataclass? = jay.toObject(dataclass::class.java)
                                taskList.add(d)
                            }
                        }else{
                            Toast.makeText(this@MainActivity8, "No Review left",Toast.LENGTH_LONG).show()
                        }
                    }.addOnFailureListener{
                        Toast.makeText(this@MainActivity8, "Failed leave review",Toast.LENGTH_LONG).show()
                    }
                    Greeting(LocalContext.current, taskList)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(context: Context, taskList: SnapshotStateList<dataclass?>){
    Column (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.Gray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        LazyColumn {
            itemsIndexed(taskList){
                    index, item ->
                Card(
                    onClick = {
                        Toast.makeText(context,taskList[index]?.cold + "Selected",Toast.LENGTH_LONG).show()
                    }
                    , modifier = Modifier.padding(10.dp)) {
                    Column (modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()){
                        Spacer(modifier = Modifier.width(6.dp))
                        taskList[index]?.cold?.let{
                            Text(
                                text = it,modifier = Modifier.padding(5.dp),
                                color = Color.Blue,
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 24.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun Greeting2() {
    FinalBossTheme {
        val taskList = mutableStateListOf<dataclass?>()
        Greeting(LocalContext.current, taskList)
    }
}