package com.simple.agecalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.simple.agecalculator.ui.theme.AccentColor
import com.simple.agecalculator.ui.theme.DarkBackgroundColor
import com.simple.agecalculator.ui.theme.DarkContentColor
import com.simple.agecalculator.ui.theme.DarkForegroundColor
import com.simple.agecalculator.ui.theme.DarkTextColor

private val shortDescription =
    "To calculate your age, simply select your birthdate using the button above. Then, just tap the arrow button at the bottom, and your age will be calculated and displayed instantly. Quick and easy!"

@Composable
fun HomePage(
    dateText: String = "DD-MM-YYYY",
    onClick: () -> Unit = {},
    onClickCalc: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBackgroundColor)
            .padding(12.dp)
    ) {

        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 100.dp),
            text = "Let's Find Out \nYour Real Age",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )

        BodySection(
            modifier = Modifier.align(Alignment.Center),
            dateText = dateText,
            onClick = { onClick() }
        )

        CalculateButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = {
                onClickCalc()
            },
            dateText = dateText
        )
    }
}

@Composable
fun BodySection(modifier: Modifier = Modifier, dateText: String, onClick: () -> Unit) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(14.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(DarkContentColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "date of birth".uppercase(),
            color = DarkTextColor,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(30.dp))

        DatePickerButton(onClick = { onClick() }, dateText = dateText)

        Text(
            modifier = Modifier.padding(35.dp),
            text = shortDescription,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun DatePickerButton(onClick: () -> Unit, dateText: String) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(18.dp))
            .background(color = DarkForegroundColor)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple()
            ) {
                // TODO: open date picker
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            modifier = Modifier.padding(18.dp),
            text = dateText,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )

        Image(
            painter = painterResource(id = R.drawable.event_24),
            contentDescription = "Date picker"
        )

        Spacer(modifier = Modifier.width(18.dp))
    }
}

@Composable
fun CalculateButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    dateText: String
) {

    Button(
        modifier = modifier,
        onClick = {
            // TODO: Calculate age
            onClick()
        },
         colors = ButtonColors(
             contentColor = Color.White,
             containerColor = AccentColor,
             disabledContentColor = DarkForegroundColor,
             disabledContainerColor = DarkContentColor
         ),
        enabled = dateText != "DD-MM-YYYY"
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_forward_24px),
            contentDescription = "Calculate"
        )
    }
}