package com.example.mieapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new Home();
            case 1: return new Website();
            case 2: return new MieResources();
            case 3: return new AboutMie();
            default: return new Home();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
