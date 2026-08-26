package com.example.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

    // Niveau de l'application
    var level by remember { mutableStateOf(1) }

    // Nombre de clics sur le citron
    var nbclic by remember { mutableStateOf(0) }

    // Image affichée selon le level
    val imageResource = when (level) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    // Texte affiché selon le level
    val chaine_extrait = when (level) {
        1 -> R.string.Tap_the_lemon_tree_to_select_a_lemon
        2 -> R.string.Keep_tapping_the_lemon_to_squeeze_it
        3 -> R.string.Tap_the_lemonade_to_drink_it
        else -> R.string.Tap_the_empty_glass_to_start_again
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // TITRE FIXE

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.lemonade),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Image cliquable
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier.clickable {

                    when (level) {

                        // Étape 1 : cliquer sur le citron
                        1 -> {
                            level = 2
                        }

                        // Étape 2 : presser le citron
                        2 -> {
                            level = 2
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

            // Espace entre l'image et le texte
            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Texte
            Text(
                text = stringResource(chaine_extrait),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

//affichage du preview

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