package barrera.alejandro.rickandmortyapp.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import barrera.alejandro.rickandmortyapp.core.navigation.NavGraph
import barrera.alejandro.rickandmortyapp.core.presentation.components.Background
import barrera.alejandro.rickandmortyapp.ui.theme.RickAndMortyAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {

                val navController = rememberNavController()

                Box {
                    Background()
                    Scaffold(
                        containerColor = Color.Transparent
                    ) { paddingValues ->
                        NavGraph(
                            navController = navController,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}