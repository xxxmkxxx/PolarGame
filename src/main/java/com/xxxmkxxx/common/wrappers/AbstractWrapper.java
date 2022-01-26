package com.xxxmkxxx.common.wrappers;

public abstract class AbstractWrapper<T, M> implements Wrapper<T, M> {
    public abstract T convertModel(M model);
}
