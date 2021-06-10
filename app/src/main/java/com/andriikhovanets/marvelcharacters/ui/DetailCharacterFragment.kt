package com.andriikhovanets.marvelcharacters.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andriikhovanets.marvelcharacters.R

class DetailCharacterFragment : Fragment() {

    companion object {
        fun newInstance() = DetailCharacterFragment()
    }

    private lateinit var viewModel: DetailCharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_character, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailCharacterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}