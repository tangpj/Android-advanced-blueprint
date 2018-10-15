package com.tangpj.order.pojo;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Objects;

import java.util.UUID;

public class Dish {
    private final String mId;
    private final String mName;
    private final String mDescription;
    private final boolean isSelect;

    public Dish(String id, String name, String mDescription, boolean isSelect){
        this.mId = id;
        this.mName = name;
        this.mDescription = mDescription;
        this.isSelect = isSelect;
    }

    public Dish(String name, String mDescription, boolean isSelect ){
        this(UUID.randomUUID().toString(), name, mDescription ,isSelect);
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

    @Nullable
    public boolean getIsSelect(){
        return isSelect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish task = (Dish) o;
        return Objects.equal(mId, task.mId) &&
                Objects.equal(mName, task.mName) &&
                Objects.equal(mDescription, task.mDescription) &&
                Objects.equal(isSelect, task.isSelect);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mName,  mDescription, isSelect);
    }


}
