package com.naumovskiandrej.lab143;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    ImageView donutButton;
    ImageView froyoButton;
    ImageView iceCreamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(MainActivity.class.getSimpleName());
        setSupportActionBar(toolbar);

        donutButton = findViewById(R.id.donut_button);
        froyoButton = findViewById(R.id.froyo_button);
        iceCreamButton = findViewById(R.id.icecream_button);

        Glide.with(this).load(R.drawable.donut).into(donutButton);
        Glide.with(this).load(R.drawable.froyo).into(froyoButton);
        Glide.with(this).load(R.drawable.icecream).into(iceCreamButton);

        donutButton.setOnClickListener(view -> openActivity(DonutActivity.class));

        froyoButton.setOnClickListener(view -> openActivity(FroyoActivity.class));

        iceCreamButton.setOnClickListener(view -> openActivity(IceCreamActivity.class));
    }

    void openActivity(Class<? extends AppCompatActivity> activity) {
        startActivity(new Intent(this, activity));
    }
}
