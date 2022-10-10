package com.example.instagramclone.model

import androidx.compose.runtime.Immutable

@Immutable
data class Comments(
    val user:String,
    val comment:String
)
