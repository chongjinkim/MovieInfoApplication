package com.soomgo.movieinfoapplication.presentaion.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.soomgo.movieinfoapplication.BR
import com.soomgo.movieinfoapplication.common.KEY_DETAIL
import com.soomgo.movieinfoapplication.databinding.LayoutDetailFragmentBinding
import com.soomgo.movieinfoapplication.domain.model.Movie
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {

    lateinit var binding : LayoutDetailFragmentBinding

    private val viewModel by viewModel<DetailViewModel>()

    lateinit var movie : Movie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutDetailFragmentBinding.inflate(inflater, container, false).apply {
        lifecycleOwner = viewLifecycleOwner
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }

    private fun initView(){
        arguments?.getParcelable<Movie>(KEY_DETAIL)?.let {
            movie = it
            viewModel.fetchDetail(it)
        }

        binding.startImage.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.updateMovie(movie)
            }
        }
    }

    private fun observe(){
        viewModel.movieDetail.observe(viewLifecycleOwner){
            binding.setVariable(BR.movieDetail, it)
            binding.executePendingBindings()
        }

        viewModel.movieFavorite.observe(viewLifecycleOwner){
            binding.isFavorite = it
        }
    }
}