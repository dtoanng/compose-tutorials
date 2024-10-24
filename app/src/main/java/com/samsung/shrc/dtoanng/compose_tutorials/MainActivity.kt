package com.samsung.shrc.dtoanng.compose_tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.samsung.shrc.dtoanng.compose_tutorials.ui.ActionSection
import com.samsung.shrc.dtoanng.compose_tutorials.ui.CardSection
import com.samsung.shrc.dtoanng.compose_tutorials.ui.SpendingSection
import com.samsung.shrc.dtoanng.compose_tutorials.ui.TopBar
import com.samsung.shrc.dtoanng.compose_tutorials.ui.theme.ComposeTutorialsTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialsTheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        TopBar(
                            modifier = Modifier.fillMaxWidth(), scrollBehavior = scrollBehavior
                        )
                    },
                ) { paddingValues ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    )
                }
            }
        }
    }

    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {

        Column(modifier = modifier.verticalScroll(rememberScrollState())) {

            Spacer(modifier = Modifier.height(25.dp))

            CardSection(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))

            ActionSection(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))

            SpendingSection(modifier = Modifier.fillMaxWidth())
        }
    }
}

fun randomColor(minBrightness: Int = 40): Color {
    val random = Random.Default
    val maxBrightness = 256

    val red = random.nextInt(minBrightness, maxBrightness)
    val green = random.nextInt(minBrightness, maxBrightness)
    val blue = random.nextInt(minBrightness, maxBrightness)

    return Color(red, green, blue).copy(alpha = 0.2f)
}