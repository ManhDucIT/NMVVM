package com.ducdm.app.viewmodels;

import android.databinding.Bindable;
import android.databinding.ObservableInt;

import com.ducdm.app.events.ISignInEvents;
import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.models.UserSignInModel;
import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.agents.models.NMvxBundle;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

import java.util.HashMap;

/**
 * Created by DangManhDuc on 12/11/2016.
 */

public class SignInViewModel extends NMvxViewModel implements ISignInEvents {

    private UserSignInModel userSignIn;
    private boolean shouldShown;

    public String lblChangeState = "Change State";

    private int num;

    public SignInViewModel(){
        super();
        setShouldShown(false);
    }

    @Bindable
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        notifyPropertyChanged(BR.num);
    }

    @Bindable
    public UserSignInModel getUserSignIn() {
        return userSignIn;
    }

    public void setUserSignIn(UserSignInModel userSignIn) {
        this.userSignIn = userSignIn;
        notifyPropertyChanged(BR.userSignIn);
    }

    @Override
    public void changeState() {
        setShouldShown(!isShouldShown());
    }

    @Override
    public void showHome() {
        showViewModel(HomeViewModel.class);
    }

    @Override
    public void showMain() {
        HashMap<String, String> bundle = new HashMap<String, String>();
        bundle.put("title", "Main view");
        showViewModel(MainViewModel.class, bundle);
    }

    @Bindable
    public boolean isShouldShown() {
        return shouldShown;
    }

    public void setShouldShown(boolean shouldShown) {
        this.shouldShown = shouldShown;
        notifyPropertyChanged(BR.shouldShown);
    }

}
