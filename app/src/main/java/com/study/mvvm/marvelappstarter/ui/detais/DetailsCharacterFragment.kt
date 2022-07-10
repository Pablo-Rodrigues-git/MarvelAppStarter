package com.study.mvvm.marvelappstarter.ui.detais

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.study.mvvm.marvelappstarter.ui.BaseFragment
import daniel.lop.io.marvelappstarter.databinding.FragmentDetailsCharacterBinding

class DetailsCharacterFragment :
    BaseFragment<FragmentDetailsCharacterBinding, DetailsCharacterFragmentViewModel>() {
    override val viewModel: DetailsCharacterFragmentViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentDetailsCharacterBinding =
        FragmentDetailsCharacterBinding.inflate(inflater, container, false)
}