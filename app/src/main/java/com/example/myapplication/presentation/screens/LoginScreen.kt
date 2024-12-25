package com.example.myapplication.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun LoginScreen(navController: NavController,modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFF3f63a9)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.microsoftteams_image__23__1),
                contentDescription = "4IN Shield Logo",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.welcome_john__sign_in_to_continue),
                contentDescription = "Welcome to 4IN Shield! Sign in to continue",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(50.dp)
                    .align(Alignment.Start)

            )
            Spacer(modifier = Modifier.height(24.dp))
            LoginButton("Sign in with Email", R.drawable.icon_mail_png_transparent_background_mail_logo_11562851894ksatrtd2da_1)
            Spacer(modifier = Modifier.height(12.dp))
            LoginButton("Sign in with Gmail", R.drawable.google_logo_1)
            Spacer(modifier = Modifier.height(12.dp))
            LoginButton("Sign in with Facebook", R.drawable.t_l_chargement_1)
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.no_account__sign_up),
                contentDescription = "No account? Sign up",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Start)
                    .clickable { navController.navigate("login2") }

            )
        }
    }
}

@Composable
fun LoginButton(text: String, iconRes: Int) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = text,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.chevron_right),
                contentDescription = "Arrow Right",
                modifier = Modifier.size(15.dp)
            )
        }
    }
}
