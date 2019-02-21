package com.ducdm.nmvvm.agents.finders;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxView;
import com.ducdm.nmvvm.views.NMvxView;

import java.util.HashMap;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxDynamicViewModelViewLoader {

    void startMapping();
    HashMap<Class<? extends NMvxViewModel>, Class<INMvxView>> getQueryResults();

}
