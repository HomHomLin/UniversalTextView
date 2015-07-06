package com.lhh.utv.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by linhonghong on 2015/7/6.
 */
public interface ImageImpl {

    /**
     * 增加文字
     * @param text
     */
    public void appendText(CharSequence text);

    /**
     * 增加图片，通过id
     * @param res
     */
    public void appendImage(int res);

    /**
     * 增加图片，并传递一个图片大小的偏移量
     * @param res
     * @param sizeDx
     */
    public void appendImage(int res, int sizeDx);

    /**
     * 增加图片，Bitmap参数
     * @param bitmap
     */
    public void appendImage(Bitmap bitmap);

    /**
     * 增加图片，bitmap并传递一个图片大小偏移量
     * @param bitmap
     * @param sizeDx
     */
    public void appendImage(Bitmap bitmap, int sizeDx);

    /**
     * 增加图片，通过Drawable
     * @param drawable
     */
    public void appendImage(Drawable drawable);

    /**
     * 增加图片，通过drawable，并指定图片大小偏移量
     * @param drawable
     * @param sizeDx
     */
    public void appendImage(Drawable drawable, int sizeDx);

    /**
     * 清除所有文本
     */
    public void clearText();

}
