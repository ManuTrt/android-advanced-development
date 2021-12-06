package com.manu.newsreader.ui.main.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manu.newsreader.databinding.ArticleItemBinding;
import com.manu.newsreader.ui.main.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private List<ArticleItemViewModel> articleModelList;

    public ArticleAdapter() {
        this.articleModelList = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setArticleModelList(List<ArticleItemViewModel> articleModelList) {
        this.articleModelList = articleModelList;

        // At first it receives an empty list and afterwards
        // when the db query is done, it ignores the data received
        // until first screen rotation. To prevent that I ll notify the RV when
        // data set has changed
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleItemBinding binder = ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ArticleViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.binding.setViewModel(articleModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleModelList.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        final ArticleItemBinding binding;

        public ArticleViewHolder(ArticleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
