package com.example.myapplication.presentation.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R


@Composable
fun addProfile(navController: NavController) {
    var selectedPlatform by remember { mutableStateOf("Social network platform") }
    var userName by remember { mutableStateOf("") }
    var pageUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3f63a9))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.image3),
            contentDescription = "Social Media Icons",
            modifier = Modifier
                .size(120.dp)
                .padding(16.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Please enter your child’s social media account information",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            lineHeight = 22.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "This information will help us to protect your child from online abusive content and cyberharassment",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))
        DropdownMenu(selectedPlatform) { platform ->
            selectedPlatform = platform
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userName,
            onValueChange = { userName = it },
            placeholder = { Text("Social network user name") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = pageUrl,
            onValueChange = { pageUrl = it },
            placeholder = { Text("Social network page URL") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Uri),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(text = "Skip", color = Color(0xFF4169E1))
            }
            Button(
                onClick = { navController.navigate("ConfirmProfileScreen") },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Next",
                    color = Color(0xFF3A6AB7),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "Right Icon",
                    tint = Color(0xFF3A6AB7),
                    modifier = Modifier.size(10.dp)
                )
            }
        }
    }
}

@Composable
fun DropdownMenu(selectedPlatform: String, onSelectionChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val platforms = listOf("Facebook", "Instagram", "Twitter", "Snapchat")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        TextButton(onClick = { expanded = !expanded }) {
            Text(text = selectedPlatform, color = Color.Black)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            platforms.forEach { platform ->
                DropdownMenuItem(
                    text = { Text(platform) },
                    onClick = {
                        onSelectionChange(platform)
                        expanded = false
                    }
                )
            }
        }
    }
}
