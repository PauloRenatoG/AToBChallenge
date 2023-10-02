package com.example.atobchallenge.ui.design

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.atobchallenge.ui.theme.AToBChallengeTheme
import com.example.atobchallenge.ui.theme.Typography

@Composable
fun ErrorMessage(message: String) {

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = message,
            color = Color.Red,
            style = Typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun ErrorMessagePreview() {
    AToBChallengeTheme {
        ErrorMessage(message = "No connection!")
    }
}
