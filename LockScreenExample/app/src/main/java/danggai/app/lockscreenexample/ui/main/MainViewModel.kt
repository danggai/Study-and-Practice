package danggai.app.lockscreenexample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import danggai.app.lockscreenexample.R
import danggai.app.resinwidget.util.Event

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var lvLockScreenEnable = MutableLiveData<Boolean>(false)
    var lvEventLockScreenEnable = MutableLiveData<Event<Boolean>>()

    fun onClickSwitch(viewId: Int) {

        when (viewId) {
            R.id.sc_lockscreen_enable -> {

                lvLockScreenEnable.value = !(lvLockScreenEnable.value?:false)
                lvEventLockScreenEnable.value = Event(lvLockScreenEnable.value?:false)

            }
        }
    }
}