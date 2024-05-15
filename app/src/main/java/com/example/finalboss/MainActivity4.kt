package com.example.finalboss

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalboss.ui.theme.FinalBossTheme

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalBossTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Candy()
                }
            }
        }
    }
}

@Composable
fun home(){
    Text(
        text = "MUSHREVIEW",
        modifier = Modifier
            .size(40.dp)
            .padding(horizontal = 20.dp)
            .paddingFromBaseline(top = 40.dp, bottom = 20.dp)
    )
}

@Composable
fun life(@DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier) {
    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(drawable ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun liferow(modifier: Modifier = Modifier){
    LazyRow (
        contentPadding = PaddingValues(
            horizontal = 20.dp,
        ),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
    ) {
        items(lifedata){
                item -> life(item.drawable,item.text)
        }
    }
}

private val lifedata = listOf(
    R.drawable.bones to R.string.bones,
    R.drawable.book to R.string.book,
    R.drawable.dark to R.string.dark,
    R.drawable.dune to R.string.dune,
    R.drawable.life to R.string.life,
    R.drawable.nature to R.string.nature

).map { DrawableStringPair(it.first, it.second) }

private class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
){}

@Composable
fun hook(modifier: Modifier = Modifier){
    LazyRow (
        contentPadding = PaddingValues(
            horizontal = 20.dp,
        ),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
    ) {
        items(hookdata){
                item -> life(item.drawable,item.text)
        }
    }
}

private val hookdata = listOf(
    R.drawable.hallow to R.string.hallow,
    R.drawable.wed to R.string.wed,
    R.drawable.dune to R.string.dune,
    R.drawable.samar to R.string.samar,
    R.drawable.life to R.string.life,
    ).map { DrawableStringPair(it.first, it.second) }


@Composable
fun photos(modifier: Modifier = Modifier){
    LazyRow (
        contentPadding = PaddingValues(
            horizontal = 20.dp,
        ),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
    ) {
        items(photodata){
                item -> life(item.drawable,item.text)
        }
    }
}

private val photodata = listOf(
    R.drawable.dress to R.string.dress,
    R.drawable.wed to R.string.wed,
    R.drawable.elliot to R.string.elliot,
    R.drawable.samar to R.string.samar,
    R.drawable.images to R.string.images,

    ).map { DrawableStringPair(it.first, it.second) }

@Composable
fun HomePage(@StringRes title:Int, modifier: Modifier = Modifier, content:@Composable () -> Unit){
    Column(modifier = Modifier) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 20.dp)
        )
        content()
    }

}

@Composable
fun LandingPageScreen(modifier: Modifier = Modifier){
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(
            Modifier.height(20.dp)
        )
        home()
        HomePage(title = R.string.clue) {
            liferow()

        }
        HomePage(title = R.string.tat) {
            hook()
        }
        HomePage(title = R.string.glossy) {
            photos()
        }
        Spacer(
            Modifier.height(20.dp)
        )
    }
}

@Composable
fun MyNavigation(modifier: Modifier = Modifier){
    NavigationBar(modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(selected = true,
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Home")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            })
        val jan = LocalContext.current
        NavigationBarItem(selected = false,
            onClick = {
                jan.startActivity(Intent(jan,MainActivity5::class.java))
            },
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
fun Candy(){
    FinalBossTheme{
        Scaffold (bottomBar = { MyNavigation()}){
                padding -> LandingPageScreen(Modifier.padding(padding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecapPreveiw() {
    FinalBossTheme {
        Candy()
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalBossTheme {
        home()
    }
}