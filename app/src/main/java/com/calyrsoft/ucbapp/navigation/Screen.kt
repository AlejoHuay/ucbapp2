package com.calyrsoft.ucbapp.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Github: Screen("github")
    object Profile: Screen("profile")
    object CardExamples: Screen("card")
    object Dollar: Screen("dollar")
}
