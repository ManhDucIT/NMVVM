package com.ducdm.nmvvm.converters;

import android.databinding.BindingConversion;

/**
 * Created by LapTop on 1/11/2017.
 */

public abstract class NMvxValueConverter<TFrom, TTo> {

    public abstract TTo convert(TFrom fromValue);

}
