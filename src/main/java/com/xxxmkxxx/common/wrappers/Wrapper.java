package com.xxxmkxxx.common.wrappers;

public interface Wrapper<T, M> {
    T convertModel(M model);
}
