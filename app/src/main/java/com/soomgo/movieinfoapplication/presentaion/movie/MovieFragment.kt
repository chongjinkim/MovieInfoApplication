package com.soomgo.movieinfoapplication.presentaion.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.soomgo.movieinfoapplication.R
import com.soomgo.movieinfoapplication.common.KEY_DETAIL
import com.soomgo.movieinfoapplication.databinding.LayoutRecyclerviewBinding
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.presentaion.adapter.HeaderAdapter
import com.soomgo.movieinfoapplication.presentaion.adapter.HorizontalAdapter
import com.soomgo.movieinfoapplication.presentaion.adapter.MovieListAdapter
import com.soomgo.movieinfoapplication.presentaion.detail.DetailFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    lateinit var binding : LayoutRecyclerviewBinding

    private val viewModel by viewModel<MovieViewModel>()

    private val popularAdapter = MovieListAdapter()

    private val upComingAdapter = MovieListAdapter()

    private val topRatedAdapter = MovieListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutRecyclerviewBinding.inflate(inflater, container, false).apply{
        lifecycleOwner = viewLifecycleOwner
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initRecyclerView()
    }

    private fun observe(){

       viewModel.popularMovies.observe(viewLifecycleOwner){
            popularAdapter.submitList(it)
        }

        viewModel.topRatedMovies.observe(viewLifecycleOwner){
            topRatedAdapter.submitList(it)
        }

        viewModel.upcomingMovies.observe(viewLifecycleOwner){
            upComingAdapter.submitList(it)
        }
    }

    private fun initRecyclerView(){
        binding.recyclerView.apply {
            adapter = ConcatAdapter().apply {
                addAdapter(HeaderAdapter("POPULAR", "가장 인기 있는 영화"))
                addAdapter(HorizontalAdapter(popularAdapter.apply {
                    clickListener = movieClickListener(requireActivity())
                }))
                addAdapter(HeaderAdapter("TOP RATED", "평점이 가장 높은 영화"))
                addAdapter(HorizontalAdapter(topRatedAdapter.apply {
                    clickListener = movieClickListener(requireActivity())
                }))
                addAdapter(HeaderAdapter("UPCOMING", "개봉 예정 영화"))
                addAdapter(HorizontalAdapter(upComingAdapter.apply {
                    clickListener = movieClickListener(requireActivity())
                }))
            }
        }
    }

}


fun movieClickListener(activity: FragmentActivity) : (Movie) -> Unit =
    { movie ->
        val fragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_DETAIL, movie)
            }
        }

        activity
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .addToBackStack(null).commit()
    }