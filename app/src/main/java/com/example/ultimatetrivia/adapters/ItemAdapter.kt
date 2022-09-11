package com.example.ultimatetrivia.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatetrivia.R
import kotlinx.android.synthetic.main.item_custom_row.view.*
import java.lang.Exception

class ItemAdapter(
    val context: Context,
    val items: ArrayList<String>,
    val images: ArrayList<Int>,
    val highScores: ArrayList<String>,
    val progressScores: ArrayList<String>,
    val listener: OnItemCLickListener

) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder (
            LayoutInflater.from(context).inflate(R.layout.item_custom_row,
                parent,
                false)
            )
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)
        holder.tvItem.text = item
        if(position<images.size) {
            val image = images.get(position)
            holder.ivItem.setImageResource(image)
        }

        try {
            val highScore = highScores.get(position)
            if(highScore != "")
                holder.tvHighScore.text = "Best:$highScore "
        }catch (e:Exception){
            val doNothing = 1
        }

        try {
            val progressScore = progressScores.get(position)
            if (progressScore != "")
                holder.tvProgressScore.text=progressScore
        }catch (e:Exception){
            val doNothing = 1
        }


        //Updating background colour according to position
        if(position % 2 ==0){
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.darkGrey
                )
            )
        }
        else{
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.darkGrey
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
    View.OnClickListener{
        val tvItem = view.tv_item_name
        val tvHighScore = view.tvBestScore
        val tvProgressScore = view.tvProgressDisplay
        val ivItem = view.ivRow
        val cardViewItem = view.card_view_item

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemCLickListener {
        fun onItemClick(position: Int)
    }

}