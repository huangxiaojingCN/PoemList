package com.archpoem.poemlist;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class DataRepository {

    private static DataRepository instance;

    private final AppDatabase mAppDatabase;

    private DataRepository(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
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
}
