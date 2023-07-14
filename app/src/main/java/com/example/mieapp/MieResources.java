package com.example.mieapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MieResources extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set the title of the fragment

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mie_resources, container, false);


    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Resources");
    }
}