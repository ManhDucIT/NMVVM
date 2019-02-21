package com.ducdm.app.conveters;

import android.databinding.BindingConversion;
import android.view.View;

import com.ducdm.nmvvm.atrributes.ValueConverter;
import com.ducdm.nmvvm.converters.NMvxValueConverter;

/**
 * Created by LapTop on 1/11/2017.
 */
public class VisibilityValueConverter {

    @BindingConversion
    public static Integer convert(Boolean fromValue) {
        return fromValue ? View.VISIBLE : View.INVISIBLE;
    }

}
