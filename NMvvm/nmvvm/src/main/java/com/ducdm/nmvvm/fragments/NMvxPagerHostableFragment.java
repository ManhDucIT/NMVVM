package com.ducdm.nmvvm.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ducdm.nmvvm.fragments.INMvxFragment;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DucDM7 on 1/13/2017.
 */

public abstract class NMvxPagerHostableFragment<T extends ViewDataBinding, V extends NMvxViewModel> extends NMvxSimpleFragment<T, V> {

    private int layoutId;
    private int dataContextId;

    private T binding;
    private V viewModel;

    protected NMvxPagerHostableFragment(int layoutId, int dataContextId){
        this.layoutId = layoutId;
        this.dataContextId = dataContextId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        executeBinding(inflater, container);

        View view = binding.getRoot();

        initialize();

        return view;
    }

    private void executeBinding(LayoutInflater inflater, @Nullable ViewGroup container){
        binding = (T) DataBindingUtil.inflate(inflater, layoutId, container, false);
        binding.setVariable(dataContextId, viewModel);
    }

    protected abstract void initialize();

    protected T binding(){
        return binding;
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
