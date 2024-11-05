package com.robinbd.exam.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robinbd.exam.R;

public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View myview =inflater.inflate(R.layout.fragment_home, container, false);
        return myview;
    }
}