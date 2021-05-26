package sigin_in

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextField(
    textState: TextFieldValue,
    errorState: Boolean = false,
    visibility: Boolean = false,
    label: String,
    onValueChange: (TextFieldValue) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null
) = androidx.compose.material.TextField(
    value = textState,
    modifier = Modifier.fillMaxWidth(),
    isError = errorState,
    visualTransformation = if (visibility) PasswordVisualTransformation() else VisualTransformation.None,
    label = {
        Text(if (errorState) "Input $label" else "$label")
    },
    onValueChange = onValueChange,
    trailingIcon = trailingIcon,
)