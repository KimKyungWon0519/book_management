package sigin_in

import androidx.compose.animation.expandHorizontally
import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val passwordVisibility = remember { mutableStateOf(true) }
    var image =
        if (passwordVisibility.value) svgResource("images/visibility.svg") else svgResource("images/visibility_off.svg")

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
    ) {
        TextField(
            value = textState.value,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("ID")
            },
            onValueChange = {
                textState.value = it
            })
        TextField(
            value = textState.value,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None,
            label = {
                Text("PW")
            },
            onValueChange = {
                textState.value = it
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }
                ) {
                    Icon(
                        painter = image,
                        contentDescription = null,
                    )
                }
            }
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Button(
                modifier = Modifier.weight(1.0f),
                onClick = {
                    print("버튼 클릭")
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