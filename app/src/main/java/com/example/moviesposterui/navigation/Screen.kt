package com.example.moviesposterui.navigation

import android.net.Uri


sealed class Screen(val route: String){

    object ListScreen : Screen("listScreen")

    object DetailScreen : Screen("detailScreen/{name}/{poster}/{rating}"){
        fun passingData(name : String ,poster: String,rating:String): String{

            val encodeUrl = Uri.encode(poster)

            return "detailScreen/$name/$encodeUrl/$rating"
        }
    }

}