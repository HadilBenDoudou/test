package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.screens.bienvenu
import com.example.myapplication.presentation.screens.chose
import com.example.myapplication.presentation.screens.AddChildScreen
import com.example.myapplication.presentation.screens.ApplicationList
import com.example.myapplication.presentation.screens.ChildDashboard2Screen
import com.example.myapplication.presentation.screens.ChildDashboard3Screen
import com.example.myapplication.presentation.screens.ChildDashboardScreen
import com.example.myapplication.presentation.screens.ConfirmProfileScreen
import com.example.myapplication.presentation.screens.CongratsWizardEnd2Screen
import com.example.myapplication.presentation.screens.CongratsWizardEndScreen
import com.example.myapplication.presentation.screens.LoginScreen
import com.example.myapplication.presentation.screens.addDevice
import com.example.myapplication.presentation.screens.addProfile
import com.example.myapplication.presentation.screens.login2
import com.example.myapplication.presentation.screens.login3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "loginScreen"
    ) {
        composable("loginScreen") { LoginScreen(navController) }
        composable("login2") { login2(navController) }
        composable("login3") { login3(navController) }
        composable("chose") { chose(navController) }
        composable("bienvenu") { bienvenu(navController) }
        composable("addDevice") { addDevice(navController) }
        composable("addProfile") { addProfile(navController) }
        composable("ConfirmProfileScreen") { ConfirmProfileScreen(navController) }
        composable("AddChildScreen") { AddChildScreen(navController) }
        composable("CongratsWizardEndScreen") { CongratsWizardEndScreen(navController) }
        composable("CongratsWizardEnd2Screen") { CongratsWizardEnd2Screen(navController) }
        composable("ApplicationList") { ApplicationList(navController) }
        composable("ChildDashboardScreen") { ChildDashboardScreen(navController) }
                composable("ChildDashboard2Screen") { ChildDashboard2Screen(navController) }
        composable("ChildDashboard3Screen") { ChildDashboard3Screen(navController) }




    }
}