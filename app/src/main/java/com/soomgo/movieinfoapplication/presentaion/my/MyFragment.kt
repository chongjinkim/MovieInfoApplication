package com.soomgo.movieinfoapplication.presentaion.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import com.soomgo.movieinfoapplication.databinding.LayoutRecyclerviewBinding
import com.soomgo.movieinfoapplication.presentaion.adapter.FavoriteAdapter
import com.soomgo.movieinfoapplication.presentaion.adapter.HeaderAdapter
import com.soomgo.movieinfoapplication.presentaion.movie.MovieFragment
import com.soomgo.movieinfoapplication.presentaion.movie.movieClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFragment : Fragment() {

    lateinit var binding : LayoutRecyclerviewBinding

    private val viewModel by viewModel<MyViewModel>()

    private val adapter = FavoriteAdapter()

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
        initView()
    }

    private fun observe(){
        viewModel.movieList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    private fun initView(){
        binding.recyclerView.adapter = ConcatAdapter().apply {
            addAdapter(HeaderAdapter("My", "내가 저장한 영화"))
            addAdapter(adapter.apply {
                clickListener = movieClickListener(requireActivity())
            })
        }
    }
}