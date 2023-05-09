package com.example.kotlinlearning.models

import android.util.Log
import com.example.kotlinlearning.utils.DEFAULT_ICONS

class MemoryGame(private val boardSize: BoardSIze) {
    companion object{
        private const val TAG = "MemoryGame"
    }

    val cards: List<MemoryCard>

    var numPairsFound = 0
    private var numCardFlips = 0

    private var indexOfSingleSelectedCard: Int? = null

    init {
        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        var randomizedImages = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map { MemoryCard(it) }
    }

    fun flipCard(position: Int):Boolean {
        numCardFlips++
        var card = cards[position]

        var foundMatch = false
        if(indexOfSingleSelectedCard == null){
            // 0 or 2 card flipped over
            restoreCards()
            indexOfSingleSelectedCard = position
        }else{
            foundMatch = checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }

        card.isFaceUp = !card.isFaceUp
        return foundMatch
    }

    private fun checkForMatch(position1: Int, position2: Int): Boolean {
        if(cards[position1].identifier != cards[position2].identifier){
            Log.i(TAG, "Not a match $position1 != $position2")
            return false
        }

        Log.i(TAG, "Is a match")
        cards[position1].isMatched = true
        cards[position2].isMatched = true
        numPairsFound++
        return true
    }

    private fun restoreCards() {
        for(card in cards){
            if(!card.isMatched){
                card.isFaceUp =false
            }
        }
    }

    fun haveWonGame(): Boolean {
        return  numPairsFound == boardSize.getNumPairs()
    }

    fun isCardFaceUp(position: Int): Boolean {
        return cards[position].isFaceUp
    }

    fun getNumMoves(): Int {
        return numCardFlips / 2
    }
}
