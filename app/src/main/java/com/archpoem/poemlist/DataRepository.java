package com.archpoem.poemlist;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.archpoem.poemlist.model.Poem;

import java.util.List;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class DataRepository {

    private static DataRepository instance;

    private final AppDatabase mAppDatabase;

    private MediatorLiveData<List<Poem>> mPoemListLiveData;

    private DataRepository(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;

        mPoemListLiveData = new MediatorLiveData<>();

        mPoemListLiveData.addSource(mAppDatabase.poemDao().loadAllPoems(),
                poems -> {
                    mPoemListLiveData.setValue(poems);
                });
    }

    public static DataRepository getInstance(AppDatabase appDatabase) {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository(appDatabase);
                }
            }
        }

        return instance;
    }

    public MutableLiveData<List<Poem>> getPoemList() {
        return mPoemListLiveData;
    }
}
