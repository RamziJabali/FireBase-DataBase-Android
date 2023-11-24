package ramzi.eljabali.firebasedatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import ramzi.eljabali.firebasedatabase.ui.theme.FireBaseDataBaseTheme
import ramzi.eljabali.firebasedatabase.ui.views.AddDataView
import ramzi.eljabali.firebasedatabase.viewmodel.AddDataViewModel


class MainActivity : ComponentActivity() {
    private val db = Firebase.firestore
    private val addDataViewModel = AddDataViewModel(db)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireBaseDataBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddDataView(addDataViewModel = addDataViewModel)
                }
            }
        }
    }
}