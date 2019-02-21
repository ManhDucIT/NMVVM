package com.ducdm.nmvvm.views;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.agents.bundlizers.INMvxNavigationSerializer;
import com.ducdm.nmvvm.agents.finders.INMvxCurrentTopView;
import com.ducdm.nmvvm.commons.Constants;
import com.ducdm.nmvvm.fragments.NMvxFragment;
import com.ducdm.nmvvm.mappings.INMvxViewModelBuilder;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.viewmodels.NMvxSplashViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public abstract class NMvxView<T extends ViewDataBinding, V extends NMvxViewModel> extends AppCompatActivity implements INMvxView<V> {

    private int layoutId;
    private int dataContextId;

    private V viewModel;
    private T binding;

    private INMvxViewModelBuilder viewModelBuilder;
    private INMvxCurrentTopView currentTopView;

    protected NMvxView(int layoutId, int dataContextId){
        this.layoutId = layoutId;
        this.dataContextId = dataContextId;
        currentTopView = NMvx.resolve(INMvxCurrentTopView.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentTopView.setCurrentTopView(this);

        NMvxViewModelWrapper bundle = parseBundleData(getIntent().getStringExtra(Constants.NAVIGATION_KEY));

        executeBinding(bundle);

        initialize();
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
            viewModel = (V) new NMvxSplashViewModel();
        }

        return bundle;
    }

    private void executeBinding(NMvxViewModelWrapper bundle){
        binding = (T) DataBindingUtil.setContentView(this, layoutId);
        binding.setVariable(dataContextId, viewModel);

        viewModel.onInitialize(bundle != null ? bundle.getBundleParameters() : null);
        viewModel.onStart();
        viewModel.onRestoreStates(bundle != null ? bundle.getSavedStatesParameters() : null);
    }

    protected abstract void initialize();

    protected T binding() {
        return binding;
    }

    @Override
    public V viewModel() {
        return viewModel;
    }

    @Override
    public void setViewModel(NMvxViewModel viewModel) {
        this.viewModel = (V) viewModel;
    }

}
