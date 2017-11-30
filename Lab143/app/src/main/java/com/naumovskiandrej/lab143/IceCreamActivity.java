package com.naumovskiandrej.lab143;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class IceCreamActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(IceCreamActivity.class.getSimpleName());
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        setSupportActionBar(toolbar);
    }
}
