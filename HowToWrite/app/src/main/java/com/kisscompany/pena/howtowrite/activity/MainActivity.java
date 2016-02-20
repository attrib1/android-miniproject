package com.kisscompany.pena.howtowrite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kisscompany.pena.howtowrite.R;
import com.kisscompany.pena.howtowrite.fragment.MainFragment;
import com.kisscompany.pena.howtowrite.util.DataList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commit();
        }
    }
}
