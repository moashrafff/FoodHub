package com.moashrafff.foodhub.Views.Widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.moashrafff.foodhub.Helpers.SizeUtils;
import com.moashrafff.foodhub.R;

public class MainButton extends AppCompatButton {

    Context context;
    public MainButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setTextColor(context.getColor(R.color.white));
        setAllCaps(false);
        setGravity(0x11);
        setTypeface(getResources().getFont(R.font.sofia_semi_bold));
        setBackground(getDrawable(context.getColor(R.color.btn_color),75));
    }


    public Drawable getDrawable (int color, float radius){
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius((int) SizeUtils.DpTopx(radius, context));
        shape.setColor(color);

        return shape;
    }
}
