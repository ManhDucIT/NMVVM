package com.ducdm.nmvvm.views;

import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public interface INMvxHostableView {

    void registerSubViews(int containerResId, Class<? extends NMvxViewModel>... viewModels);
    INMvxView getView(Class<? extends NMvxViewModel> viewModelType);
    void showView(INMvxView view, NMvxViewModelWrapper viewModelWrapper, int containerResId);

}
