package ramzi.eljabali.firebasedatabase.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ramzi.eljabali.firebasedatabase.viewstate.AddDataViewState

class AddDataViewModel(db: FirebaseFirestore) : ViewModel() {
    private final val FIRESTORE_TAG = "Firestore"
    private val db: FirebaseFirestore

    private val _viewState = MutableStateFlow(AddDataViewState())
    val viewState = _viewState.asStateFlow()

    init {
        this.db = db
    }

    public fun resetViewState() {
        _viewState.value = AddDataViewState()
    }

    fun updatedText(updatedText: String, textBoxNumber: Int) {
        when (textBoxNumber) {
            0 -> {
                val viewstate = _viewState.value.user
                viewstate.name = updatedText
                _viewState.value = _viewState.value.copy(user = viewstate)
                Log.i(javaClass.simpleName, "name updated $updatedText")
            }

            1 -> {
                val viewstate = _viewState.value.user
                viewstate.email = updatedText
                _viewState.value = _viewState.value.copy(user = viewstate)
                Log.i(javaClass.simpleName, "email updated $updatedText")
            }

            2 -> {
                val viewstate = _viewState.value.focus
                viewstate.title = updatedText
                _viewState.value = _viewState.value.copy(focus = viewstate)
                Log.i(javaClass.simpleName, "title updated $updatedText")
            }

            3 -> {
                val viewstate = _viewState.value.habit
                viewstate.title = updatedText
                _viewState.value = _viewState.value.copy(habit = viewstate)
                Log.i(javaClass.simpleName, "title updated $updatedText")
            }
        }
    }

    fun updatedToggle(updatedBoolean: Boolean) {
        val viewstate = _viewState.value.habitValue
        viewstate.isFullFilled = updatedBoolean
        _viewState.value = _viewState.value.copy(habitValue = viewstate)
        Log.i(javaClass.simpleName, "is Full filled updated $updatedBoolean")
    }

    fun postButtonClicked() {
        val userMap = hashMapOf(
            "creation_date" to FieldValue.serverTimestamp(), //for timestamp
            "email" to _viewState.value.user.email,
            "has_onboarded" to false,
            "name" to _viewState.value.user.name,
        )
        //auto generates Id's for me
        db.collection("users").document()
            .set(userMap)
            .addOnSuccessListener { Log.d(FIRESTORE_TAG, "successfully Added!") }
            .addOnFailureListener { e -> Log.w(FIRESTORE_TAG, "Error adding", e) }
    }
}
