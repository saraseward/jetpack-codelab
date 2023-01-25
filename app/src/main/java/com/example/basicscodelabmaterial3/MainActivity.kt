package com.example.basicscodelabmaterial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

    var showOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (showOnboarding) {
            OnboardingScreen(onContinueClicked = { showOnboarding = false })
        } else {
            Greetings(names = List(50) { "$it" })
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
    val context = LocalContext.current
    BasicsCodelabMaterial3Theme {
        OnboardingScreen(onContinueClicked = {
            showToast(context, "Yay!")// Toast.makeText(context, "Yay!", Toast.LENGTH_SHORT).show()
        })
    }
}