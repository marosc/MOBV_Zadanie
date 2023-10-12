package eu.mcomputing.mobv.mobvzadanie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedViewModel : ViewModel() {
    private val _sampleString = MutableLiveData<String>()
    val sampleString: LiveData<String> get() = _sampleString

    fun updateString(value: String) {
        _sampleString.value = value
    }
}