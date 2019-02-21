package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxView;

/**
 * Created by DucDM7 on 1/13/2017.
 */

public interface INMvxHostablePopulator {

    INMvxView loadView(Class<? extends NMvxViewModel> viewModelType);

}
