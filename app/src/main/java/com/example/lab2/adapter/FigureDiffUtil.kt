package com.example.lab2.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab2.model.FigureApi
import com.example.lab2.model.FigureInfo

class FigureDiffUtil() : DiffUtil.ItemCallback<FigureApi>() {
    override fun areItemsTheSame(oldItem: FigureApi, newItem: FigureApi): Boolean {
        return oldItem == newItem
        //return oldItem.born == newItem.born && oldItem.died == newItem.died
    }

    override fun areContentsTheSame(oldItem: FigureApi, newItem: FigureApi): Boolean {
        return oldItem == newItem
    }
}
