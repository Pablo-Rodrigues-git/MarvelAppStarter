package com.study.mvvm.marvelappstarter.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.study.mvvm.marvelappstarter.ui.BaseFragment
import daniel.lop.io.marvelappstarter.databinding.FragmentListCharacterBinding

class ListCharacterFragment : BaseFragment<FragmentListCharacterBinding, ListCharacterViewModel>() {

    override val viewModel: ListCharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentListCharacterBinding =
        FragmentListCharacterBinding.inflate(inflater, container, false)
}