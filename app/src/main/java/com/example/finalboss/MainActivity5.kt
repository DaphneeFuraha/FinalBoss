package com.example.finalboss

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalboss.ui.theme.FinalBossTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalBossTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    lucky()
                }
            }
        }
    }
}

@Composable
fun Greeting2(modifier: Modifier = Modifier) {
    Column (modifier.verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally){
        Card (modifier = Modifier.fillMaxWidth()){
            var like by remember {
                mutableStateOf(false)
            }
            var dislike by remember {
                mutableStateOf(false)
            }
            var huh by remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
            }
            if (like){ huh = Icons.Default.Favorite }
            else huh = Icons.Default.FavoriteBorder
            var duh by remember {
                mutableStateOf(Icons.Default.Close)
            }
            if (dislike){ duh = Icons.Default.Done }
            else duh = Icons.Default.Close
            Image(
                painter = painterResource(id = R.drawable.dune),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)

            )
            Row(modifier = Modifier) {
                Text(text = "Sure, it has massive worms and a strange, trippy drug-like substance simply referred to as the spice but thestory is good")
            }
            Row (modifier = Modifier){
               IconButton(
                   onClick = { if (!dislike){
                       like = !like
                   }
                       if (dislike){
                           like = !like
                           dislike = false}},
                   Modifier.padding(20.dp)) {
                   Icon(
                       imageVector = huh,
                       contentDescription = null
                   )
               }
                IconButton(
                    onClick = { if (!like){
                        dislike = !dislike
                    }
                        if (like){
                            dislike = !dislike
                            like = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = duh,
                        contentDescription = null
                    )
                }

                val wah = LocalContext.current
                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        wah.startActivity(Intent(wah, MainActivity6::class.java))
                    }
                ) {
                    Text(text = "Review")
                }
            }
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Card (modifier = Modifier.fillMaxWidth()){
            var like by remember {
                mutableStateOf(false)
            }
            var dislike by remember {
                mutableStateOf(false)
            }
            var huh by remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
            }
            if (like){ huh = Icons.Default.Favorite }
            else huh = Icons.Default.FavoriteBorder
            var duh by remember {
                mutableStateOf(Icons.Default.Close)
            }
            if (dislike){ duh = Icons.Default.Done }
            else duh = Icons.Default.Close
            Image(
                painter = painterResource(id = R.drawable.samar),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)

            )
            Row {
                Text(text = "A depressing yet beautifully written book. The book will definately take you on an emotional rollercoaster ")
            }
            Row(modifier = Modifier) {
                IconButton(
                    onClick = { if (!dislike){
                        like = !like
                    }
                        if (dislike){
                            like = !like
                            dislike = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = huh,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = { if (!like){
                        dislike = !dislike
                    }
                        if (like){
                            dislike = !dislike
                            like = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = duh,
                        contentDescription = null
                    )
                }

                val wah = LocalContext.current
                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        wah.startActivity(Intent(wah, MainActivity6::class.java))
                    }
                ) {
                    Text(text = "Review")
                }
            }
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Card (modifier = Modifier.fillMaxWidth()){
            var like by remember {
                mutableStateOf(false)
            }
            var dislike by remember {
                mutableStateOf(false)
            }
            var huh by remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
            }
            if (like){ huh = Icons.Default.Favorite }
            else huh = Icons.Default.FavoriteBorder
            var duh by remember {
                mutableStateOf(Icons.Default.Close)
            }
            if (dislike){ duh = Icons.Default.Done }
            else duh = Icons.Default.Close
            Image(
                painter = painterResource(id = R.drawable.wed),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)

            )
            Row {
                Text(text = "The Wedding Date is a charming, sweet, and downright adorable book! I had trouble believing this was a debut novel- it ...")
            }
            Row (modifier = Modifier){
                IconButton(
                    onClick = { if (!dislike){
                        like = !like
                    }
                        if (dislike){
                            like = !like
                            dislike = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = huh,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = { if (!like){
                        dislike = !dislike
                    }
                        if (like){
                            dislike = !dislike
                            like = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = duh,
                        contentDescription = null
                    )
                }

                val wah = LocalContext.current
                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        wah.startActivity(Intent(wah, MainActivity6::class.java))
                    }
                ) {
                    Text(text = "Review")
                }
            }
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Card (modifier = Modifier.fillMaxWidth()){
            var like by remember {
                mutableStateOf(false)
            }
            var dislike by remember {
                mutableStateOf(false)
            }
            var huh by remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
            }
            if (like){ huh = Icons.Default.Favorite }
            else huh = Icons.Default.FavoriteBorder
            var duh by remember {
                mutableStateOf(Icons.Default.Close)
            }
            if (dislike){ duh = Icons.Default.Done }
            else duh = Icons.Default.Close
            Image(
                painter = painterResource(id = R.drawable.life),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)

            )
            Row {
                Text(text = "It is a really powerful book that gives and very graphic understanding of the meaning of friendship and the continuing effects of child abuse.")
            }
            Row (modifier = Modifier){
                IconButton(
                    onClick = { if (!dislike){
                        like = !like
                    }
                        if (dislike){
                            like = !like
                            dislike = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = huh,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = { if (!like){
                        dislike = !dislike
                    }
                        if (like){
                            dislike = !dislike
                            like = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = duh,
                        contentDescription = null
                    )
                }

                val wah = LocalContext.current
                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        wah.startActivity(Intent(wah, MainActivity6::class.java))
                    }
                ) {
                    Text(text = "Review")
                }
            }
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Card (modifier = Modifier.fillMaxWidth()){
            var like by remember {
                mutableStateOf(false)
            }
            var dislike by remember {
                mutableStateOf(false)
            }
            var huh by remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
            }
            if (like){ huh = Icons.Default.Favorite }
            else huh = Icons.Default.FavoriteBorder
            var duh by remember {
                mutableStateOf(Icons.Default.Close)
            }
            if (dislike){ duh = Icons.Default.Done }
            else duh = Icons.Default.Close
            Image(
                painter = painterResource(id = R.drawable.hallow),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)

            )
            Row {
                Text(text = " In many ways, this book is quite different to others in the series, with more complex emotional themes as Harry struggles to deal with things")
            }
            Row (modifier = Modifier){
                IconButton(
                    onClick = { if (!dislike){
                        like = !like
                    }
                        if (dislike){
                            like = !like
                            dislike = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = huh,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = { if (!like){
                        dislike = !dislike
                    }
                        if (like){
                            dislike = !dislike
                            like = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = duh,
                        contentDescription = null
                    )
                }

                val wah = LocalContext.current
                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        wah.startActivity(Intent(wah, MainActivity6::class.java))
                    }
                ) {
                    Text(text = "Review")
                }
            }
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Card (modifier = Modifier.fillMaxWidth()){
            var like by remember {
                mutableStateOf(false)
            }
            var dislike by remember {
                mutableStateOf(false)
            }
            var huh by remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
            }
            if (like){ huh = Icons.Default.Favorite }
            else huh = Icons.Default.FavoriteBorder
            var duh by remember {
                mutableStateOf(Icons.Default.Close)
            }
            if (dislike){ duh = Icons.Default.Done }
            else duh = Icons.Default.Close
            Image(
                painter = painterResource(id = R.drawable.dark),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)

            )
            Row {
                Text(text = " It does read like a first novel, there are a fair few editing issues and I would make some better choices for how the settings are described")
            }
            Row (modifier = Modifier){
                IconButton(
                    onClick = { if (!dislike){
                        like = !like
                    }
                        if (dislike){
                            like = !like
                            dislike = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = huh,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = { if (!like){
                        dislike = !dislike
                    }
                        if (like){
                            dislike = !dislike
                            like = false}},
                    Modifier.padding(20.dp)) {
                    Icon(
                        imageVector = duh,
                        contentDescription = null
                    )
                }

                val wah = LocalContext.current
                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        wah.startActivity(Intent(wah, MainActivity6::class.java))
                    }
                ) {
                    Text(text = "Review")
                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier){
    NavigationBar(modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        val jan = LocalContext.current
        NavigationBarItem(selected = true,
            onClick = {
                jan.startActivity(Intent(jan,MainActivity4::class.java))
            },
            label = {
                Text(text = "Home")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            })
        NavigationBarItem(selected = false,
            onClick = {/*TODO*/},
            label = {
                Text(text = "Trending")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null
                )
            })

        val wow = LocalContext.current
        NavigationBarItem(selected = false,
            onClick = { wow.startActivity(Intent(wow,MainActivity7::class.java)) },
            label = {
                Text(text = "New")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            })
    }
}

@Composable
fun lucky(){
    FinalBossTheme {
        Scaffold (bottomBar = { Navigation()}) {
                padding -> Greeting2(Modifier.padding(padding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun gangsta() {
    FinalBossTheme {
        lucky()
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FinalBossTheme {
        Greeting2()
    }
}