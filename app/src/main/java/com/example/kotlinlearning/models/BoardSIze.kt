package com.example.kotlinlearning.models

enum class BoardSIze (val numCards: Int){
    EASY(numCards = 8),
    MEDIUM(numCards = 16),
    HARD(numCards = 24);

    fun getWidth():Int {
        return when(this){
            EASY -> 2
            MEDIUM -> 3
            HARD -> 4
        }
    }

    fun getHeight():Int{
        return numCards / getWidth()
    }

    fun getNumPairs():Int{
        return numCards / 2
    }

}