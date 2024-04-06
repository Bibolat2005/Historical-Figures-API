package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.databinding.ItemFigureBinding
import com.example.lab2.model.FigureApi

class FigureAdapter(private val figures: List<FigureApi>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FigureViewHolder(private val binding: ItemFigureBinding) : RecyclerView.ViewHolder(binding.root) {
        val figureName: TextView = binding.figureName
        val figureTitle: TextView = binding.figureTitle
        val figureBorn: TextView = binding.figureBorn
        val figureDied: TextView = binding.figureDied
        val figureMother: TextView = binding.figureMother
        val figureFather: TextView = binding.figureFather
//        val figurePartners: TextView = binding.figurePartners
//        val figureConflicts: TextView = binding.figureConflicts
//        val figureOccupation: TextView = binding.figureOccupation
//        val figureNotableWork: TextView = binding.figureNotableWork

        fun bind(figure: FigureApi) {
            figureName.text = "Name: ${figure.name}"
            figureTitle.text = "Title: ${figure.title}"

            figure.info?.let { info ->
                figureBorn.text = "Born: ${info.born}"
                figureDied.text = "Died: ${info.died}"
                figureMother.text="Mother: ${info.mother}"
                figureFather.text="Father: ${info.father}"
//                figureSpouses.text = "Spouses: ${info.spouses.toString()}"
//                figureChildren.text = "Children: ${info.children.toString()}"
//                figurePartners.text = "Partners: ${info.partners.toString()}"
//                figureConflicts.text = "Conflicts: ${info.conflicts.toString()}"
//                figureOccupation.text = "Occupation: ${info.occupation.toString()}"
//                figureNotableWork.text = "Notable Work: ${info.notableWork.toString()}"
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemFigureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FigureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val figure = figures[position]
        if (holder is FigureViewHolder) {
            holder.bind(figure)
        }
    }

    override fun getItemCount() = figures.size
}
