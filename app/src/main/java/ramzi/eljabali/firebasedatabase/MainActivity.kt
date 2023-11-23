package ramzi.eljabali.firebasedatabase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import ramzi.eljabali.firebasedatabase.ui.theme.FireBaseDataBaseTheme
import java.util.Date


class MainActivity : ComponentActivity() {
    private val db = Firebase.firestore
    private final val FIRESTORE_TAG = "Firestore";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireBaseDataBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    val userMap = hashMapOf(
                        "creation_date" to Timestamp(Date()),
                        "email" to "testPut@email.com",
                        "has_onboarded" to false,
                        "name" to "OzzMix"
                    )
                    db.collection("users").add(userMap)
                        .addOnSuccessListener { Log.d(FIRESTORE_TAG, "successfully Added!") }
                        .addOnFailureListener { e -> Log.w(FIRESTORE_TAG, "Error adding", e) }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FireBaseDataBaseTheme {
        Greeting("Android")
    }
}