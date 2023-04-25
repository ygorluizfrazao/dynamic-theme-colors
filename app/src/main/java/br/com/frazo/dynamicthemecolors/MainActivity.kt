package br.com.frazo.dynamicthemecolors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.frazo.dynamicthemecolors.ui.theme.DynamicThemeColorsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            DynamicThemeColorsTheme {
                MaterialTheme.colorScheme.toPairList()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(200.dp)){
                        item {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColorScheme.toPairList(): List<Pair<String, Color>>{
    this.javaClass.fields.forEach {
        println("$it.name = ${it.get(Any())}")
    }

    return listOf()
}