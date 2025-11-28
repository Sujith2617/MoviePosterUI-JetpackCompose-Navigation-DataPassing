package com.example.moviesposterui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesposterui.ui.components.MovieCard
import com.example.moviesposterui.viewModel.MoviesDataViewModel

@Composable
fun ListScreen(viewModel: MoviesDataViewModel, navController: NavController){

    LazyVerticalGrid(modifier = Modifier.fillMaxSize().systemBarsPadding(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)) {

        items(viewModel.movies)
        { movies ->

            MovieCard(movies, navController)

        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainActivityListScreen(){

}

