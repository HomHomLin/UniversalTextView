package com.lhh.utv.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

import com.lhh.utv.core.UtvUtil;
import com.lhh.utv.impl.ImageImpl;

/**
 * Created by linhonghong on 2015/7/6.
 */
public class ImageEditText extends EditText implements ImageImpl {

    private Context mContext;
    private SpannableStringBuilder mSpannableString;
    private final static int DEFAULT_SIZE_DX = 3;

    public ImageEditText(Context context) {
        super(context);
        init(context);
    }

    public ImageEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImageEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context){
        this.mContext = context;
        mSpannableString = new SpannableStringBuilder();
    }

    @Override
    public void appendText(CharSequence text) {
        mSpannableString.append(text);
        super.setText(mSpannableString);
    }

    @Override
    public void appendImage(int res){
        appendImage(res, DEFAULT_SIZE_DX);
    }

    @Override
    public void appendImage(int res, int sizeDx){
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), res, null);
        appendImage(drawable,sizeDx);
    }

    @Override
    public void appendImage(Bitmap bitmap){
        appendImage(bitmap, DEFAULT_SIZE_DX);
    }

    @Override
    public void appendImage(Bitmap bitmap, int sizeDx){
        Drawable drawable = new BitmapDrawable(getResources(),bitmap);
        appendImage(drawable,sizeDx);
    }

    @Override
    public void appendImage(Drawable drawable){
        appendImage(drawable, DEFAULT_SIZE_DX);
    }

    @Override
    public void appendImage(Drawable drawable, int sizeDx){
        if(drawable == null){
            //If the drawable which you add is null, the imageTextview will add "" into the textview
            appendNull();
            return;
        }
        mSpannableString.append("h");

        int drawableWidth = drawable.getIntrinsicWidth();
        int drawableHeight = drawable.getIntrinsicHeight();
        int height = (int)this.getTextSize() +
                (int) UtvUtil.getRawSize(TypedValue.COMPLEX_UNIT_DIP, sizeDx, mContext);
        int width = drawableWidth * height / drawableHeight;
        drawable.setBounds(0, 0, width, height);
        ImageSpan is = new ImageSpan(drawable);
        mSpannableString.setSpan(is, mSpannableString.length() - 1,
                mSpannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        appendNull();
    }

    @Override
    public void clearText(){
        mSpannableString.clear();
        appendNull();
    }

    private final void appendNull(){
        appendText("");
    }
}
