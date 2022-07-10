package com.study.mvvm.marvelappstarter.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.study.mvvm.marvelappstarter.ui.BaseFragment
import daniel.lop.io.marvelappstarter.databinding.FragmentSearchCharacterBinding

class SearchCharacterFragment :
    BaseFragment<FragmentSearchCharacterBinding, SearchCharacterViewModel>() {

    override val viewModel: SearchCharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentSearchCharacterBinding =
        FragmentSearchCharacterBinding.inflate(inflater, container, false)
}