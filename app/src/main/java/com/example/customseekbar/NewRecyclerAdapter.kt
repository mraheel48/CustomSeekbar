package com.example.customseekbar

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class NewRecyclerAdapter : RecyclerView.Adapter<NewRecyclerAdapter.ViewHolder>() {

    var positionItem: Int = 10

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        /*if (position % 2 == 0) {
            holder.rulerline.layoutParams.width = 50
        } else {
            holder.rulerline.layoutParams.width = 25
        }*/

        holder.rulerline.layoutParams.width = 50

        if (positionItem <= position) {
            holder.rulerline.setBackgroundColor(Color.parseColor("#FF018786"))
        } else {
            holder.rulerline.setBackgroundColor(Color.parseColor("#FFBB86FC"))

        }

    }

    fun updateSelectionPosition(position: Int) {
        positionItem = 10 - position
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var rulerline: View

        init {
            rulerline = itemView.findViewById(R.id.view)

        }
    }
}