package com.ducdm.nmvvm.fragments;

import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DucDM7 on 1/13/2017.
 */

public abstract class NMvxSimpleFragment<T extends ViewDataBinding, V extends NMvxViewModel> extends Fragment implements INMvxFragment {

}
