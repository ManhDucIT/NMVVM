package com.ducdm.app.views.fragments;

import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.nmvvm.R;
import com.ducdm.app.nmvvm.databinding.FirstPageViewBinding;
import com.ducdm.app.viewmodels.subviewmodels.FirstPageViewModel;
import com.ducdm.nmvvm.fragments.NMvxPagerHostableFragment;

public class FirstPageView extends NMvxPagerHostableFragment<FirstPageViewBinding, FirstPageViewModel> { // NMvxFragment

    public FirstPageView() {
        super(R.layout.first_page_view, BR.FirstPageViewModel);
    }

    @Override
    protected void initialize() {

    }

}
