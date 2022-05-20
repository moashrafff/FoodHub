//package com.moashrafff.foodhub.Views.Components;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.util.TypedValue;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.android.material.textfield.TextInputLayout;
//import com.moashrafff.foodhub.Helpers.SizeUtils;
//import com.moashrafff.foodhub.R;
//
//public class InputField  extends LinearLayout {
//    Context context;
//
//    public InputField(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        this.context = context;
//        setOrientation(VERTICAL);
//
//      TypedArray array =  context.obtainStyledAttributes(attrs,R.styleable.InputField);
//      String label = array.getString(R.styleable.InputField_if_label);
//      String hint = array.getString(R.styleable.InputField_if_hint);
//      int passwordDrawable = array.getResourceId(R.styleable.InputField_passwordToggleDrawable,0);
//
//
//
//        build(label,hint,passwordDrawable);
//    }
//
//    private void build(String labelText,String hint,int passwordDrawable) {
//        TextView label = new TextView(context);
//        label.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
//        label.setTextColor(context.getColor(R.color.auth_color));
//        label.setTypeface(getResources().getFont(R.font.sofia_regular));
//        label.setText(labelText);
//
//        TextInputLayout textInputLayout = new TextInputLayout(context,null, com.google.android.material.R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox_Dense);
//        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,65);
//        layoutParams.setMargins(0,SizeUtils.dpToPx(context,5),0,0);
//
//
//        TextInputEditText editText = new TextInputEditText(textInputLayout.getContext());
//        editText.setMaxLines(1);
//        editText.setHintTextColor(context.getColor(R.color.auth_hint_color));
//        editText.setTypeface(getResources().getFont(R.font.sofia_regular));
//        editText.setImeOptions(0x00000005);
//        editText.setHint(hint);
//
//
//
//
//        textInputLayout.setLayoutParams(layoutParams);
//        textInputLayout.setBoxStrokeColor(context.getColor(R.color.btn_color));
//        textInputLayout.setBoxStrokeWidth(SizeUtils.dpToPx(context,1));
//        textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
//        textInputLayout.setBoxCornerRadii((float) SizeUtils.dpToPx(context,5),(float) SizeUtils.dpToPx(context,5),(float) SizeUtils.dpToPx(context,5),(float) SizeUtils.dpToPx(context,5));
//        textInputLayout.setPasswordVisibilityToggleDrawable(passwordDrawable);
//        textInputLayout.setPasswordVisibilityToggleEnabled(true);
//
//
//        textInputLayout.addView(editText,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//
//        this.addView(label);
//        this.addView(textInputLayout);
//
//    }
//}
