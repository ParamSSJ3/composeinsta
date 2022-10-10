package com.example.instagramclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.instagramclone.model.Post
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Post(posts:List<Post>){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(top = 5.dp, bottom = 10.dp)) {
        LazyColumn(state = rememberLazyListState(),
        modifier= Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
            items(items = posts){post ->
                PostItem(post = post)
            }
        }

    }
}




@Composable
fun PostItem(post: Post){
val context= LocalContext.current


       Row(modifier =Modifier.wrapContentWidth()) {
        Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
            .crossfade(true)
            .data(post.profilePic)
            .build(),
        filterQuality = FilterQuality.High), contentDescription =null ,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .size(32.dp)
            .clip(shape = CircleShape))
           Text(text = post.user, color = Color.White, modifier = Modifier
               .padding(start = 5.dp)
               .align(Alignment.CenterVertically))
           Row(modifier = Modifier
               .fillMaxWidth()
               .wrapContentSize(align = Alignment.TopStart)) {
      Text(text = "...", color = Color.White, fontSize = 24.sp,
    modifier = Modifier.padding(5.dp))
               
           }
    }
    Spacer(modifier = Modifier.height(10.dp))

    Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
        .crossfade(true)
        .data(post.imgUrl)
        .build(),
        filterQuality = FilterQuality.High), contentDescription =null ,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxHeight()
            .height(350.dp)
            .clip(shape = RoundedCornerShape(4.dp))
    )

    Row() {
        Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
            .crossfade(true)
            .data("https://img.icons8.com/fluency-systems-regular/60/ffffff/like.png")
            .build(),
            filterQuality = FilterQuality.High), contentDescription =null ,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .size(32.dp)
                .clip(shape = CircleShape))

        Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
            .crossfade(true)
            .data("https://img.icons8.com/material-outlined/60/ffffff/speech.png")
            .build(),
            filterQuality = FilterQuality.High), contentDescription =null ,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .size(32.dp)
                .clip(shape = CircleShape))

        Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
            .crossfade(true)
            .data("https://img.icons8.com/material-outlined/344/ffffff/share.png")
            .build(),
            filterQuality = FilterQuality.High), contentDescription =null ,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .size(32.dp)
                .clip(shape = CircleShape))

        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(align = Alignment.TopEnd)) {
            Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
                .crossfade(true)
                .data("https://img.icons8.com/material-outlined/344/ffffff/bookmark-ribbon--v1.png")
                .build(),
                filterQuality = FilterQuality.High), contentDescription =null ,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .size(32.dp)
                    .clip(shape = CircleShape))
        }
    }
    Text(text = "${post.likes}", color = Color.White, fontSize = 12.sp)
    Row {
        Text(text = post.user, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = post.caption, color = Color.White, fontSize = 10.sp, modifier =
        Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(2.dp))
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        val commentCount=post.comments
        if(commentCount.isEmpty()){
            Text(text = "no comment yet", color = Color.White, fontSize = 12.sp)
        }else if (commentCount.size==1){
            Text(text = "View 1 Comment",color = Color.White, fontSize = 12.sp)
        }else{
            Text(text = "View all ${commentCount.size}",color = Color.White, fontSize = 12.sp)
        }

    }
}