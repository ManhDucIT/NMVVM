package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxHostableView;
import com.ducdm.nmvvm.views.INMvxView;

import java.util.HashMap;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public class NMvxHostablePresenter extends NMvxViewPresenter implements INMvxHostablePresenter {

    private final HashMap<Class<? extends NMvxViewModel>, INMvxHostableView> hostableContainer = new HashMap<Class<? extends NMvxViewModel>, INMvxHostableView>();
    private int containerResId = -1;

    public NMvxHostablePresenter(){
    }

    @Override
    public void showView(NMvxViewModelWrapper viewModelWrapper) {
        if(viewModelWrapper.getViewModelType() == null){
            throw new NullPointerException("No view model attached");
        }

        if(hostableContainer.containsKey(viewModelWrapper.getViewModelType())){
            INMvxHostableView hostableView = hostableContainer.get(viewModelWrapper.getViewModelType());
            INMvxView pendingSubView = hostableView.getView(viewModelWrapper.getViewModelType());
            if(pendingSubView != null && containerResId != -1){
                hostableView.showView(pendingSubView, viewModelWrapper, containerResId);
            }
        }

        super.showView(viewModelWrapper);
    }

    @Override
    public void registerChild(Class<? extends NMvxViewModel> viewModelType, INMvxHostableView hostableView) {
        if(viewModelType == null || hostableView == null){
            return;
        }

        hostableContainer.put(viewModelType, hostableView);
    }

    @Override
    public void registerContainer(int containerResId) {
        this.containerResId = containerResId;
    }

}
