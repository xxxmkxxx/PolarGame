package com.xxxmkxxx.common.wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class WrapperManager<W extends AbstractWrapper, M> {
    AbstractWrapper<W, M> wrapper;

    public List<W> convertList(List<M> models) {
        List<W> result = new ArrayList();

        for (int i = 0; i < models.size(); i++) {
            result.add(wrapper.convertModel(models.get(i)));
        }

        return result;
    }

    public WrapperManager(AbstractWrapper<W, M> wrapper) {
        this.wrapper = wrapper;
    }
}
