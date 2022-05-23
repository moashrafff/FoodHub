package com.moashrafff.foodhub.Views.Components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.moashrafff.foodhub.Helpers.SizeUtils;
import com.moashrafff.foodhub.R;

public class MainHeader extends LinearLayout {

    Context context;

    public MainHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;


        TypedArray array =  context.obtainStyledAttributes(attrs,R.styleable.MainHeader);
        String label = array.getString(R.styleable.MainHeader_mh_text_view);
        int drawable = array.getResourceId(R.styleable.MainHeader_mh_image2,0);
        float image2ShapeRadius = array.getInteger(R.styleable.MainHeader_mh_image2_radius,0);
        int image2ShapeColor= array.getColor(R.styleable.MainHeader_mh_image2_color,0);

        setOrientation(HORIZONTAL);
        build(label,drawable,image2ShapeRadius,image2ShapeColor);

    }

    private void build(String textViewText, int secondImageViewSrc, float image2ShapeRadius, int image2ShapeColor ) {

        ImageView imageView = new ImageView(context);

        LayoutParams layoutParams = new LayoutParams((int) SizeUtils.DpTopx(40, context), (int) SizeUtils.DpTopx(40, context));
        layoutParams.setMarginStart((int) SizeUtils.DpTopx(17, context));
        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.back_btn);
        imageView.setBackground(getDrawable(context.getColor(R.color.white), 15));
        imageView.setPadding((int) SizeUtils.DpTopx(12, context), (int) SizeUtils.DpTopx(12, context), (int) SizeUtils.DpTopx(12, context), (int) SizeUtils.DpTopx(12, context));
        imageView.setElevation((int) SizeUtils.DpTopx(2, context));
        imageView.setClickable(true);




        TextView textView = new TextView(context);
        LayoutParams textViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        textViewParams.gravity = Gravity.CENTER;
        textView.setLayoutParams(textViewParams);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        textView.setTextColor(context.getColor(R.color.header_text_view_color));
        textView.setTypeface(getResources().getFont(R.font.sofia_meduim));
        textView.setText(textViewText);
        textView.setGravity(Gravity.CENTER);



        ImageView imageView2 = new ImageView(context);
        LayoutParams imageView2Params = new LayoutParams((int) SizeUtils.DpTopx(40, context), (int) SizeUtils.DpTopx(40, context));
        imageView2Params.setMarginEnd((int) SizeUtils.DpTopx(17, context));
        imageView2Params.gravity = Gravity.END;
        imageView2.setLayoutParams(imageView2Params);
        imageView2.setImageResource(secondImageViewSrc);
        imageView2.setElevation((int) SizeUtils.DpTopx(2, context));
        imageView2.setPadding((int) SizeUtils.DpTopx(10, context),(int) SizeUtils.DpTopx(10, context),(int) SizeUtils.DpTopx(10, context),(int) SizeUtils.DpTopx(10, context));
        imageView2.setBackground(getDrawable(image2ShapeColor, (int)SizeUtils.pxToDp(context,image2ShapeRadius)));
        imageView2.setClickable(true);



        this.addView(imageView);
        this.addView(textView);
        this.addView(imageView2);


    }

    private Drawable getDrawable(int color, int radius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius((int) SizeUtils.DpTopx(radius, context));
        shape.setColor(color);

        return shape;
    }


}
