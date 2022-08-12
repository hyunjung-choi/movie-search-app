package com.hyunjung.moviesearch.ui.view

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyunjung.moviesearch.MainActivity
import com.hyunjung.moviesearch.databinding.FragmentSearchBinding
import com.hyunjung.moviesearch.ui.adapter.MovieSearchAdapter
import com.hyunjung.moviesearch.ui.viewmodel.MovieSearchViewModel
import com.hyunjung.moviesearch.util.Constants.SEARCH_TIME_DELAY

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieSearchViewModel: MovieSearchViewModel
    private lateinit var movieSearchAdapter: MovieSearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieSearchViewModel = (activity as MainActivity).movieSearchViewModel
        setRV()
        searchMovies()

        movieSearchViewModel.searchResult.observe(viewLifecycleOwner) { response ->
            val movies = response.movies
            movieSearchAdapter.submitList(movies)
        }
    }

    private fun setRV() {
        movieSearchAdapter = MovieSearchAdapter()
        binding.rvSearchResult.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            adapter = movieSearchAdapter
        }
    }

    private fun searchMovies() {
        var startTime: Long = System.currentTimeMillis()
        var endTime: Long

        binding.etSearch.addTextChangedListener { text: Editable? ->
            endTime = System.currentTimeMillis()
            if (endTime - startTime >= SEARCH_TIME_DELAY) {
                text?.let {
                    val query = it.toString().trim()
                    if (query.isNotEmpty()) {
                        movieSearchViewModel.searchMovies(query)
                    }
                }
            }
            startTime = endTime
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}