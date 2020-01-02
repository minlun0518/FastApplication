package com.tom.fastapplication.ui.main;

import android.content.Intent;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tom.fastapplication.BasicActivity;
import com.tom.fastapplication.MainActivity;
import com.tom.fastapplication.MapActivity;
import com.tom.fastapplication.RequestActivity;

public class PageViewModel extends ViewModel {



    public MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    public LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {


        public String apply (Integer input) {
            //int inputnum= intput;
            return "Hello world from section: " + input;
        }
    });


    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }



}