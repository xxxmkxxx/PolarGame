package com.xxxmkxxx.common.wrappers;

import java.util.ArrayList;
import java.util.List;

public class WrapperManager<W extends AbstractWrapper, M> {
    AbstractWrapper<W, M> wrapper;

    public List<W> convertList(List<M> models) {
        List<W> result = new ArrayList();

        for (M model : models) {
            result.add(wrapper.convertModel(model));
        }

        return result;
    }

    public WrapperManager(AbstractWrapper<W, M> wrapper) {
        this.wrapper = wrapper;
    }
}
