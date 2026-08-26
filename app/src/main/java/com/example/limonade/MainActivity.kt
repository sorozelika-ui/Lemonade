package com.example.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonade.ui.theme.LimonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LimonadeTheme {
                LimonadeApp(
                    Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}
@Composable
fun LimonadeApp(modifier: Modifier) {
    var level by remember { mutableStateOf(1) }
    var nbclic by remember { mutableStateOf(0) }
    var imageResource = when (level) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var chaine_extrait = when (level) {
        1 -> R.string.Tap_the_lemon_tree_to_select_a_lemon
        2 -> R.string.Keep_tapping_the_lemon_to_squeeze_it
        3 -> R.string.Tap_the_lemonade_to_drink_it
        else -> R.string.Tap_the_empty_glass_to_start_again
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier){
        Text(text = stringResource(chaine_extrait, fontSize = 18.sp))
        Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(imageResource),contentDescription = null,
            modifier = Modifier.clickable {
                when(level){

                    1 -> {
                        level = 2
                    }

                    2 -> {
                        nbclic++

                        if(nbclic >= 4){
                            level = 3
                        }
                    }

                    3 -> {
                        level = 4
                    }

                    4 -> {
                        level = 1
                        nbclic = 0
                    }
                }
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun LimonadePreview() {
    LimonadeTheme {
        LimonadeApp(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}