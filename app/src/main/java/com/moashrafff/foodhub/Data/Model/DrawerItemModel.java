package com.moashrafff.foodhub.Data.Model;

import android.view.ViewGroup;

import com.moashrafff.foodhub.Views.Adapters.DrawerAdapter;

public abstract class DrawerItemModel<T extends DrawerAdapter.DrawerViewHolder> {

    protected boolean isChecked;

    public abstract T createViewHolder(ViewGroup parent);

    public abstract void bindViewHolder(T holder);

    public DrawerItemModel<T> setChecked(boolean isChecked){
        this.isChecked = isChecked;
        return this;
    }
    public boolean isChecked(){
        return isChecked;
    }
    public boolean isSelectable(){
        return true;
    }
}
