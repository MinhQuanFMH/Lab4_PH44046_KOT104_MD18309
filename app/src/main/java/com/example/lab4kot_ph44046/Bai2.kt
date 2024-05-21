package com.example.lab4kot_ph44046

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            HomeScreen()
        }
    }
}
@Preview
@Composable
fun PreviewScreen(){
    HomeScreen()
}
@Composable
fun HomeScreen(){
    val capybara= listOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4)
    val turtle= listOf(R.drawable.timage1,R.drawable.timage2,R.drawable.timage3,R.drawable.timage4)
    Column (modifier = Modifier.background(color = Color(0xFFD7F9FA))) {
        Image(painter = painterResource(id = R.drawable.logomau), contentDescription = "Logo", modifier = Modifier.padding(horizontal = 80.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Capybara",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive, color = Color(0xFF5D7B6F)
            )}
        HorizontalImageList(imageList = capybara)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Turtle",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive, color = Color(0xFF5D7B6F)
            )}
        VerticalImageList(imageList = turtle)
    }
}
@Composable
fun HorizontalImageList (imageList: List<Int>){
    val ScrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .background(color = Color(0xFFEAD7E6))
            .fillMaxWidth()
    ){
        Row (
            modifier = Modifier
                .horizontalScroll(ScrollState)
                .padding(16.dp)

        ){
            imageList.forEachIndexed{ index, image ->
                Image(painter = painterResource(id = image), contentDescription = "image Description",
                    contentScale = ContentScale.FillHeight, modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .padding(
                            start = if (index == 0) 0.dp else 8.dp,
                            end = 8.dp
                        )
                )
            }
        }
    }

}
@Composable
fun VerticalImageList (imageList: List<Int>){
    val ScrollState = rememberScrollState()
    Box(
        modifier = Modifier.height(250.dp)
            .background(color = Color(0xFFA4C3A2))
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(ScrollState)
                .padding(20.dp)
        ){
            imageList.forEachIndexed{ index, image ->
                Image(painter = painterResource(id = image), contentDescription = " Image Description",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .padding(
                            top = if (index == 0) 0.dp else 10.dp,
                            bottom = 10.dp
                        ))
            }
        }}
}