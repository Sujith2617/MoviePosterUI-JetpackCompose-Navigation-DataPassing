package com.example.moviesposterui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesposterui.ui.DetailScreen
import com.example.moviesposterui.ui.ListScreen
import com.example.moviesposterui.viewModel.MoviesDataViewModel

@Composable
fun SetupNavGraph(viewModel: MoviesDataViewModel){

    val navController = rememberNavController()

    NavHost(navController = navController,

        startDestination = Screen.ListScreen.route)
    {

        composable(Screen.ListScreen.route){
            ListScreen(viewModel,navController)
        }

        composable(Screen.DetailScreen.route,
            arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("poster"){type = NavType.StringType},
                navArgument("rating"){type = NavType.StringType}
            ))
        {
            backStackEntry ->

            val name = backStackEntry.arguments?.getString("name") ?:""

            val poster = backStackEntry.arguments?.getString("poster")?:""

            val rating =backStackEntry.arguments?.getString("rating")?:""

            DetailScreen(navController = navController,name,poster,rating)

        }


    }



}