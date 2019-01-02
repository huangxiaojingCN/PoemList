package com.archpoem.poemlist.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

@Entity(tableName = "t_poem")
public class Poem {

    @PrimaryKey
    private int id;

    @ColumnInfo
    private String poemContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoemContent() {
        return poemContent;
    }

    public void setPoemContent(String poemContent) {
        this.poemContent = poemContent;
    }
}
