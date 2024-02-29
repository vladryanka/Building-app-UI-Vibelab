package com.smorzhok.lemonade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smorzhok.lemonade.ui.theme.LemonadeTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {
    var squeezeCount by remember { mutableStateOf(0) }
    var currentStep by remember { mutableStateOf(1) }
    var imageResource = R.drawable.lemon_tree
    var stringResource = R.string.select
    var stringResourceDescription = R.string.Lemontree
    if (currentStep>4)
    currentStep=1
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            when (currentStep) {
                1 -> {
                    imageResource = R.drawable.lemon_tree
                    stringResource = R.string.select
                    stringResourceDescription = R.string.Lemontree
                }
                2 -> {
                     imageResource = R.drawable.lemon_squeeze
                     stringResource = R.string.squeeze
                     stringResourceDescription = R.string.Lemon
                }
                3 -> {
                     imageResource = R.drawable.lemon_drink
                    stringResource = R.string.drink
                    stringResourceDescription = R.string.Glass
                }
                else -> {
                    imageResource = R.drawable.lemon_restart
                    stringResource = R.string.glass
                    stringResourceDescription = R.string.Empty_glass
                }
            }
            LemonTextAndImage(
                textLabelResourceId = stringResource,
                drawableResourceId = imageResource,
                contentDescriptionResourceId = stringResourceDescription,

                onImageClick = {
                    if (currentStep == 2)
                        squeezeCount = (2..4).random()
                    else squeezeCount--
                    currentStep++;
                })

    }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
