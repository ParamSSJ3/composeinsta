package com.example.instagramclone.model

import androidx.compose.runtime.Immutable

@Immutable
data class User(
    val id:Long,
    val userName:String,
    val imgUrl:String
)
