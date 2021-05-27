package sigin_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignButtonPanel(
    idTextFIeldState : TextFieldStateStruct,
    pwTextFieldState : TextFieldStateStruct
) =
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

                if (id.isNotBlank() && pw.isNotBlank()) {
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
