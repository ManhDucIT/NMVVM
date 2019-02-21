package com.ducdm.nmvvm.agents.finders;

import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxView;
import com.ducdm.nmvvm.views.NMvxView;

import java.security.InvalidParameterException;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxViewLookupper implements INMvxViewLookupper {

    private INMvxDynamicViewModelViewLoader loader;

    public NMvxViewLookupper(){
        loader = NMvx.resolve(INMvxDynamicViewModelViewLoader.class);
    }

    @Override
    public Class<INMvxView> lookupViewType(Class<? extends NMvxViewModel> viewModelType) {
        Class<INMvxView> correspondingViewType = loader.getQueryResults().get(viewModelType);
        if(correspondingViewType == null){
            throw new InvalidParameterException(new String().format("Can not lookup view for viewmodel {0}", viewModelType.getClass().getSimpleName()));
        }

        return correspondingViewType;
    }

}
