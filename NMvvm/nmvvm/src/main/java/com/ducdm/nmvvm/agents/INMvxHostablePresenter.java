package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxHostableView;
import com.ducdm.nmvvm.views.INMvxView;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public interface INMvxHostablePresenter {

    void registerChild(Class<? extends NMvxViewModel> viewModelType, INMvxHostableView hostableView);
    void registerContainer(int containerResId);

}
