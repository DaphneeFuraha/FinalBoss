package com.example.finalboss

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalboss.model.dataclass
import com.example.finalboss.ui.theme.FinalBossTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore

class MainActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalBossTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    gosh(LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun gosh(context: Context){
    val cold = remember {
        mutableStateOf("")
    }
    Column (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        TextField(
            value = cold.value,
            onValueChange = { cold.value = it },
            placeholder = { Text(text = "Review") },
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            if(TextUtils.isEmpty(cold.value)){
                Toast.makeText(context,"Please enter your Review ", Toast.LENGTH_LONG).show()
            }else{
                addDataFirebase(cold.value, context)
            }
        }) {
             Text(text = "Leave a Review")
        }
    }
}

fun addDataFirebase(cold: String, context: Context) {
//create an instance
    val db = Firebase.firestore
    val dbdataclass: CollectionReference = db.collection("lily")
    val idek = dataclass(cold)
    dbdataclass.add(idek).addOnSuccessListener {
        Toast.makeText(context,"You have added a review ",Toast.LENGTH_LONG).show()
    }
        .addOnFailureListener{
                e ->
            Toast.makeText(context,"You have failed to add a review  ",Toast.LENGTH_LONG).show()

        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    FinalBossTheme {
        gosh(LocalContext.current)
    }
}