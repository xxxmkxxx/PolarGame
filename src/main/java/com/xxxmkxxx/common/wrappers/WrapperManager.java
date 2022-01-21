package com.xxxmkxxx.common.wrappers;

import java.util.List;

public class WrapperManager<W, M> {
    private Wrapper<W, M> wrapper;

    public List<W> convertList(List<M> models) {
        return wrapper.convertList(models);
    }

    public WrapperManager(Wrapper<W, M> wrapper) {
        this.wrapper = wrapper;
    }
}
