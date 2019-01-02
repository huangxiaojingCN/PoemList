package com.archpoem.poemlist;

import android.app.Application;
import android.content.Context;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class App extends Application {

    private Context mContext;

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;

        mAppExecutors = new AppExecutors();
        initDataRepository();
    }

    public void initDataRepository() {
        //DataRepository.getInstance(AppDatabase.getInstance(mContext,mAppExecutors));
    }
}
