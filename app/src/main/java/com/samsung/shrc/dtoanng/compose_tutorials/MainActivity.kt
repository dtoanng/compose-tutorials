package com.samsung.shrc.dtoanng.compose_tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.samsung.shrc.dtoanng.compose_tutorials.ui.Screen
import com.samsung.shrc.dtoanng.compose_tutorials.ui.Screen1
import com.samsung.shrc.dtoanng.compose_tutorials.ui.Screen2
import com.samsung.shrc.dtoanng.compose_tutorials.ui.Screen3
import com.samsung.shrc.dtoanng.compose_tutorials.ui.Screen4
import com.samsung.shrc.dtoanng.compose_tutorials.ui.theme.ComposeTutorialsTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Screen1,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } }
    ) {

        composable<Screen.Screen1> {
            Screen1(goToNextToScreen = {
                navController.navigate(Screen.Screen2(id = 10))
            })
        }
        composable<Screen.Screen2> { backStackEntry ->
            val screen2: Screen.Screen2 = backStackEntry.toRoute()

            Screen2(
                id = screen2.id,
                goToNextToScreen = {
                    navController.navigate(Screen.Screen3)
                })
        }
        composable<Screen.Screen3> {
            Screen3(goToNextToScreen = {
                navController.navigate(Screen.Screen4)
            })
        }
        composable<Screen.Screen4> { backStackEntry ->
            val screen1: Screen.Screen1 = backStackEntry.toRoute()
            Screen4(onGoBack = {
                navController.clearBackStack(route = screen1)
                Timber.d("backStackEntry Size: ${backStackEntry.destination}")
            })
        }
    }
}