package com.example.instagramclone.model

import androidx.compose.runtime.Immutable

@Immutable
data class Post(
    val imgUrl:String,
    val user:String,
    val likes:String,
    val caption:String,
    val profilePic:String,
    val comments:List<Comments>

)
