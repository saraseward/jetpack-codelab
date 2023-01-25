package com.example.basicscodelabmaterial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelabmaterial3.ui.theme.BasicsCodelabMaterial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabMaterial3Theme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

// ------------------------------------------------------------------------
// MyApp
// ------------------------------------------------------------------------
@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var showOnboarding by remember { mutableStateOf(true) }

    Surface(modifier) {
        if (showOnboarding) {
            OnboardingScreen(onContinueClicked = { showOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun MyAppPreview() {
    BasicsCodelabMaterial3Theme {
        MyApp(Modifier.fillMaxSize())
    }
}

// ------------------------------------------------------------------------
// Onboarding
// ------------------------------------------------------------------------
@Composable
private fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Welcome to this very beautiful app")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabMaterial3Theme {
        OnboardingScreen()
    }
}

// ------------------------------------------------------------------------
// Greetings
// ------------------------------------------------------------------------
@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    var expanded by remember { mutableStateOf(false) }

    val extraPadding = if (expanded) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
//        Column() {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text("Hello $name")
                Text("You are $name")
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
//        if (expanded.value){
//            Row(modifier = Modifier.padding(24.dp)){
//                Text(if (expanded.value) "Show less" else "Show more")
//            }
//        }}
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
private fun GreetingsPreview() {
    BasicsCodelabMaterial3Theme {
        Greetings()
    }
}