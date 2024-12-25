package com.example.myapplication.presentation.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.myapplication.R

object AppColor {
    val Primary = Color(0xFF4267B2)
    val Secondary = Color.White
    val CardBackground = Color(0xFFF1F1F1)
}

@Composable
fun ChildDashboard2Screen(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("DASHBOARD", "PHONE USAGE", "SOCIAL MEDIA", "ALERTS")
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Primary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            CustomTopBar()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(containerColor = AppColor.CardBackground)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            "Mental State",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.background),
                            contentDescription = "Mental State Graph",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(containerColor = AppColor.CardBackground)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            "Last social media activities",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        SocialMediaActivity(
                            name = "Rebecca Morgan",
                            message = "Mama always said life was like a box of chocolates. You never know what...",
                            time = "12:34 PM"
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        SocialMediaActivity(
                            name = "Justin Holmes",
                            message = "You don't understand! I coulda had class. I coulda been a contender. I could've...",
                            time = "12:11 PM"
                        )
                    }
                }
            }
            BottomNavigationBar2(tabs, selectedTab, navController) { index -> selectedTab = index }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    TopAppBar(
        title = { Text("Child first name", color = AppColor.Secondary) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = AppColor.Secondary)
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Person, contentDescription = "Profile", tint = AppColor.Secondary)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = AppColor.Primary)
    )
}

@Composable
fun SocialMediaActivity(name: String, message: String, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(AppColor.Primary.copy(alpha = 0.2f))
            )

            Column {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = message,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        Text(
            text = time,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun BottomNavigationBar2(
    tabs: List<String>,
    selectedTab: Int,
    navController: NavHostController,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.height(56.dp),
        containerColor = Color(0xFFb4bdd8),
        tonalElevation = 0.dp
    ) {
        tabs.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selectedTab == index,
                onClick = {
                    onTabSelected(index)
                    if (title == "DASHBOARD") {
                        navController.navigate("ChildDashboardScreen")
                    }
                    if (title == "PHONE USAGE") {
                        navController.navigate("ApplicationList")
                    }
                    if (title == "SOCIAL MEDIA") {
                        navController.navigate("ChildDashboard2Screen")
                    }
                    if (title == "ALERTS") {
                        navController.navigate("ChildDashboard3Screen")
                    }
                },
                label = { Text(text = title) },
                icon = {
                    val iconRes = when (title) {
                        "DASHBOARD" -> R.drawable.square
                        "PHONE USAGE" -> R.drawable.square
                        "SOCIAL MEDIA" -> R.drawable.square
                        "ALERTS" -> R.drawable.square
                        else -> R.drawable.square
                    }
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = title,
                        modifier = Modifier.size(32.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.White.copy(alpha = 0.7f),
                    unselectedTextColor = Color.White.copy(alpha = 0.7f),
                    indicatorColor = Color(0xFF3A5BA8)
                )
            )
        }
    }
}
