package com.example.myapplication.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
object AppColors {
    val Primary = Color(0xFF3A5BA8)
    val Secondary = Color.White
    val Danger = Color(0xFFFF5252)
}

@Composable
fun ChildDashboardScreen(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("DASHBOARD", "PHONE USAGE", "SOCIAL MEDIA", "ALERTS")
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Primary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                DashboardTopBar()
                ProfileSection()
                TimePeriodSelector()
                StatsGrid()
                DashboardContent()
            }

            BottomNavigationBar(tabs, selectedTab, navController) { index -> selectedTab = index }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopBar() {
    TopAppBar(
        title = { Text("Child first name", color = AppColors.Secondary) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = AppColors.Secondary)
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Person, contentDescription = "Profile", tint = AppColors.Secondary)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = AppColors.Primary)
    )
}

@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(AppColors.Secondary)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_placeholder2),
                contentDescription = "Profile Image",
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "First name Last name",
            color = AppColors.Secondary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            "AGE",
            color = AppColors.Secondary.copy(alpha = 0.7f),
            fontSize = 12.sp
        )
    }
}

@Composable
fun TimePeriodSelector() {
    var selectedPeriod by remember { mutableStateOf("Day") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        listOf("Month", "Week", "Day").forEach { period ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (selectedPeriod == period) AppColors.Secondary else AppColors.Primary)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable { selectedPeriod = period }
            ) {
                Text(
                    text = period,
                    color = if (selectedPeriod == period) AppColors.Primary else AppColors.Secondary.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
            }
            if (period != "Day") Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun StatsGrid() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatCard(
                title = "Danger Level",
                value = "High",
                valueColor = AppColors.Danger,
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
            )
            StatCard(
                title = "Last night sleep duration",
                value = "8h",
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatCard(
                title = "Device usage",
                value = "4h",
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
            )
            StatCard(
                title = "Phone call duration",
                value = "4h",
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
            )
        }
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    valueColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = AppColors.Secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                title,
                fontSize = 12.sp,
                color = Color.Gray,
                lineHeight = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                value,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = valueColor
            )
        }
    }
}

@Composable
fun DashboardContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(AppColors.Secondary)
                .padding(16.dp)
        ) {
            AlertsSection()
        }
    }
}

@Composable
fun AlertsSection() {
    Column {
        Text(
            "Last Alerts",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        AlertItem(
            title = "Toxic comment!",
            description = "Mama always said life was like a box of chocolates. You never know what..",
            time = "12:34 PM"
        )
        Spacer(modifier = Modifier.height(8.dp))
        AlertItem(
            title = "Sleep deprivation!",
            description = "Mama always said life was like a box of chocolates. You never know what..",
            time = "12:34 PM"
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AlertItem(
    title: String,
    description: String,
    time: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = AppColors.Secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    title,
                    color = AppColors.Danger,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
                Text(
                    time,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                description,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun BottomNavigationBar(
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
