package com.ducdm.app.views.fragments;

import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.nmvvm.R;
import com.ducdm.app.nmvvm.databinding.ThirdPageViewBinding;
import com.ducdm.app.viewmodels.subviewmodels.ThirdPageViewModel;
import com.ducdm.nmvvm.fragments.NMvxPagerHostableFragment;

public class ThirdPageView extends NMvxPagerHostableFragment<ThirdPageViewBinding, ThirdPageViewModel> {

    public ThirdPageView() {
        super(R.layout.third_page_view, BR.ThirdPageViewModel);
    }

    @Override
    protected void initialize() {

    }

}
