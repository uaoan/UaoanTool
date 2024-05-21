package com.uaoanlao.uaoanlibrary.adapter;


import androidx.annotation.NonNull;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {

    private java.util.List<androidx.fragment.app.Fragment> mFragments;

    public ViewPager2Adapter(@NonNull androidx.fragment.app.FragmentActivity fragmentActivity, java.util.List<androidx.fragment.app.Fragment> fragments) {
        super(fragmentActivity);
        this.mFragments = fragments;
    }

    @NonNull
    @Override
    public androidx.fragment.app.Fragment createFragment(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragments.size();
    }
}
