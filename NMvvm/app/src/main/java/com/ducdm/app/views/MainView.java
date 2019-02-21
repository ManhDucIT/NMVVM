package com.ducdm.app.views;

import com.annimon.stream.Stream;
import com.ducdm.nmvvm.adapters.NMvxFragmentInfo;
import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.nmvvm.R;
import com.ducdm.app.nmvvm.databinding.MainViewBinding;
import com.ducdm.app.viewmodels.MainViewModel;
import com.ducdm.nmvvm.fragments.NMvxFragment;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.INMvxView;
import com.ducdm.nmvvm.views.NMvxHostableView;

import java.util.ArrayList;
import java.util.List;

import static com.annimon.stream.Collectors.toList;

public class MainView extends NMvxHostableView<MainViewBinding, MainViewModel> {

    public MainView() {
        super(R.layout.main_view, BR.MainViewModel);
    }

    @Override
    protected void initialize() {
        for(int i = 0; i < viewModel().getTabsInfo().size(); i++){
            binding().tabLayout.addTab(binding().tabLayout.newTab());
            binding().tabLayout.getTabAt(i).setText(viewModel().getTabsInfo().get(i).title);
        }

        List<Class<? extends NMvxViewModel>> list = Stream.of(viewModel().getTabsInfo())
                .map(x -> x.viewModelType)
                .collect(toList());
        Class<? extends NMvxViewModel> [] viewModels = list.toArray(new Class[list.size()]);

        registerSubViews(binding().defaultFragment.getId(), viewModels);
    }

    @Override
    public INMvxView getView(Class<? extends NMvxViewModel> viewModelType) {
        NMvxFragmentInfo tabInfo = Stream.of(viewModel().getTabsInfo())
                .filter(x -> x.viewModelType == viewModelType)
                .findFirst()
                .get();

        if(tabInfo == null){
            throw new NullPointerException("Invalid view model");
        }

        binding().tabLayout.getTabAt(viewModel().getTabsInfo().indexOf(tabInfo)).select();

        return super.getView(viewModelType);
    }

}