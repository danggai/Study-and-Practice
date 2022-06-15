package danggai.app.stateinjetpackcomposesample

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import danggai.app.stateinjetpackcomposesample.domain.local.WellnessTask

class MainViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()

    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let {
            it.checked = checked
        }
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i", false) }