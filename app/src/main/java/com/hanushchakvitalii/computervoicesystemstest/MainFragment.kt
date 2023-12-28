package com.hanushchakvitalii.computervoicesystemstest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import com.hanushchakvitalii.computervoicesystemstest.adapter.FilmListAdapter
import com.hanushchakvitalii.computervoicesystemstest.databinding.FragmentMainBinding
import com.hanushchakvitalii.computervoicesystemstest.entities.FilmEntity


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var filmAdapter: FilmListAdapter
    private lateinit var spinner: Spinner
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.filmList.observe(viewLifecycleOwner) {
            filmAdapter.submitList(it)

        }
        setupSpinner()
        setupClickListener()


    }

    private fun setupSpinner() {
        val spinnerModes = resources.getStringArray(R.array.spinnerModes)
        val adapter = activity?.let {
            ArrayAdapter(
                it.applicationContext,
                android.R.layout.simple_spinner_item, spinnerModes
            )
        }
        spinner = binding.spinner
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                val type = parent?.getItemAtPosition(position).toString()
                spinnerReaction(type)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }
    fun spinnerReaction(string: String) {
        when(string){
            "Sort" -> {}
            "Title" ->  viewModel.sortedByTitle()
            "Released Date" -> viewModel.sortedByReleaseDate()
            "Cancel" -> spinner.setSelection(0)
        }

    }

    private fun setupClickListener() {
        filmAdapter.onFilmItemClickListener = {
            launchDetailFilmFragment(it)
        }
    }


    private fun setupRecyclerView() {
        val rvFilmListInfo = _binding?.rvFilmList
        filmAdapter = FilmListAdapter()
        rvFilmListInfo?.adapter = filmAdapter
    }

    private fun launchDetailFilmFragment(film: FilmEntity) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailFilmFragment.newInstance(film))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}