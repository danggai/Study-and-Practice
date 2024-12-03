package com.example.tddexample.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/tddexample/util/NonNullMutableLiveData;", "T", "", "Landroidx/lifecycle/MutableLiveData;", "defaultValue", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "app_debug"})
public final class NonNullMutableLiveData<T extends java.lang.Object> extends androidx.lifecycle.MutableLiveData<T> {
    
    public NonNullMutableLiveData(@org.jetbrains.annotations.NotNull()
    T defaultValue) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public T getValue() {
        return null;
    }
}