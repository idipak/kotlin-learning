package com.example.kotlinlearning

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlearning.models.BoardSIze
import com.example.kotlinlearning.utils.EXTRA_BOARD_SIZE

class CreateActivity : AppCompatActivity() {

    private lateinit var rvImagePicker: RecyclerView
    private lateinit var etGameName : EditText
    private lateinit var btnSave: Button

    private lateinit var boardSIze: BoardSIze
    private var numImageRequired = -1

    private var chosenImageUris = mutableListOf<Uri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        rvImagePicker = findViewById(R.id.rvImagePicker)
        etGameName = findViewById(R.id.etGameName)
        btnSave = findViewById(R.id.btnSave)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        boardSIze = intent.getSerializableExtra(EXTRA_BOARD_SIZE) as BoardSIze
        numImageRequired = boardSIze.getNumPairs()
        supportActionBar?.title = "Choose pics (0 / $numImageRequired)"

        rvImagePicker.adapter = ImagePickerAdapter(this, chosenImageUris, boardSIze)
        rvImagePicker.setHasFixedSize(true)
        rvImagePicker.layoutManager = GridLayoutManager(this, boardSIze.getWidth())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}