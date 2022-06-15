import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import danggai.app.stateinjetpackcomposesample.MainViewModel
import danggai.app.stateinjetpackcomposesample.ui.widget.WellnessTasksList

@Preview
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        val list = viewModel.tasks

        WellnessTasksList(
            list = list,
            onCloseTask = { task -> viewModel.remove(task) },
            onCheckedTask = { task, checked ->
                viewModel.changeTaskChecked(task, checked)
            }
        )
    }
}