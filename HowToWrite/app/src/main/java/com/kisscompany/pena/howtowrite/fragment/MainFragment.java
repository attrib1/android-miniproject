package com.kisscompany.pena.howtowrite.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.kisscompany.pena.howtowrite.R;
import com.kisscompany.pena.howtowrite.util.DataList;
import com.kisscompany.pena.howtowrite.util.RandomNumber;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment {

    private ImageView img;

    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);

        return rootView;
    }

    private void initInstances(View rootView) {
        DataList data = DataList.getInstance();
        RandomNumber ranPst = RandomNumber.getInstance();
        // init instance with rootView.findViewById here
        img = (ImageView) rootView.findViewById(R.id.Img);

        ranPst.setRanDomNumber(0,3);
        Log.d("dddd : " , ""+ranPst.getRanDomNumber());

        img.setImageResource(data.getDataImg(ranPst.getRanDomNumber()));

        Toast.makeText(Contextor.getInstance().getContext(),
                data.getDataName(ranPst.getRanDomNumber()).toLowerCase(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
