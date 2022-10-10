package com.example.instagramclone


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.instagramclone.ui.theme.InstagramCloneTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneTheme {
                // A surface container using the 'background' color from the theme
                val systemUiController= rememberSystemUiController()
              SideEffect {
                  systemUiController.setSystemBarsColor(
                      color= Color.Black
                  )
              }
            }
            HomeScreen()
            Navigation()
        }
    }
}


//Bottom navigation bar code.

@Composable
fun NavigationController(navController: NavHostController){
NavHost(navController = navController, startDestination = NavigationItem.Home.route){
    composable(NavigationItem.Home.route){
        HomeScreen()
    }
    composable(NavigationItem.Search.route){
        FamousActorsScreen()
    }
    composable(NavigationItem.Notifications.route){
        Notifications()
    }
    composable(NavigationItem.Profile.route){
        Profile()
    }
}
}





@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation() {
val navController = rememberNavController()
    val items = listOf(NavigationItem.Home,NavigationItem.Search,NavigationItem.Notifications,NavigationItem.Profile)
    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

            items.forEach{
               BottomNavigationItem(selected = currentRoute == it.route,
                   label = {
                           Text(text = it.label)
                   },
                   icon = {
                          Icon(imageVector = it.icons, contentDescription = null
                          )
                   }
                   , onClick = {if (currentRoute!=it.route)
                   {navController.graph?.startDestinationRoute?.let {
                       navController.popBackStack(it,true)
                   }
                       navController.navigate(it.route){
                           launchSingleTop = true
                       }
                   }
                   })
            }
    }
    }) {
        NavigationController(navController = navController)
    }
}


@Composable
fun Notifications() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Notifications")
    }
}

@Composable
fun Profile() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Profile")
    }
}





//Search bar details


val actorsList = listOf(
    "Leonardo DiCaprio",
    "Chris Evans",
    "Brad Pitt",
    "Elizabeth Olsen",
    "Kate Winslet",
    "Tom Holland",
    "Joseph Gordon-Levitt",
    "Scarlett Johansson",
    "Anne Hathaway",
    "Meryl Streep",
    "Tom Hardy",
    "Tom Cruise",
    "Sandra Bullock",
    "Charlize Theron",
    "Dakota Johnson",
    "James Franco",
    "Paul Rudd",
    "Jennifer Lawrence",
    "Benedict Cumberbatch",
    "Hugh Jackman",
    "Tom Hiddleston",
    "Anna Kendrick",
    "Daniel Craig",
    "Shah Rukh Khan",
    "Will Smith",
    "George Clooney",
    "Liam Neeson",
    "Angelina Jolie",
    "Michael Fassbender",
    "Idris Elba",
    "Russell Crowe",
    "Ryan Gosling",
    "Ben Affleck",
    "Chris Hemsworth",
    "Margot Robbie",
    "Emma Stone",
    "Natalie Portman",
    "Tom Hanks",
    "Denzel Washington",
    "Mark Wahlberg",
    "Matt Damon",
    "Chris Pratt",
    "Samuel L. Jackson",
    "Johnny Depp",
    "Robert Downey Jr",
    "Christian Bale",
    "Matthew McConaughey",
    "Morgan Freeman",
    "Jake Gyllenhaal",
    "Jeremy Renner",
    "Dwayne Johnson",
    "Michael B. Jordan",
    "Mark Ruffalo",
    "Jesse Eisenberg",
    "Keanu Reeves",)