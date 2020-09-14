package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

//        mBinding
    }

}