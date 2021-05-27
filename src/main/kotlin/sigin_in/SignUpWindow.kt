package sigin_in

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun SignUpWindow() = Window(title = "로그인", size = IntSize(500, 250)) {
    val idTextFIeldState = TextFieldStateStruct(
        textValueState = remember { mutableStateOf(TextFieldValue()) },
        errorState = remember { mutableStateOf(false) })
    val pwTextFieldState = TextFieldStateStruct(
        textValueState = remember { mutableStateOf(TextFieldValue()) },
        errorState = remember { mutableStateOf(false) })

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
    ) {
        InfoInputPanel(
            idTextFieldState = idTextFIeldState,
            pwTextFieldState = pwTextFieldState,
        )
        SignButtonPanel(
            idTextFIeldState = idTextFIeldState,
            pwTextFieldState = pwTextFieldState,
        )
    }
}