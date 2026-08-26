package com.example.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limonade.ui.theme.LimonadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LimonadeTheme {
                LimonadeApp()
            }
        }
    }
}

@Composable
fun LimonadeApp(modifier: Modifier = Modifier) {

    // Niveau actuel de l'application
    var level by remember { mutableStateOf(1) }

    // Nombre de clics sur le citron
    var nbclic by remember { mutableStateOf(0) }

    // Image affichée selon le niveau
    val imageResource = when (level) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    // Texte affiché selon le niveau
    val chaine_extrait = when (level) {
        1 -> R.string.Tap_the_lemon_tree_to_select_a_lemon
        2 -> R.string.Keep_tapping_the_lemon_to_squeeze_it
        3 -> R.string.Tap_the_lemonade_to_drink_it
        else -> R.string.Tap_the_empty_glass_to_start_again
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Image cliquable
        Image(
            painter = painterResource(imageResource),
            contentDescription = null,
            modifier = Modifier.clickable {

                when (level) {

                    // Étape 1 : sélectionner un citron
                    1 -> {
                        level = 2
                    }

                    // Étape 2 : presser le citron
                    2 -> {
                        nbclic++

                        if (nbclic >= 4) {
                            level = 3
                        }
                    }

                    // Étape 3 : boire la citronnade
                    3 -> {
                        level = 4
                    }

                    // Étape 4 : recommencer
                    4 -> {
                        level = 1
                        nbclic = 0
                    }
                }
            }
        )
        // Espace entre le texte et l'image
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        // Texte de l'étape actuelle
        Text(
            text = stringResource(chaine_extrait),
            fontSize = 18.sp
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