package com.ducdm.app.viewmodels;

import com.ducdm.nmvvm.adapters.NMvxFragmentInfo;
import com.ducdm.app.viewmodels.subviewmodels.FirstPageViewModel;
import com.ducdm.app.viewmodels.subviewmodels.SecondPageViewModel;
import com.ducdm.app.viewmodels.subviewmodels.ThirdPageViewModel;
import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.plugins.dialogs.INMvxDialogs;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public class MainViewModel extends NMvxViewModel {

    private ArrayList<NMvxFragmentInfo> tabsInfo;
    public Consumer<Integer> tabSelectedCommand;
    public String title;

    private INMvxDialogs dialogs;


    public MainViewModel(){
        super();
        dialogs = NMvx.resolve(INMvxDialogs.class);

        tabsInfo = new ArrayList<NMvxFragmentInfo>();
        tabsInfo.add(new NMvxFragmentInfo("A", FirstPageViewModel.class));
        tabsInfo.add(new NMvxFragmentInfo("B", SecondPageViewModel.class));
        tabsInfo.add(new NMvxFragmentInfo("C", ThirdPageViewModel.class));

        tabSelectedCommand = selectedPosition  -> {
            showViewModel(tabsInfo.get(selectedPosition).viewModelType);
        };
    }

    @Override
    public void onInitialize(INMvxBundle bundle) {
        super.onInitialize(bundle);
        title = bundle.getBundleData().get("title");
        dialogs.showToast(title, 2000);
    }

    public ArrayList<NMvxFragmentInfo> getTabsInfo(){
        return tabsInfo != null ? tabsInfo : new ArrayList<NMvxFragmentInfo>();
    }

}
