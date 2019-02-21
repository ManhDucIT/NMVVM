package com.ducdm.nmvvm.views;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ducdm.nmvvm.agents.INMvxHostablePopulator;
import com.ducdm.nmvvm.agents.INMvxHostablePresenter;
import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.agents.bundlizers.INMvxNavigationSerializer;
import com.ducdm.nmvvm.commons.Constants;
import com.ducdm.nmvvm.fragments.NMvxFragment;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

import java.io.InvalidObjectException;
import java.util.HashMap;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public abstract class NMvxHostableView<T extends ViewDataBinding, V extends NMvxViewModel> extends NMvxView<T, V> implements INMvxHostableView {

    private INMvxHostablePresenter presenter;
    private final HashMap<Class<? extends NMvxViewModel>, INMvxView> cachedSubViewModels = new HashMap<Class<? extends NMvxViewModel>, INMvxView>();

    protected NMvxHostableView(int layoutId, int dataContextId) {
        super(layoutId, dataContextId);
        presenter = NMvx.resolve(INMvxHostablePresenter.class);
    }

    @Override
    public void registerSubViews(int containerResId, Class<? extends NMvxViewModel>... viewModels) {
        if(presenter == null){
            throw new NullPointerException("Presenter not found");
        }

        for(Class<? extends NMvxViewModel> viewModel : viewModels){
            presenter.registerChild(viewModel, this);
        }

        presenter.registerContainer(containerResId);
    }

    @Override
    public INMvxView getView(Class<? extends NMvxViewModel> viewModelType) {
        if(cachedSubViewModels.containsKey(viewModelType)){
            return cachedSubViewModels.get(viewModelType);
        }

        INMvxHostablePopulator hostablePopulator = NMvx.resolve(INMvxHostablePopulator.class);
        INMvxView view = hostablePopulator.loadView(viewModelType);

        cachedSubViewModels.put(viewModelType, view);

        return view;
    }

    @Override
    public void showView(INMvxView view, NMvxViewModelWrapper viewModelWrapper, int containerResId) {
        try {
            String parameters = NMvx.resolve(INMvxNavigationSerializer.class).getSerializer().writeData(viewModelWrapper);
            if(parameters == null){
                return;
            }

            Bundle bundle = new Bundle();
            bundle.putString(Constants.NAVIGATION_KEY, parameters);

            ((NMvxFragment) view).setArguments(bundle);

            if(this instanceof AppCompatActivity){
                ((AppCompatActivity) this).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(containerResId, (NMvxFragment) view)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            } else {
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(containerResId, (NMvxFragment) view)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
