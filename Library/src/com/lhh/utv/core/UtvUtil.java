package com.lhh.utv.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by linhonghong on 2015/7/6.
 */
public class UtvUtil {

    public static float getRawSize(int unit, float size, Context context) {
        Resources r;
        r = context.getResources();
        return TypedValue.applyDimension(unit, size, r.getDisplayMetrics());
    }
}
