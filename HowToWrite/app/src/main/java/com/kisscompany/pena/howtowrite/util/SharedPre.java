package com.kisscompany.pena.howtowrite.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 14/4/59.
 */

public class SharedPre {
    Context context;
    SharedPreferences sharedPerfs;
    SharedPreferences.Editor editor;
    static String perfsName = "UserHelper";


    public SharedPre(Context context) {

        this.context = context;
        this.sharedPerfs = this.context.getSharedPreferences(perfsName, 0);
        this.editor = sharedPerfs.edit();

    }

    public void reSetScore() {
        editor.clear();
        editor.commit();
    }

    public void setScore() {
        int score = sharedPerfs.getInt("Score", 0)+1;
        editor.putInt("Score", score);
        editor.commit();
    }

    public int getScore() {
        return sharedPerfs.getInt("Score", 0);
    }
}
