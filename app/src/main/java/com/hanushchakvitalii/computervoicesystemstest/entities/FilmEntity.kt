package com.hanushchakvitalii.computervoicesystemstest.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class FilmEntity(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Double,
    val duration: String,
    val genres: List<Genre>,
    val releaseDate: LocalDate,
    val trailerLink: String,
    val idImage: Int,
    var isInWishlist: Boolean = false,

    ):Parcelable