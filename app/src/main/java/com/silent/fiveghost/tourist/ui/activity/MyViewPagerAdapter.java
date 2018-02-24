package com.silent.fiveghost.tourist.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;
class MyViewPagerAdapter extends FragmentPagerAdapter{
    List<String> listTab;
    List<Fragment> listFragment;
    public MyViewPagerAdapter(List<String> listTab, List<Fragment> listFragment, FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
        this.listTab=listTab;
        this.listFragment=listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab.get(position);
    }
}
