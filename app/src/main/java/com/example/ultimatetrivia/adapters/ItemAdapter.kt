package com.example.ultimatetrivia.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatetrivia.R
import kotlinx.android.synthetic.main.item_custom_row.view.*
import kotlinx.android.synthetic.main.item_custom_row.view.card_view_item
import kotlinx.android.synthetic.main.item_custom_row_text.view.*
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

        var layoutInflater = LayoutInflater.from(parent.context)
        var view:View

        if(viewType == 1){
            view = layoutInflater.inflate(R.layout.item_custom_row,parent,false)
            return ViewHolder(view)
        }
        else{
            view = layoutInflater.inflate(R.layout.item_custom_row_text,parent,false)
            return ViewHolder(view)
        }
    }


    override fun getItemViewType(position: Int): Int {
        if(images.size == 0){
            return 0
        }
        else{
            return 1
        }
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {

        val item = items.get(position)

        if(images.size==0){
            holder.textViewRowTitle.text=item
            return
        }



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
        val textViewRowTitle = view.tv_text_row_title

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

