package com.kisscompany.pena.howtowrite.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.kisscompany.pena.howtowrite.R;
import com.kisscompany.pena.howtowrite.manager.Contextor;
import com.kisscompany.pena.howtowrite.util.DataList;
import com.kisscompany.pena.howtowrite.util.RandomNumber;
import com.kisscompany.pena.howtowrite.util.SharedPre;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private ImageView img;
    private EditText edt_awn;
    private Button btn_awn;
    private DataList data;
    private int rnum;
    private ImageView img_ref;
    private ImageView img_anw;
    private RandomNumber ranPst;
    private SharedPre sc;
    private TextView tv_sc;
    private TextView tv_reset;


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

        Log.d("onCreate", "start");
        initInstances(rootView);

        return rootView;
    }

    private void initInstances(View rootView) {
        data = new DataList();
        ranPst = new RandomNumber();
        sc = new SharedPre(getActivity());
        data.setData();
        // init instance with rootView.findViewById here
        img = (ImageView) rootView.findViewById(R.id.Img);
        edt_awn = (EditText) rootView.findViewById(R.id.edt_anw);
        btn_awn = (Button) rootView.findViewById(R.id.btn_anw);
        img_ref = (ImageView) rootView.findViewById(R.id.img_ref);
        img_anw = (ImageView) rootView.findViewById(R.id.img_anw);
        tv_sc = (TextView) rootView.findViewById(R.id.tv_sc);
        tv_reset = (TextView) rootView.findViewById(R.id.tv_reset);

        img_ref.setOnClickListener(this);
        btn_awn.setOnClickListener(this);
        img_anw.setOnClickListener(this);
        tv_reset.setOnClickListener(this);

        tv_sc.setText("" + sc.getScore());
        rnum = ranPst.getRanDomNumber();
        Log.d("dddd : ", "" + rnum);

        img.setImageResource(data.getDataImg(rnum));


    }

    @Override
    public void onClick(View v) {
        if (v == btn_awn) {
            Log.d("dddd : ", "" + rnum);

            String edtAwn = edt_awn.getText().toString();

            String strAwn = null;
            try {
                strAwn = data.getDataName(rnum);
            } catch (IndexOutOfBoundsException e) {
                Log.d("setData", "start");
                data.setData();
                strAwn = data.getDataName(rnum);
            }


            if (edtAwn.trim().equalsIgnoreCase("" + strAwn.trim())) {
                MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.correct);
                mp.start();
                sc.setScore();
                tv_sc.setText("" + sc.getScore());
                Toast.makeText(getActivity(), "คะแนน " + sc.getScore(), Toast.LENGTH_SHORT).show();
                new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("Click on the button to continue.")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {

                                sweetAlertDialog.cancel();
                                edt_awn.setText("");
                                ranPst = new RandomNumber();
                                rnum = ranPst.getRanDomNumber();
                                img.setImageResource(data.getDataImg(rnum));
                            }
                        })
                        .show();
            } else {
                MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.uncurrect);
                mp.start();

                new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("You are wrong ,Please try again.")
                        .setConfirmText("Try Again !!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.cancel();
                            }
                        })
                        .show();
            }
        }
        if (v == img_ref) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.ref);
            mp.start();
            RandomNumber ranPst = new RandomNumber();
            rnum = ranPst.getRanDomNumber();
            img.setImageResource(data.getDataImg(rnum));
            Toast.makeText(Contextor.getInstance().getContext(),
                    "Try Again!!",
                    Toast.LENGTH_SHORT).show();
        }
        if (v == img_anw) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.answer);
            mp.start();
            edt_awn.setText("" + data.getDataName(rnum).trim());
        }
        if (v == tv_reset) {
            sc.reSetScore();
            tv_sc.setText("" + sc.getScore());
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        //Log.d("onStart", "start");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("onStop", "stop");
        //DataList data = DataList.getInstance();
        //data.desData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("onDestroyView", "stop");
        data.desData();
        data = null;
        ranPst = null;
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
