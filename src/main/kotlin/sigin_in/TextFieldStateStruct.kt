package sigin_in

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue

class TextFieldStateStruct(val textValueState : MutableState<TextFieldValue>, val errorState : MutableState<Boolean>) {}