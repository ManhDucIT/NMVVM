package com.ducdm.nmvvm.agents.finders;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxView;
import com.ducdm.nmvvm.views.NMvxView;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxViewLookupper {

    Class<INMvxView> lookupViewType(Class<? extends NMvxViewModel> viewModelType);

}
