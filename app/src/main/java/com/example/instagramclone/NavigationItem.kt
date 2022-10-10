package com.example.instagramclone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route:String,val label:String,val icons:ImageVector)
{
    object Home : NavigationItem("home","Home", Icons.Default.Home)
    object Search: NavigationItem("search","Search", Icons.Default.Search)
    object Notifications: NavigationItem("notifications","Notifications", Icons.Default.Notifications)
    object Profile : NavigationItem("profile","Profile", Icons.Default.AccountCircle)
}