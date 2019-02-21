package com.ducdm.nmvvm.views;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxView<TViewModel extends NMvxViewModel> {

    TViewModel viewModel();
    void setViewModel(TViewModel viewModel);

}
