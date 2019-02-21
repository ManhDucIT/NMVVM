package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.agents.finders.NMvxViewLookupper;
import com.ducdm.nmvvm.mappings.INMvxViewBuilder;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxView;

/**
 * Created by DucDM7 on 1/13/2017.
 */

public class NMvxHostablePopulator extends NMvxViewLookupper implements INMvxHostablePopulator {

    private INMvxViewBuilder viewBuilder;

    public NMvxHostablePopulator(){
        viewBuilder = NMvx.resolve(INMvxViewBuilder.class);
    }

    @Override
    public INMvxView loadView(Class<? extends NMvxViewModel> viewModelType) {
        return loadViewByViewModelType(viewModelType);
    }

    private INMvxView loadViewByViewModelType(Class<? extends NMvxViewModel> viewModelType){
        Class<? extends INMvxView> viewType = lookupViewType(viewModelType);
        INMvxView view = viewBuilder.resolveViewInstance(viewType);

        if(view == null){
            throw new NullPointerException("Unable to load view for view model " + viewModelType.getName());
        }

        return view;
    }

}
