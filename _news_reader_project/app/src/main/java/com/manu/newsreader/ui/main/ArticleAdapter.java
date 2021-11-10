package com.manu.newsreader.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manu.newsreader.databinding.ArticleItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private List<ArticleItemViewModel> articleModelList;

    public ArticleAdapter() {
        this.articleModelList = new ArrayList<>();
    }

    public void setArticleModelList(List<ArticleItemViewModel> articleModelList) {
        this.articleModelList = articleModelList;
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
