package com.archpoem.poemlist.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.archpoem.poemlist.model.Poem;

import java.util.List;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

@Dao
public interface PoemDao {

    @Query("SELECT * FROM t_poem")
    LiveData<List<Poem>> loadAllPoems();

    @Query("SELECT * FROM t_poem WHERE id= :poemId")
    LiveData<Poem> loadPoemById(int poemId);

    @Insert
    void insertPoem(List<Poem> poems);
}
