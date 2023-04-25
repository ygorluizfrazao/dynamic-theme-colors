<div id="header" align="center">
  <a href="https://jitpack.io/#ygorluizfrazao/compose-audio-controls"><img src="https://jitpack.io/v/ygorluizfrazao/compose-audio-controls.svg" alt="Version Name"/></a>
  <img src="https://komarev.com/ghpvc/?username=ygorluizfrazao&style=flat-square&color=blue" alt=""/>
</div>
<div id="badges" align="center">
  <a href="https://www.linkedin.com/in/ygorluizfrazao/">
    <img src="https://img.shields.io/badge/LinkedIn-blue?style=flat&logo=linkedin&logoColor=white" alt="LinkedIn Badge"/>
  </a>
  <a href="https://ko-fi.com/ygorfrazao">
    <img src="https://img.shields.io/badge/Kofi-blue?style=flat&logo=kofi&logoColor=white" alt="Youtube Badge"/>
  </a>
</div>

# dynamic-theme-colors
Convenience library aimed to blend your app theme colors with Material 3 dynamic colors system using Jetpack Compose for **Android 12+**.

## How can i use it?

Just add this to your *settings.gradle*:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Then, in your *build.gradle*:

```groovy
	dependencies {
	        //
	}
```

## Why it exists?

In [materialv3]([https://m3.material.io]) we have the [dynamic color system](https://m3.material.io/styles/color/dynamic-color/overview), which, in Android, by default, ignores your defined theme colors and only uses the system colors, when creating your theming composable. This lib just blends your defined theme colors with the system colors. 


## How to use it?

The main way to use it is to call the function:
```kotlin
fun ColorScheme.blendWithSystemUI(
    darkTheme: Boolean = isSystemInDarkTheme(),
    blendRatio: Float = .5f
): ColorScheme
```
- `darkTheme` -> Decides which system theme to blend with, Light or Dark;
- `blendRatio` -> How much system theme colors will contribute to the final `ColorScheme`;

### Example:

The following device has a Greenish/Cyanish theme...

- `blendRatio = 0`: 
<img src = "https://user-images.githubusercontent.com/17025709/234410805-4c275097-80bd-47c7-9c5d-9353a74e35c7.jpeg" alt="with 0 blend ration" style="width:20%">

- `blendRatio = 0.3`:
<img src = "https://user-images.githubusercontent.com/17025709/234411247-aae53ea4-0bf2-4390-b5af-86239cfb9e50.jpeg" alt="with 0.3 blend ration" style="width:20%">

- `blendRatio = 0.6`:
<img src = "https://user-images.githubusercontent.com/17025709/234411494-2ff7c647-def5-4488-ac52-5cc501313608.jpeg" alt="with 0.6 blend ration" style="width:20%">

- `blendRatio = 0.95`:
<img src = "https://user-images.githubusercontent.com/17025709/234411730-36114223-5fa9-46a0-be3e-4f26c3b67c83.jpeg" alt="with 0.6 blend ration" style="width:20%">

this demo is available in the source files of this repos.

the code would be like:

```kotlin

//Theme.kt

@Composable
fun DynamicThemeColorsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    baseColorScheme: ColorScheme,
    blendRatio: Float = .5f,
    content: @Composable () -> Unit
) {
    
    val dynamicColorScheme =
        baseColorScheme.blendWithSystemUI(darkTheme = darkTheme, blendRatio)

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = dynamicColorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = dynamicColorScheme,
        typography = Typography,
        content = content
    )
}
```

```kotlin

//MainActivity.kt

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

```

## Other resources
This lib also has some extensions for `ColorScheme`class, as listed:

- `fun randomARGBColor(...)` -> Creates a random color;
- `fun randomColorScheme(...)` -> Creates a scheme with random colors as default, if you want some specific color, pass as a param.
- `fun ColorScheme.blend(anotherColorScheme: ColorScheme, ratio: Float = 0.5f): ColorScheme` -> Blends two `ColorScheme` objects.
- `fun ColorScheme.maskedBy(mask: ColorScheme, maskOpacity: Float): ColorScheme` -> masks a `ColorScheme` using another after applying the maskOpacity, the `alpha` sum will be 1.
- `fun ColorScheme.withAlpha(alpha: Float): ColorScheme` -> Adds the desired transparency to the `ColorScheme` object.

Hope it helps you.
