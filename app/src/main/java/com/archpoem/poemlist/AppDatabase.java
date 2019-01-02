package com.archpoem.poemlist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.archpoem.poemlist.db.DataGenerator;
import com.archpoem.poemlist.db.PoemDao;
import com.archpoem.poemlist.model.Poem;

import java.util.List;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

@Database(entities = {Poem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "poemdb";

    private static AppDatabase instance;

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public abstract PoemDao poemDao();

    public static AppDatabase getInstance(Context context, AppExecutors appExecutors) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = buildDatabase(context.getApplicationContext(), appExecutors);
                    instance.updateDatabaseCreated(context);
                }
            }
        }

        return instance;
    }

    private static AppDatabase buildDatabase(Context context, final AppExecutors appExecutors) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                        appExecutors.diskIO().execute(() -> {
                            AppDatabase appDatabase = AppDatabase.getInstance(context, appExecutors);

                            List<Poem> poems = DataGenerator.productPoems();
                            Log.d("James", "onCreate: " + poems.size());

                            appDatabase.runInTransaction(() -> {
                                appDatabase.poemDao().insertPoem(poems);
                            });
                        });
                    }
                }).build();
    }

    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }
}
