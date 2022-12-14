package com.ivanzulyan.andchallenge5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanzulyan.andchallenge5.R
import com.ivanzulyan.andchallenge5.adapter.FavoriteAdapter
import com.ivanzulyan.andchallenge5.databinding.FragmentFavoriteBinding
import com.ivanzulyan.andchallenge5.viewmodel.FavoriteViewModel

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var adapter: FavoriteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this.requireActivity()).get(FavoriteViewModel::class.java)

        binding.rvFavorite.layoutManager = LinearLayoutManager(this.requireActivity())
        viewModel.getFavoriteMovie()?.observe(this.requireActivity()) {
            if (it != null) {
                adapter = FavoriteAdapter(it)
                adapter.notifyDataSetChanged()
                binding.rvFavorite.adapter = FavoriteAdapter(it)
            }
        }
    }

}