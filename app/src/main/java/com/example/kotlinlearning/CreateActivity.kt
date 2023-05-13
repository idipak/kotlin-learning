package com.example.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinlearning.models.BoardSIze
import com.example.kotlinlearning.utils.EXTRA_BOARD_SIZE

class CreateActivity : AppCompatActivity() {

    private lateinit var boardSIze: BoardSIze

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        boardSIze = intent.getSerializableExtra(EXTRA_BOARD_SIZE) as BoardSIze
        supportActionBar?.title = "Choose pics (0 / 12)"
    }
}