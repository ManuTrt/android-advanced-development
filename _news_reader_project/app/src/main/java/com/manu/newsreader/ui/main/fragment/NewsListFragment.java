package com.manu.newsreader.ui.main.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manu.newsreader.databinding.NewsListFragmentBinding;
import com.manu.newsreader.ui.main.model.NewsListViewModel;
import com.manu.newsreader.ui.main.model.factory.ViewModelFactory;

public class NewsListFragment extends Fragment {

    private NewsListViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsListViewModel.class);

        // Register the viewModel to the fragment's lifecycle
        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

}