package com.archpoem.poemlist.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.archpoem.poemlist.model.Poem;

import java.util.List;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class PoemListViewModel extends ViewModel {

    private MutableLiveData<List<Poem>> mPoemListLiveData;

    public void loadPoemList() {
        if (mPoemListLiveData == null) {
            mPoemListLiveData = new MutableLiveData<>();
        }


    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
