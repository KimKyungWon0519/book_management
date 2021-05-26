package sigin_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.svgResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun InfoInput(
    idTextFieldState : TextFieldStateStruct,
    pwTextFieldState : TextFieldStateStruct,
) {
    val passwordVisibility = remember { mutableStateOf(true) }
    var image =
        if (passwordVisibility.value) svgResource("images/visibility.svg")
        else svgResource("images/visibility_off.svg")
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TextField(
            textState = idTextFieldState.textValueState.value,
            errorState = idTextFieldState.errorState.value,
            label = "ID",
            onValueChange = {
                idTextFieldState.textValueState.value = it
            }
        )
        TextField(
            textState = pwTextFieldState.textValueState.value,
            errorState = pwTextFieldState.errorState.value,
            label = "PW",
            visibility = passwordVisibility.value,
            onValueChange = {
                pwTextFieldState.textValueState.value = it
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
    }
}