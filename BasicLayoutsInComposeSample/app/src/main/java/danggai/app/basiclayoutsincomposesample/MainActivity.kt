package danggai.app.basiclayoutsincomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import danggai.app.basiclayoutsincomposesample.ui.theme.BasicLayoutsInComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutsInComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier
                    .fillMaxSize(),
                    color = MaterialTheme.colors.background) {
//                    PhotographerCard()
                    SimpleList()
                }
            }
        }
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi There!")
        Text(text = "Thanks for going through the layouts codelab")
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    BasicLayoutsInComposeSampleTheme {
        LayoutsCodelab()
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row {
        Surface(
            modifier = modifier
                .padding(8.dp)     // 8dp만큼의 padding은 not clickable
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.background)
                .clickable(onClick = { /* Ignoring onClick */ })
                .padding(16.dp)     // 16dp만큼의 padding은 clickable
            ,
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {

        }

        Column (
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                "Alfred Sisley",
                fontWeight = FontWeight.Bold
            )

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    "3 minutes ago",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    BasicLayoutsInComposeSampleTheme {
        PhotographerCard()
    }
}