package com.tangpj.order.pojo;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Objects;

import java.util.UUID;

public class Dish {
    private final String mId;
    private final String mName;
    private final String mDescription;
    private boolean isSelect;

    public Dish(String id, String name, String mDescription){
        this.mId = id;
        this.mName = name;
        this.mDescription = mDescription;
    }

    public Dish(String name, String mDescription){
        this(UUID.randomUUID().toString(), name, mDescription);
    }

    @NonNull
    public String getId(){
        return mId;
    }

    @Nullable
    public String getName(){
        return mName;
    }

    @Nullable
    public String getDescription(){
        return mDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish task = (Dish) o;
        return Objects.equal(mId, task.mId) &&
                Objects.equal(mName, task.mName) &&
                Objects.equal(mDescription, task.mDescription);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mName,  mDescription);
    }


}
