package com.hanushchakvitalii.computervoicesystemstest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanushchakvitalii.computervoicesystemstest.databinding.FilmInfoItemBinding
import com.hanushchakvitalii.computervoicesystemstest.entities.FilmEntity
import com.hanushchakvitalii.computervoicesystemstest.entities.Genre


class FilmListAdapter : ListAdapter<FilmEntity, FilmListAdapter.FilmViewHolder>(
    FilmItemDiffCallback()
) {

    var onFilmItemClickListener: ((FilmEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilmInfoItemBinding.inflate(inflater, parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }


    inner class FilmViewHolder(private val binding: FilmInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(itemFilm: FilmEntity) {
            with(binding) {
                itemCard.setOnClickListener {
                    onFilmItemClickListener?.invoke(itemFilm)
                }
                nameWithYear.text = itemFilm.title + " (" + itemFilm.releaseDate.year + ")"
                durationWithGenre.text = itemFilm.duration + " - " +  genresToString(itemFilm.genres)
                if (itemFilm.isInWishlist){
                    isInWishlist.visibility = View.VISIBLE
                }

                posterView.setImageResource(itemFilm.idImage)
                }

            }

        }
        fun genresToString(list:List<Genre>):String{
            var tempString = ""
            for (i in list){
                tempString+=i.name + ", "
            }
            return tempString.dropLast(2)

    }

}