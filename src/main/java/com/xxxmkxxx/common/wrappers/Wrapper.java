package com.xxxmkxxx.common.wrappers;

import java.util.List;

public abstract class Wrapper<T, M> {
    public abstract List<T> convertList(List<M> models);
}
