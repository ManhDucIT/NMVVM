package com.ducdm.nmvvm.adapters;

import com.ducdm.nmvvm.fragments.NMvxFragment;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxView;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public class NMvxFragmentInfo {

    public String title;
    public Class<? extends NMvxViewModel> viewModelType;

    public NMvxFragmentInfo(String title, Class<? extends NMvxViewModel> viewModelType) {
        this.title = title;
        this.viewModelType = viewModelType;
    }

}
