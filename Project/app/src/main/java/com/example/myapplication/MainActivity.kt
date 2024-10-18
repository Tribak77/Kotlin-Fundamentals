package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardContent()
                }
            }
        }
    }
}

@Composable
fun BusinessCardContent() {

    val background = painterResource(R.drawable.backgrouand)
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.logo1
        2 -> R.drawable.logo2
        else -> R.drawable.logo3
    }
    val descriptionText = when (result) {
        1 -> "The White Dove statue is located in a prominent roundabout in Tétouan, " +
                "welcoming visitors as they enter the city. The statue depicts a white " +
                "dove in flight and is surrounded by a beautifully landscaped garden " +
                "and palm trees."
        2 -> "This museum holds a significant collection of ancient artifacts, " +
                "including Roman mosaics, coins, ceramics, and tools found in the region. " +
                "It provides insight into the historical depth of the area, especially " +
                "from the Roman and pre-Islamic periods."
        else -> "The Medina of Tétouan is one of the most authentic and " +
                "well-preserved in Morocco. Its narrow streets, colorful markets, " +
                "and historic architecture reflect Andalusian, Arab, and Berber influences."
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = background,
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.7F
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString(),
                modifier = Modifier.size(120.dp)
            )

            BusinessCardLogoText(
                name = "Tetouan",
                title = descriptionText
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { result = (1..3).random() }) {
                Text(stringResource(R.string.roll))
            }
            Spacer(modifier = Modifier.height(20.dp))
            BusinessCardContact(
                phoneNumber = "+00 000 0000",
                emailAddress = "tetouan@gmail.com"
            )
        }

    }
}

@Composable
fun BusinessCardLogoText(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = name,
            fontSize = 40.sp,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Text(
            text = title,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun BusinessCardContact(phoneNumber: String, emailAddress: String, modifier: Modifier = Modifier) {
    val phoneIcon = painterResource(R.drawable.baseline_local_phone_24)
    val emailIcon = painterResource(R.drawable.baseline_email_24)

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Row {
            Icon(
                painter = phoneIcon,
                contentDescription = null,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = phoneNumber,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }

        Row {
            Icon(
                painter = emailIcon,
                contentDescription = null,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = emailAddress,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }

    }
}

@Preview(showBackground = true, name = "Business Card Preview", showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    MyApplicationTheme {
        BusinessCardContent()
    }
}
