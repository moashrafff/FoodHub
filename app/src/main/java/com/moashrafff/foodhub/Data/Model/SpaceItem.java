package com.moashrafff.foodhub.Data.Model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Views.Adapters.DrawerAdapter;

public class SpaceItem extends DrawerItemModel<SpaceItem.ViewHolder>{

    private int spaceDp;

    public SpaceItem(int spaceDp) {
        this.spaceDp = spaceDp;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {

        Context context = parent.getContext();
        View view = new View(context);
        int height = (int) (context.getResources().getDisplayMetrics().density*spaceDp);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height));


        return new ViewHolder(view);
    }

    @Override
    public boolean isSelectable() {
        return false;
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {

    }

    public class ViewHolder extends DrawerAdapter.DrawerViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
