package br.com.frazo.dynamicthemecolors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.frazo.dynamic_theme_colors.randomColorScheme
import br.com.frazo.dynamicthemecolors.ui.theme.DynamicThemeColorsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var blendRatio by rememberSaveable {
                mutableStateOf(0f)
            }

            val colorScheme by remember {
                mutableStateOf(randomColorScheme())
            }

            DynamicThemeColorsTheme(blendRatio = blendRatio, baseColorScheme = colorScheme) {
                val listOfColors = MaterialTheme.colorScheme.toPairList()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Slider(value = blendRatio, onValueChange = {
                            blendRatio = it
                        })
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Black)
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            color = Color.White,
                            text = "blendRatio: ${String.format("%.2f",blendRatio)}",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        )
                        LazyVerticalStaggeredGrid(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalItemSpacing = 8.dp,
                            columns = StaggeredGridCells.Adaptive(150.dp)
                        ) {
                            items(
                                items = listOfColors,
                                key = {
                                    it.first
                                }
                            ) {
                                Card(modifier = Modifier.height(100.dp)) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(it.second)
                                    ) {
                                        Text(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color.Black)
                                                .padding(horizontal = 8.dp, vertical = 4.dp),
                                            color = Color.White,
                                            text = it.first,
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.Center,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColorScheme.toPairList(): List<Pair<String, Color>> {
    return listOf(
        Pair("primary", primary),
        Pair("onPrimary", onPrimary),
        Pair("primaryContainer", primaryContainer),
        Pair("onPrimaryContainer", onPrimaryContainer),
        Pair("inversePrimary", inversePrimary),
        Pair("secondary", secondary),
        Pair("onSecondary", onSecondary),
        Pair("secondaryContainer", secondaryContainer),
        Pair("onSecondaryContainer", onSecondaryContainer),
        Pair("tertiary", tertiary),
        Pair("onTertiary", onTertiary),
        Pair("tertiaryContainer", tertiaryContainer),
        Pair("onTertiaryContainer", onTertiaryContainer),
        Pair("background", background),
        Pair("onBackground", onBackground),
        Pair("surface", surface),
        Pair("onSurface", onSurface),
        Pair("surfaceVariant", surfaceVariant),
        Pair("onSurfaceVariant", onSurfaceVariant),
        Pair("surfaceTint", surfaceTint),
        Pair("inverseSurface", inverseSurface),
        Pair("inverseOnSurface", inverseOnSurface),
        Pair("error", error),
        Pair("onError", onError),
        Pair("errorContainer", errorContainer),
        Pair("onErrorContainer", onErrorContainer),
        Pair("outline", outline),
        Pair("outlineVariant", outlineVariant),
        Pair("scrim", scrim),
    )
}