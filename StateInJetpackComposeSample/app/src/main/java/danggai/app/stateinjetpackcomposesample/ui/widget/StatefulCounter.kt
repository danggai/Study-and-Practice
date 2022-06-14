import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import danggai.app.stateinjetpackcomposesample.ui.widget.StatelessCounter

@Preview
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    StatelessCounter(count, { count++ })
}