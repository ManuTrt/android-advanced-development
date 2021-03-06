package com.manu.newsreader.feature.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.manu.newsreader.R;
import com.manu.newsreader.feature.newslist.fragment.NewsListFragment;

public class NewsReaderMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new NewsListFragment())
                    .commitNow();
        }
    }
}