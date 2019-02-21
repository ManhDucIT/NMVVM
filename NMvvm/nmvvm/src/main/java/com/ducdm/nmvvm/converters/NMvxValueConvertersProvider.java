package com.ducdm.nmvvm.converters;

import com.annimon.stream.Stream;
import com.ducdm.nmvvm.agents.finders.LoaderQuery;
import com.ducdm.nmvvm.atrributes.Construct;

/**
 * Created by LapTop on 1/11/2017.
 */

public class NMvxValueConvertersProvider implements INMvxValueConvertersProvider {

    private LoaderQuery scannedZone;

    @Construct
    public NMvxValueConvertersProvider(LoaderQuery scannedZone){
        this.scannedZone = scannedZone;
    }

    @Override
    public <T> T getBindingConverter(Class<T> converterType) throws IllegalAccessException, InstantiationException {
        Class<?> foundConverter = Stream.of(scannedZone)
                .filter(x -> x.getSimpleName().equals(converterType.getSimpleName()))
                .findFirst()
                .get();

        if(foundConverter == null){
            return null;
        }

        return (T) foundConverter.newInstance();
    }

}
