package com.manu.newsreader;

import android.app.Application;

import com.manu.data.di.RepoModule;

public class MyApplication extends Application {
    private static RepoModule repoModule;

    @Override
    public void onCreate() {
        super.onCreate();
        repoModule = new RepoModule(this);
    }

    public static RepoModule getRepoProvider() {
        return repoModule;
    }
}
