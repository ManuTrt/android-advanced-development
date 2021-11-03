package com.adg.mvvm1.ui.main;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public ObservableBoolean isChecked = new ObservableBoolean();

    public void onResetSelected() {
        isChecked.set(false);
    }
}