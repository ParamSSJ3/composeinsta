package com.example.instagramclone.repository

import com.example.instagramclone.model.User

@Suppress("UNREACHABLE_CODE")
class StoryRepository {
    fun getAllStories():List<User>{
        return listOf(
            User (
                1,
                "Shlok",
                "https://bit.ly/3T0t35G"
            ),
                    User(
                    2,
            "Ajey Nagar",
            "https://bit.ly/3CriWQG"
        ),
        User(
            3,
            "Adarsh singh",
            "https://bit.ly/3rELXTM"
        ),
        User(
            4,
            "harsh",
            "https://bit.ly/3fYah0w"
        ),
        User(
            5,
            "virat.kohli",
            "https://bit.ly/3EroL2S"
        ),
        User(
            6,
            " Tommy",
            "https://bit.ly/3ChKkAh"
        )

        )

    }
}