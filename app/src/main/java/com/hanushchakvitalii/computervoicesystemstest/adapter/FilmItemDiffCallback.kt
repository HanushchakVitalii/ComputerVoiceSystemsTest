package com.hanushchakvitalii.computervoicesystemstest.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hanushchakvitalii.computervoicesystemstest.entities.FilmEntity

class FilmItemDiffCallback: DiffUtil.ItemCallback<FilmEntity>() {

    override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
        return oldItem == newItem
    }
}