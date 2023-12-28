package com.hanushchakvitalii.computervoicesystemstest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hanushchakvitalii.computervoicesystemstest.databinding.FragmentDetailFilmBinding
import com.hanushchakvitalii.computervoicesystemstest.entities.FilmEntity
import com.hanushchakvitalii.computervoicesystemstest.entities.Genre


class DetailFilmFragment : Fragment() {

    private lateinit var viewModel: DetailFilmViewModel
    private lateinit var filmEntity: FilmEntity
    private var _binding: FragmentDetailFilmBinding? = null
    private val binding: FragmentDetailFilmBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailFilmBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailFilmBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailFilmViewModel::class.java]
        with(binding) {
            posterView.setImageResource(filmEntity.idImage)
            movies.text = filmEntity.title
            filmRating.text = filmEntity.rating.toString() + "/10"
            description.text = filmEntity.description
            genres.text = genresToString(filmEntity.genres)
            releasedDate.text =
                filmEntity.releaseDate.year.toString() + ", " + filmEntity.releaseDate.dayOfMonth+
            " " +     filmEntity.releaseDate.month.toString()
            viewModel.getIsInWishList(filmEntity.id).observe(viewLifecycleOwner) {
                if (it){
                    isFromWatchList.text = getString(R.string.remove_from_watchlist)
                }else{
                    isFromWatchList.text = getString(R.string.add_to_watchlist)
                }
            }
            isFromWatchList.setOnClickListener{
                viewModel.updateIsInWishList(filmEntity.id)
            }
        }
    }

    private fun genresToString(list: List<Genre>): String {
        var tempString = ""
        for (i in list) {
            tempString += i.name + ", "
        }
        return tempString.dropLast(2)

    }

    private fun parseArgs() {
        requireArguments().getParcelable<FilmEntity>(FILM)?.let {
            filmEntity = it
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {

        private const val FILM = "film"

        fun newInstance(filmEntity: FilmEntity) =
            DetailFilmFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(FILM, filmEntity)
                }
            }
    }
}