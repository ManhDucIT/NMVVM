package com.ducdm.app.views.fragments;

import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.nmvvm.R;
import com.ducdm.app.nmvvm.databinding.SecondPageViewBinding;
import com.ducdm.app.viewmodels.subviewmodels.SecondPageViewModel;
import com.ducdm.nmvvm.fragments.NMvxPagerHostableFragment;

public class SecondPageView extends NMvxPagerHostableFragment<SecondPageViewBinding, SecondPageViewModel> {

    public SecondPageView() {
        super(R.layout.second_page_view, BR.SecondPageViewModel);
    }

    @Override
    protected void initialize() {

    }

}
