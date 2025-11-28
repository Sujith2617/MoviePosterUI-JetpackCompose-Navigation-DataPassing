package com.example.moviesposterui.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.moviesposterui.Data.Movie
import com.example.moviesposterui.navigation.Screen


@Composable
fun MovieCard(movie: Movie,navController: NavController){


    Card(modifier = Modifier.wrapContentHeight()
        .padding(6.dp),
        elevation = CardDefaults.cardElevation(9.dp),
        onClick = {
            navController.navigate(Screen.DetailScreen.
            passingData(movie.name,movie.posterUrl,movie.rating))
        })
    {

        AsyncImage(model = movie.posterUrl,
            contentDescription = movie.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(260.dp)
                .clip(shape = RoundedCornerShape(4.dp))
        )

        Text(movie.name, modifier = Modifier.padding(5.dp), fontWeight = FontWeight.Bold)
        Text(movie.rating, modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue
        )


    }

}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {

    val  fakeNavController = rememberNavController()
    MovieCard(movie = Movie("New Movie",
        "https://image.tmdb.org/t/p/original/bBOqSIIy72mWekwweNg0iqJw8Ot.jpg",
        "9.7"),fakeNavController)

}