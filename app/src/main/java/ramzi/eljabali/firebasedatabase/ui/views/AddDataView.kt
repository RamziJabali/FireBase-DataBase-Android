package ramzi.eljabali.firebasedatabase.ui.views

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import ramzi.eljabali.firebasedatabase.viewmodel.AddDataViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddDataView(addDataViewModel: AddDataViewModel) {
    val interActionSource1 = remember { MutableInteractionSource() }
    val interActionSource2 = remember { MutableInteractionSource() }
    val interActionSource3 = remember { MutableInteractionSource() }
    val interActionSource4 = remember { MutableInteractionSource() }
    val localFocusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "What is your name?")
        SingleUserInputTextBox(
            keyboardController = keyboardController,
            localFocusManager = localFocusManager,
            textBoxNumber = 0,
            viewModel = addDataViewModel,
            source = interActionSource1
        )
        Text(text = "Add Your Email")
        SingleUserInputTextBox(
            keyboardController = keyboardController,
            localFocusManager = localFocusManager,
            textBoxNumber = 1,
            viewModel = addDataViewModel,
            source = interActionSource2
        )
        Text(text = "What is one thing you would like to focus on?")
        SingleUserInputTextBox(
            keyboardController = keyboardController,
            localFocusManager = localFocusManager,
            textBoxNumber = 2,
            viewModel = addDataViewModel,
            source = interActionSource3
        )
        Text(text = "What is one habit you would like to do?")
        SingleUserInputTextBox(
            keyboardController = keyboardController,
            localFocusManager = localFocusManager,
            textBoxNumber = 3,
            viewModel = addDataViewModel,
            source = interActionSource3
        )
        var checked by remember { mutableStateOf(false) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
                addDataViewModel.updatedToggle(it)
            }
        )
        Button(onClick = {
            addDataViewModel.postButtonClicked()
        }
        ) {
            Text(text = "Post")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SingleUserInputTextBox(
    keyboardController: SoftwareKeyboardController?,
    localFocusManager: FocusManager,
    textBoxNumber: Int,
    viewModel: AddDataViewModel,
    source: MutableInteractionSource
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,
        singleLine = true,
        onValueChange = { changedText ->
            text = changedText
            viewModel.updatedText(changedText.text, textBoxNumber)

        },
        interactionSource = source,
        keyboardOptions = KeyboardOptions(
            keyboardType = getKeyboardTypeBasedOnTextBox(textBoxNumber),
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                if (!localFocusManager.moveFocus(FocusDirection.Down)) {
                    clearFocusAndHideKeyboard(keyboardController, localFocusManager)
                }
            },
            onPrevious = {
                localFocusManager.moveFocus(FocusDirection.Up)
            },
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Gray,
            unfocusedIndicatorColor = Color.LightGray,
        )
    )
}

private fun getKeyboardTypeBasedOnTextBox(textBoxNumber: Int): KeyboardType {
    if (textBoxNumber == 0) {
        return KeyboardType.Text
    }
    return KeyboardType.Number
}

@OptIn(ExperimentalComposeUiApi::class)
fun clearFocusAndHideKeyboard(
    keyboardController: SoftwareKeyboardController?,
    localFocusManager: FocusManager
) {
    keyboardController?.hide()
    localFocusManager.clearFocus()
}