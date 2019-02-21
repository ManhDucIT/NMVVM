package com.ducdm.nmvvm.mappings;

import com.ducdm.nmvvm.views.INMvxView;

import java.lang.reflect.Constructor;

/**
 * Created by DucDM7 on 1/13/2017.
 */

public class IoCViewBuilder extends IoCContainer implements INMvxViewBuilder {

    public IoCViewBuilder() {
    }

    @Override
    public INMvxView resolveViewInstance(Class<? extends INMvxView> viewType) {
        Object resolvedObject = null;

        try {
            resolvedObject = this.createInstance(viewType.getConstructor(new Class<?>[0]), RegistrationType.INSTANCE, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (INMvxView) resolvedObject;
    }

}
