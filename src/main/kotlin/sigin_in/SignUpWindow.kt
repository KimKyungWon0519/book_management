package sigin_in

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.svgResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
        InfoInput(
            idTextFieldState = idTextFIeldState,
            pwTextFieldState = pwTextFieldState,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Button(
                modifier = Modifier.weight(1.0f),
                onClick = {
                    val id = idTextFIeldState.textValueState.value.text
                    val pw = pwTextFieldState.textValueState.value.text

                    idTextFIeldState.errorState.value = id.isBlank()
                    pwTextFieldState.errorState.value = pw.isBlank()
                    
                    if(id.isNotBlank() && pw.isNotBlank()) {
                        print("로그인 성공")
                    }
                }) {
                Text("로그인")
            }
            Button(
                modifier = Modifier.weight(1.0f),
                onClick = {
                    print("버튼 클릭")
                }) {
                Text("회원가입")
            }
        }
    }
}