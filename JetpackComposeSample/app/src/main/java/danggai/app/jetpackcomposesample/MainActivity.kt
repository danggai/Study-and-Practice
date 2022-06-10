package danggai.app.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import danggai.app.jetpackcomposesample.ui.theme.Purple200

val list = mutableListOf<Character>().apply {
    add(Character("Hu tao", 5))
    add(Character("Diona", 4))
    add(Character("Bennett", 4))
    add(Character("Raiden Shogun", 5))
    add(Character("Yeran", 5))
    add(Character("Kaedehara Kazuha", 5))
    add(Character("Xiangling", 4))
    add(Character("Xingqiu", 4))
    add(Character("Qiqi", 5))
    add(Character("Razor", 4))
    add(Character("Lisa", 4))
    add(Character("Zhongli", 5))
    add(Character("Amber", 4))
    add(Character("Keqing", 5))
    add(Character("Kaeya", 4))
    add(Character("Sayu", 4))
    add(Character("Fischl", 4))
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tabs()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Tabs() {
    var tabIndex = remember{ mutableStateOf(0) }
    val tabTitles = listOf("Layout", "RecyclerView", "Gridview")
    Column {
        TabRow(selectedTabIndex = tabIndex.value ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex.value == index,
                    onClick = { tabIndex.value = index },
                    text = { Text(text = title, fontSize = 12.sp) }
                )
            }
        }
        when (tabIndex.value) {
            0 -> Layout()
            1 -> RecyclerView()
            2 -> GridView()
            else -> { }
        }
    }
}

@Composable
fun Layout() {
    MaterialTheme {
        Column (
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Greeting("Android")

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0x11000000)
            ) {
                Greeting("Android")
            }

            CountBtn()

            Text(
                LocalContext.current.getString(R.string.lorem_ipsum),
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 30,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun RecyclerView() {
    LazyColumn(content = {
        items(list.size) { index ->
            Item(list[index])
        }
    })
}

@Composable
fun GridView() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(list.size) { index ->
                Item(list[index])
            }
        }
    )
}

class Character(val name: String, val rarity: Int)

@Composable
fun Item(chara: Character) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        Box() {
            Image(
                painter = if (chara.rarity == 4) painterResource(id = R.drawable.bg_character_4stars)
                else painterResource(id = R.drawable.bg_character_5stars),
                contentDescription = "background",
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
            )

            Image(
                painter = if (chara.rarity == 4) painterResource(id = R.drawable.icon_4stars)
                else painterResource(id = R.drawable.icon_5stars),
                contentDescription = "rarity",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .height(14.dp)
            )
        }

        Text(
            chara.name,
            color = Color(0xff000000),
            fontSize = 12.sp
        )
    }
}

@Composable
fun CountBtn() {
    val count = remember { mutableStateOf(0) }
    Button(
        onClick = { count.value += 1 },
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .background(Purple200)
    ) {
        Text(
            text = count.value.toString(),
            fontSize = 18.sp
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}