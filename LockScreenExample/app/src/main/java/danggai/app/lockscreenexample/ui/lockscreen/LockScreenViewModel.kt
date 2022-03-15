package danggai.app.lockscreenexample.ui.lockscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import danggai.app.lockscreenexample.util.log
import danggai.app.resinwidget.util.Event

class LockScreenViewModel : ViewModel() {

    var lvEventUnlock: MutableLiveData<Event<Boolean>> = MutableLiveData()

    val lvTeam: MutableLiveData<String> = MutableLiveData()
    val lvName: MutableLiveData<String> = MutableLiveData()
    val lvPhoneNumber: MutableLiveData<String> = MutableLiveData()
    val lvOtp: MutableLiveData<String> = MutableLiveData()


    fun onClickSendOtp() {
        log.e()

    }

    fun onClickAuthOtp() {
        log.e()
        lvEventUnlock.value = Event(true)
    }
}