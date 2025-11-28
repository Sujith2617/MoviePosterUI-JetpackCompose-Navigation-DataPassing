package com.example.moviesposterui.ui


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun DetailScreen( navController: NavController,name: String, poster: String, rating: String) {


    val context = LocalContext.current
    
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()
        .verticalScroll(rememberScrollState())) {

        IconButton({navController.popBackStack()}) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "Arrow back"
            )
        }

        Card(modifier = Modifier.padding(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {


                AsyncImage(
                    model = poster,
                    contentDescription = name, modifier = Modifier
                        .fillMaxWidth().height(500.dp).clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    rating, fontSize = 20.sp, modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Blue
                )

                Button(
                    {
                        Toast.makeText(
                            context,
                            "Cant Play $name Due to Copyright",
                            Toast.LENGTH_SHORT
                        ).show()
                    }, modifier = Modifier.fillMaxWidth().padding(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF050505))
                )
                {
                    Text(
                        text = "Watch Now",
                        fontSize = 22.sp, textAlign = TextAlign.Center
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(6.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton({
                        Toast.makeText(context, "Cant Share $name ", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Share, contentDescription =
                                "share", Modifier.size(30.dp)

                        )
                    }

                    IconButton({
                        Toast.makeText(context, "Info Updating", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Info, contentDescription =
                                "share", Modifier.size(30.dp)
                        )
                    }
                    IconButton({
                        Toast.makeText(
                            context,
                            "Added $name to Favorites ",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Favorite, contentDescription =
                                "share", Modifier.size(30.dp)
                        )
                    }
                }

                Text(
                    "This movie takes you on an unforgettable journey filled with emotion, action, " +
                            "and powerful storytelling. With breathtaking visuals and a gripping narrative," +
                            " it explores themes of courage, ambition, love, and sacrifice. " +
                            "Each scene is crafted to keep the audience engaged," +
                            " building suspense while delivering impactful performances." +
                            " From intense moments to heartfelt emotions, this film promises" +
                            " an immersive cinematic experience that will stay with you long after the credits roll.",
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun PreviewDetail(){
    val fakeName = "nothing"
    val fakePoster = "nothing"
    val fakeRating = "nothing"

    val fakeNavController = rememberNavController()

    DetailScreen(fakeNavController,fakeName, fakePoster, fakeRating)
}

