package com.hanushchakvitalii.computervoicesystemstest

import com.hanushchakvitalii.computervoicesystemstest.entities.FilmEntity
import com.hanushchakvitalii.computervoicesystemstest.entities.Genre
import java.time.LocalDate

object FakeRepository {
    private var listFilm: List<FilmEntity>? = null

    fun getListFilm(): List<FilmEntity> {
        if (listFilm == null) {
            listFilm = createMockedFilmList()
        }
        return listFilm as List<FilmEntity>
    }

    fun changeIsInWishlist(id:Int){
        listFilm!![id].isInWishlist = !listFilm!![id].isInWishlist
    }

    fun isInWishlist(id:Int):Boolean{
        return listFilm!![id].isInWishlist
    }

    private fun createMockedFilmList(): List<FilmEntity> {

        return listOf(
            FilmEntity(
                id = 0,
                title = "Tenet",
                description = "Armed with only one word, Tenet, and fighting for the survival of the entire world, a\n" +
                        "Protagonist journeys through a twilight world of international espionage on a mission that will\n" +
                        "unfold in something beyond real time.",
                rating = 7.8,
                duration = "2h 30 min",
                genres = listOf(Genre.Action, Genre.SciFi),
                releaseDate = LocalDate.of(2020, 9, 3),
                trailerLink = "https://www.youtube.com/watch?v=LdOM0x0XDMo",
                idImage = R.drawable.tenet
            ),
            FilmEntity(
                id = 1,
                title = "Spider-Man: Into the Spider-Verse",
                description = "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five\n" +
                        "spider-powered individuals from other dimensions to stop a threat for all realities.",
                rating = 8.4,
                duration = "1h 57min",
                genres = listOf(Genre.Action, Genre.Animation, Genre.Adventure),
                releaseDate = LocalDate.of(2018, 12, 14),
                trailerLink = "https://www.youtube.com/watch?v=tg52up16eq0",
                idImage = R.drawable.spider_man
            ),
            FilmEntity(
                id = 2,
                title = "Knives Out",
                description = "A detective investigates the death of a patriarch of an eccentric, combative family.",
                rating = 7.9,
                duration = "2h 10min",
                genres = listOf(Genre.Comedy, Genre.Crime, Genre.Drama),
                releaseDate = LocalDate.of(2019, 11, 27),
                trailerLink = "https://www.youtube.com/watch?v=qGqiHJTsRkQ",
                idImage = R.drawable.knives_out
            ),
            FilmEntity(
                id = 3,
                title = "Guardians of the Galaxy",
                description = "A group of intergalactic criminals must pull together to stop a fanatical warrior with\n" +
                        "plans to purge the universe.",
                rating = 8.0,
                duration = "2h 1min",
                genres = listOf(Genre.Action, Genre.Adventure, Genre.Comedy),
                releaseDate = LocalDate.of(2014, 8, 1),
                trailerLink = "https://www.youtube.com/watch?v=d96cjJhvlMA",
                idImage = R.drawable.guardians_of_the_galaxy
            ),
            FilmEntity(
                id = 4,
                title = "Avengers: Age of Ultron",
                description = "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping\n" +
                        "program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the\n" +
                        "villainous Ultron from enacting his terrible plan.",
                rating = 7.3,
                duration = "2h 21min",
                genres = listOf(Genre.Action, Genre.Adventure, Genre.SciFi),
                releaseDate = LocalDate.of(2015, 5, 1),
                trailerLink = "https://www.youtube.com/watch?v=tmeOjFno6Do",
                idImage = R.drawable.avengers
            )


        )
    }

}