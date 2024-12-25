package com.example.myapplication.presentation.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun ConfirmProfileScreen(navController: NavController) {
    val facebookBlue = Color(0xFF4267B2)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(facebookBlue)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 90.dp)
        ) {
            Text(
                text = "Your child's profile\ninformation has been\nsuccessfully added",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )

            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "vector",
                modifier = Modifier
                    .size(109.dp)
                    .offset(x = 2.dp, y = 24.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(start = 59.dp, top = 30.dp, end = 59.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.zIndex(0f)
            ) {
                val profileImages = listOf(
                    R.drawable.profile_placeholder1,
                    R.drawable.profile_placeholder2,
                    R.drawable.profile_placeholder3,
                    R.drawable.profile_placeholder4
                )

                items(profileImages) { imageRes ->
                    Card(
                        modifier = Modifier
                            .size(width = 104.dp, height = 105.dp)
                            .shadow(4.dp, RoundedCornerShape(6.dp)),
                        shape = RoundedCornerShape(6.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Profile Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .zIndex(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "Instagram",
                    modifier = Modifier
                        .size(77.23.dp)
                        .offset(x = 10.dp, y = -45.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier
                        .size(70.27.dp)
                        .offset(x = -19.dp, y = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_twitter),
                    contentDescription = "Twitter",
                    modifier = Modifier
                        .size(70.54.dp)
                        .offset(x = 44.dp, y = 10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Button(
                onClick = { navController.navigate("AddChildScreen") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(149.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Add new profile",
                    color = facebookBlue,
                    fontSize = 14.sp,
                )
            }
            Button(
                onClick = { navController.navigate("main") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(138.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Continue",
                        color = facebookBlue,
                        fontSize = 14.sp,
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Continue",
                        tint = facebookBlue
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { navController.navigate("modify_profile") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(205.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Modify profile information",
                    fontSize = 14.sp,
                    color = facebookBlue
                )
            }
        }
    }
}
