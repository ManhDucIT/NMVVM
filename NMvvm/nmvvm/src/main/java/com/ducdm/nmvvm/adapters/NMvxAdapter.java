package com.ducdm.nmvvm.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ducdm.nmvvm.agents.INMvxHostablePopulator;
import com.ducdm.nmvvm.fragments.NMvxFragment;
import com.ducdm.nmvvm.fragments.NMvxSimpleFragment;
import com.ducdm.nmvvm.mappings.INMvxViewModelBuilder;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.fragments.NMvxPagerHostableFragment;

import java.util.ArrayList;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public class NMvxAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<NMvxFragmentInfo> fragments;

    private INMvxHostablePopulator hostablePopulator;
    private INMvxViewModelBuilder viewModelBuilder;

    public NMvxAdapter(FragmentManager fm, Context context, ArrayList<NMvxFragmentInfo> fragments) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.hostablePopulator = NMvx.resolve(INMvxHostablePopulator.class);
        this.viewModelBuilder = NMvx.resolve(INMvxViewModelBuilder.class);
    }

    @Override
    public Fragment getItem(int position) {
        NMvxFragmentInfo fragmentInfo = fragments.get(position);
        NMvxSimpleFragment fragment = null;
        try{
            fragment = loadViewModel(fragmentInfo);
        } catch (Exception ex) {
            throw new Resources.NotFoundException("Could not load view model");
        }

        return fragment;
    }

    protected NMvxSimpleFragment loadViewModel(NMvxFragmentInfo fragmentInfo){
        NMvxSimpleFragment fragment = (NMvxSimpleFragment) hostablePopulator.loadView(fragmentInfo.viewModelType);
        NMvxViewModel viewModel = viewModelBuilder.resolveViewModelInstance(fragmentInfo.viewModelType);

        fragment.setViewModel(viewModel);

        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).title;
    }

}
