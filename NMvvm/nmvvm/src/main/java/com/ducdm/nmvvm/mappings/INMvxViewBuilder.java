package com.ducdm.nmvvm.mappings;

import com.ducdm.nmvvm.views.INMvxView;

/**
 * Created by DucDM7 on 1/13/2017.
 */

public interface INMvxViewBuilder {

    INMvxView resolveViewInstance(Class<? extends INMvxView> viewType);

}
