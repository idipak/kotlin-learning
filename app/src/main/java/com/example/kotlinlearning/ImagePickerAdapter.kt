package com.example.kotlinlearning

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlearning.models.BoardSIze
import kotlin.math.min

class ImagePickerAdapter(
    private val context: Context,
    private val imageUris: List<Uri>,
    private val boardSIze: BoardSIze)
    : RecyclerView.Adapter<ImagePickerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_image, parent, false)
        val cardWidth = parent.width / boardSIze.getWidth()
        val cardHeight = parent.height / boardSIze.getHeight()
        val cardSizeLength = min(cardHeight, cardWidth)
        val layoutParams = view.findViewById<ImageView>(R.id.ivCustomImage).layoutParams
        layoutParams.height = cardSizeLength
        layoutParams.width = cardSizeLength
        return ViewHolder(view)
    }

    override fun getItemCount() = boardSIze.getNumPairs()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position < imageUris.size){
            holder.bind(imageUris[position])
        }else{
            holder.bind()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val ivCustomView = itemView.findViewById<ImageView>(R.id.ivCustomImage)

        fun bind(uri: Uri) {
            ivCustomView.setImageURI(uri)
            ivCustomView.setOnClickListener(null)
        }

        fun bind() {
            ivCustomView.setOnClickListener{

            }
        }
    }
}
