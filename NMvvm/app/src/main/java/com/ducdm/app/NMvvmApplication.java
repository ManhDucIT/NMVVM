package com.ducdm.app;

import android.content.Context;

import com.ducdm.app.services.DeviceInfo;
import com.ducdm.app.services.IDeviceInfo;
import com.ducdm.app.viewmodels.PagerViewModel;
import com.ducdm.nmvvm.NMvxApplication;
import com.ducdm.nmvvm.agents.INMvxHostablePresenter;
import com.ducdm.nmvvm.agents.INMvxViewPresenter;
import com.ducdm.nmvvm.agents.NMvxHostablePresenter;
import com.ducdm.nmvvm.mappings.NMvx;

/**
 * Created by DangManhDuc on 12/11/2016.
 */

public class NMvvmApplication extends NMvxApplication {

    @Override
    public void initialize() {
        super.initialize();

//        new NMvxLoaderExtension.Builder(getPackageName() + ".services")
//                .load()
//                .queryInterfaces()
//                .registerType()
//                .build();

        NMvx.registerType(IDeviceInfo.class, DeviceInfo.class);

        registerAppStart(PagerViewModel.class);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    // TODO: do custom presenter
    @Override
    protected INMvxViewPresenter createViewPresenter() {
        NMvxHostablePresenter presenter = new NMvxHostablePresenter();
        NMvx.registerSingleton(INMvxHostablePresenter.class, presenter);

        return presenter;
    }

//    class CustomViewPresenter extends NMvxViewPresenter {
//
//        @Override
//        public void showView(NMvxViewModelWrapper viewModelWrapper) {
//            Intent intent = this.buildIntent(viewModelWrapper);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            // TODO: do some custom with intent
//
//            this.show(intent);
//        }
//
//    }

}
