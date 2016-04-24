package com.kisscompany.pena.howtowrite.util;

import android.content.Context;
import android.util.Log;


import com.kisscompany.pena.howtowrite.R;
import com.kisscompany.pena.howtowrite.manager.Contextor;

import java.util.ArrayList;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DataList {
    private ArrayList<Integer> dataImg = new ArrayList<Integer>();
    private ArrayList<String> dataName = new ArrayList<String>();


/*    private static DataList instance;

    public static DataList getInstance() {
        if (instance == null)
            instance = new DataList();
        return instance;
    }

    private Context mContext;

    private DataList() {
        mContext = Contextor.getInstance().getContext();

    }*/

    public void setData() {
        setDataImg();
        setDataName();
    }

    public String getDataName(int pst) {
        String data = dataName.get(pst);
        try {
            data = dataName.get(pst);
        } catch (Throwable e) {

        }
        return data;
    }

    public Integer getDataImg(int pst) {
        return dataImg.get(pst);
    }

    /// Set Data
    private void setDataImg() {

        dataImg.add(R.drawable.cat);
        dataImg.add(R.drawable.dog);
        dataImg.add(R.drawable.fork);
        dataImg.add(R.drawable.giraffe);
        dataImg.add(R.drawable.hill);
        dataImg.add(R.drawable.monkey);
        dataImg.add(R.drawable.plane);
        dataImg.add(R.drawable.rhinoceros);
        dataImg.add(R.drawable.rocket);
        dataImg.add(R.drawable.spoon);


    }

    private void setDataName() {

        dataName.add("cat");
        dataName.add("dog");
        dataName.add("fork");
        dataName.add("giraffe");
        dataName.add("hill");
        dataName.add("monkey");
        dataName.add("plane");
        dataName.add("rhinoceros");
        dataName.add("rocket");
        dataName.add("spoon");


    }

    public void desData() {
        dataImg.removeAll(dataImg);
        dataName.removeAll(dataName);
        Log.d("size", dataImg.size() + "");
    }


}
