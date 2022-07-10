package com.study.mvvm.marvelappstarter.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.study.mvvm.marvelappstarter.ui.BaseFragment
import daniel.lop.io.marvelappstarter.databinding.FragmentFavoriteCharacterBinding

class FavoriteCharacterFragment :
    BaseFragment<FragmentFavoriteCharacterBinding, FavoriteCharacterFragmentViewModel>() {
    override val viewModel: FavoriteCharacterFragmentViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentFavoriteCharacterBinding =
        FragmentFavoriteCharacterBinding.inflate(inflater, container, false)
}