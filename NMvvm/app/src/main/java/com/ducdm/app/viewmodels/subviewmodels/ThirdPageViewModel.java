package com.ducdm.app.viewmodels.subviewmodels;

import android.databinding.Bindable;

import com.ducdm.app.nmvvm.BR;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DucDM7 on 1/12/2017.
 */

public class ThirdPageViewModel extends NMvxViewModel {

    private String pageTitle;

    public ThirdPageViewModel(){
        super();
        pageTitle = "Third Page";
    }

    @Bindable
    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        notifyPropertyChanged(BR.pageTitle);
    }

}
