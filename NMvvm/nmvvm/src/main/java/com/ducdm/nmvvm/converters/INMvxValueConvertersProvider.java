package com.ducdm.nmvvm.converters;

/**
 * Created by LapTop on 1/11/2017.
 */

public interface INMvxValueConvertersProvider {

    <T> T getBindingConverter(Class<T> converterType) throws IllegalAccessException, InstantiationException;

}
