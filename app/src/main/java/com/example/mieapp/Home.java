package com.example.mieapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Home extends Fragment {

    View linearCurriculum, linearTraining, linearPrinting,
            linearPublishing, linearEditorial, linearAudioVisual, linearMetWood, linearConferenceFacilities, linearOtherServices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        //find views
        linearCurriculum = view.findViewById(R.id.cuurriculum_icon);
        linearTraining = view.findViewById(R.id.linear_training);
        linearPrinting = view.findViewById(R.id.linear_printing);
        linearPublishing = view.findViewById(R.id.linear_publishing);
        linearEditorial = view.findViewById(R.id.linear_editorial);
        linearAudioVisual = view.findViewById(R.id.linear_audioVisual);
        linearMetWood = view.findViewById(R.id.linear_metWood);
        linearConferenceFacilities = view.findViewById(R.id.linear_conferenceFacilities);
        linearOtherServices = view.findViewById(R.id.linear_otherServices);

        //Listen to Curriculum tab

        linearCurriculum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Hello world", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CurriculumDevelopment.class);
                startActivity(intent);
            }
        });

        //Listen to Training tab
        linearTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Training.class);
                startActivity(intent);
            }
        });

        //Listen to Printing tab
        linearPrinting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PrintingPress.class);
                startActivity(intent);
            }
        });

        //Listen to Publishing tab
        linearPublishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Publishing.class);
                startActivity(intent);
            }
        });

        //Listen to Editorial tab
        linearEditorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Editorial.class);
                startActivity(intent);
            }
        });

        //Listen to audio visual tab
        linearAudioVisual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AudioVisual.class);
                startActivity(intent);
            }
        });

        //Listen to metal and work work tab
        linearMetWood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MetWood.class);
                startActivity(intent);
            }
        });

        //Listen to conference services tab
        linearConferenceFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ConferenceFacilities.class);
                startActivity(intent);
            }
        });

        //Listen to other services tab
        linearOtherServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OtherServices.class);
                startActivity(intent);
            }
        });

        return view;
    }

   /* @Override
    public void onResume() {
        super.onResume();
        requireActivity().setTitle("Home");
    }*/
}