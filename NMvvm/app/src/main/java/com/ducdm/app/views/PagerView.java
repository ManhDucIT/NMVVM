package com.ducdm.app.views;

import android.support.design.widget.TabLayout;

import com.ducdm.app.nmvvm.databinding.PagerViewBinding;
import com.ducdm.app.viewmodels.PagerViewModel;
import com.ducdm.nmvvm.adapters.NMvxAdapter;
import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.nmvvm.R;
import com.ducdm.nmvvm.views.NMvxHostableView;

public class PagerView extends NMvxHostableView<PagerViewBinding, PagerViewModel> {

    private NMvxAdapter adapter;

    public PagerView() {
        super(R.layout.pager_view, BR.PagerViewModel);
    }

    @Override
    protected void initialize() {
        adapter = new NMvxAdapter(getSupportFragmentManager(), this, viewModel().getTabsInfo());
        binding().viewPager.setAdapter(adapter);
        binding().viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding().tabLayout));
        binding().tabLayout.setupWithViewPager(binding().viewPager);
    }

}