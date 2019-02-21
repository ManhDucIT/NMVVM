package com.ducdm.nmvvm.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.agents.bundlizers.INMvxNavigationSerializer;
import com.ducdm.nmvvm.commons.Constants;
import com.ducdm.nmvvm.mappings.INMvxViewModelBuilder;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxSplashViewModel;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by LapTop on 1/11/2017.
 */

public abstract class NMvxFragment<T extends ViewDataBinding, V extends NMvxViewModel> extends NMvxSimpleFragment<T, V> {

    private int layoutId;
    private int dataContextId;

    private T binding;
    private V viewModel;

    protected NMvxFragment(int layoutId, int dataContextId){
        this.layoutId = layoutId;
        this.dataContextId = dataContextId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        NMvxViewModelWrapper bundle = parseBundleData(getArguments().getString(Constants.NAVIGATION_KEY));

        executeBinding(inflater, container, bundle);

        View view = binding.getRoot();

        initialize();

        return view;
    }

    private NMvxViewModelWrapper parseBundleData(String extra){
        NMvxViewModelWrapper bundle = null;
        if(extra != null && !extra.isEmpty()){
            bundle = NMvx.resolve(INMvxNavigationSerializer.class).getSerializer().readData(extra, NMvxViewModelWrapper.class);
            if(bundle != null){
                INMvxViewModelBuilder viewModelBuilder = NMvx.resolve(INMvxViewModelBuilder.class);
                viewModel = viewModelBuilder.resolveViewModelInstance(bundle.getViewModelType());
            }
        } else {
            throw new NullPointerException("No view model attached");
        }

        return bundle;
    }

    private void executeBinding(LayoutInflater inflater, @Nullable ViewGroup container, NMvxViewModelWrapper bundle){
        binding = (T) DataBindingUtil.inflate(inflater, layoutId, container, false);
        binding.setVariable(dataContextId, viewModel);

        viewModel.onInitialize(bundle != null ? bundle.getBundleParameters() : null);
        viewModel.onStart();
        viewModel.onRestoreStates(bundle != null ? bundle.getSavedStatesParameters() : null);
    }

    protected abstract void initialize();

    protected T binding(){
        return binding;
    }

    public void setBinding(T binding) {
        this.binding = binding;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public void setDataContextId(int dataContextId) {
        this.dataContextId = dataContextId;
    }

    @Override
    public NMvxViewModel viewModel() {
        return viewModel;
    }

    @Override
    public void setViewModel(NMvxViewModel viewModel) {
        this.viewModel = (V) viewModel;
    }
}
