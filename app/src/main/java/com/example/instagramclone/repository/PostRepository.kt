package com.example.instagramclone.repository

import com.example.instagramclone.model.Comments
import com.example.instagramclone.model.Post

class PostRepository {
    fun getAllPosts():List<Post>{
        return listOf(
             Post(
                 "https://bit.ly/3CIKAd2",
             "GDSC",
             "180",
                 "Google Developer",
             "https://bit.ly/3SP4DQ",
                 listOf(
                     Comments( "Sushant","Support")
                 )
             ),
            Post(
                "https://bit.ly/3SGC7wB",
                "Shlok",
                "50",
                "Lion",
                "https://bit.ly/3CHdslU",
                listOf(
                    Comments( "Sushant","😍"),
                    Comments( "Peace","Nice one.")
                )
            ),
            Post(
                "https://bit.ly/3RNA1cU",
                "harsh",
                "90",
                "Nothing",
                "https://bit.ly/3rKvn53",
                listOf(
                    Comments( "Sushant","Nice"),
                    Comments( "Parag Sharma","Good setup.")
                )
            )
        )
    }
}