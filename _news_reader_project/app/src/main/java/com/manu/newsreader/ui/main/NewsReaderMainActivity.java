package com.manu.newsreader.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.manu.newsreader.R;
import com.manu.newsreader.ui.main.fragment.NewsListFragment;

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