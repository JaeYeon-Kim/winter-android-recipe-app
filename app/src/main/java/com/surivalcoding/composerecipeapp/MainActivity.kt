package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.presentation.RequestNotificationPermission
import com.surivalcoding.composerecipeapp.presentation.navigation.Route
import com.surivalcoding.composerecipeapp.presentation.page.main.MainScreen
import com.surivalcoding.composerecipeapp.presentation.page.signin.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.page.signup.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.page.splash.SplashScreen
import com.surivalcoding.composerecipeapp.util.FirebaseTokenManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var firebaseTokenManager: FirebaseTokenManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        val navController = rememberNavController()
        var fcmToken by remember { mutableStateOf("") }

        RequestNotificationPermission {
            firebaseTokenManager.getToken { token ->
                Logger.e("App Start FCM TOKEN : $token")
                fcmToken = token ?: "토큰 가져오기 실패"
            }
        }


        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->

            // 첫 시작 Splash 부터
            NavHost(
                navController = navController,
                startDestination = Route.Splash
            ) {
                composable<Route.Splash> {
                    SplashScreen {
                        navController.navigate(Route.SignIn) {
                            popUpTo(Route.Splash) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }

                }

                composable<Route.SignIn> {
                    SignInScreen(
                        forgotPassWord = {},
                        signIn = {
                            // MainScreen 이동 처리 필요
                            navController.navigate(Route.Main) {
                                popUpTo(Route.SignIn) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        },
                        googleSignIn = {},
                        facebookSignIn = {},
                        signUp = {
                            navController.navigate(Route.SignUp) {
                                popUpTo(Route.SignIn) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable<Route.SignUp> {
                    SignUpScreen(
                        signUp = {
                            // SignIn 화면으로
                        },
                        googleSignIn = {},
                        facebookSignIn = {},
                        signIn = {
                            navController.navigate(Route.SignIn) {
                                popUpTo(Route.SignUp) {
                                    inclusive = true
                                }
                            }

                        }
                    )
                }

                composable<Route.Main> {
                    MainScreen()
                }
            }
        }
    }
}







