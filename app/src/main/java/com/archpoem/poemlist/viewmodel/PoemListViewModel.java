package com.archpoem.poemlist.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.archpoem.poemlist.App;
import com.archpoem.poemlist.model.Poem;

import java.util.List;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class PoemListViewModel extends AndroidViewModel {

    private final Application mApplication;

    private MediatorLiveData<List<Poem>> mPoemListLiveData;

    public PoemListViewModel(@NonNull Application application) {
        super(application);
        this.mApplication = application;

        loadPoemList();
    }

    private void loadPoemList() {
        if (mPoemListLiveData == null) {
            mPoemListLiveData = new MediatorLiveData<>();
        }

        LiveData<List<Poem>> poemListLiveData
                = ((App) mApplication).getDataRepository().getPoemList();

        mPoemListLiveData.addSource(poemListLiveData, poems -> {
            Log.d("James", "loadPoemList: " + poems);
            mPoemListLiveData.setValue(poems);
        });
    }

    public MediatorLiveData<List<Poem>> getPoemList() {
        return mPoemListLiveData;
    }
}
