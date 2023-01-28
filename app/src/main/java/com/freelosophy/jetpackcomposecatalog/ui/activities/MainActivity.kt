package com.freelosophy.jetpackcomposecatalog.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.freelosophy.jetpackcomposecatalog.ui.animations.ColorAnimationAdvanced
import com.freelosophy.jetpackcomposecatalog.ui.animations.ColorAnimationSimple
import com.freelosophy.jetpackcomposecatalog.ui.animations.SizeAnimation
import com.freelosophy.jetpackcomposecatalog.ui.animations.VisibilityAnimation
import com.freelosophy.jetpackcomposecatalog.ui.model.Routes
import com.freelosophy.jetpackcomposecatalog.ui.navigation.Screen2
import com.freelosophy.jetpackcomposecatalog.ui.navigation.Screen3
import com.freelosophy.jetpackcomposecatalog.ui.navigation.Screen4
import com.freelosophy.jetpackcomposecatalog.ui.navigation.Screen5
import com.freelosophy.jetpackcomposecatalog.ui.screens.LoginScreen
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme
import com.freelosophy.jetpackcomposecatalog.ui.viewmodels.LoginViewModel
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            JetpackComposeCatalogTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
////                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    var show by remember { mutableStateOf(false) }
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Button(
//                            onClick = { show = true}
//                        ){
//                            Text("Mostrar diálogo")
//                        }
//                        MyConfirmationDialog(
//                            show = show,
//                            onDismiss = { show = false },
////                            onConfirm = { Log.i("Alert", "click") }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}

/**
 * Válido a partir de LazyColumn o RecyclerView en JetpackCompose
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Screen1.route
                    ) {
                        // Se añade aquí para poder verlo en acción ;)
                        composable(Routes.Screen1.route) { VisibilityAnimation() }
                        //composable(Routes.Screen1.route) { LoginScreen(loginViewModel) }
                        composable(Routes.Screen2.route) { Screen2(navigationController) }
                        composable(Routes.Screen3.route) { Screen3(navigationController) }
                        composable(
                            Routes.Screen4.route,
                            arguments = listOf(navArgument("age") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.Screen5.route,
                            arguments = listOf(navArgument("name") { defaultValue = "Pepe" })
                        ) {
                            Screen5(
                                navigationController,
                                it.arguments?.getString("name")
                            )
                        }
                    }
//                        SimpleRecyclerView()
//                    ScaffoldExample()
                }
            }
        }
    }
}