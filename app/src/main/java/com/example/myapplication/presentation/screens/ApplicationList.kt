package com.example.myapplication.presentation.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationList(navController: NavController) {
    var chromeEnabled by remember { mutableStateOf(true) }
    var cameraEnabled by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Parental Control", fontSize = 20.sp) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF3A5BA8),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.shape),
                            contentDescription = "Menu",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFb4bdd8)) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.square),
                            contentDescription = "Dashboard",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("DASHBOARD") },
                    selected = false,
                    onClick = { navController.navigate("ChildDashboardScreen") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.square),
                            contentDescription = "Control",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("CONTROL") },
                    selected = true,
                    onClick = { navController.navigate("ApplicationList") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.square),
                            contentDescription = "Social Media",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("SOCIAL MEDIA") },
                    selected = false,
                    onClick = { navController.navigate("ChildDashboard2Screen") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.square),
                            contentDescription = "Alerts",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("ALERTS") },
                    selected = false,
                    onClick = { navController.navigate("ChildDashboard3Screen") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3A5BA8))
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search", color = Color.White) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFF294683),
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedPlaceholderColor = Color.White,
                    unfocusedPlaceholderColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                AppControlItem(
                    appName = "Google Chrome",
                    appIcon = R.drawable.google_logo_1,
                    isEnabled = chromeEnabled,
                    onToggle = { chromeEnabled = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                AppControlItem(
                    appName = "Camera",
                    appIcon = R.drawable.camera_icon_1,
                    isEnabled = cameraEnabled,
                    onToggle = { cameraEnabled = it }
                )
            }
        }
    }
}

@Composable
fun AppControlItem(appName: String, appIcon: Int, isEnabled: Boolean, onToggle: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = appIcon),
            contentDescription = "$appName Icon",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = appName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = if (isEnabled) "On" else "Off",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Switch(
                checked = isEnabled,
                onCheckedChange = { onToggle(it) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF4CAF50),
                    uncheckedThumbColor = Color(0xFFDD2C00)
                )
            )
        }
    }
}
