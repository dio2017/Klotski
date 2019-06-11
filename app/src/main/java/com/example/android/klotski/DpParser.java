package com.example.android.klotski;

import android.content.Context;

public class DpParser {

    private DpParser(){

    }

    /**
     * dp转px
     * @param context 上下文
     * @param value dp值
     * @return
     */
    public static int dp2px(Context context, float value){
        final float scale = GetScreen.getDensity(context);
        return (int)(value * scale + 0.5f);
    }

    /**
     * px转dp
     * @param context 上下文
     * @param value px值
     * @return
     */
    public static int px2dp(Context context, float value){
        final float scale = GetScreen.getDensity(context);
        return (int)(value / scale + 0.5f);
    }

    /**
     * sp转px
     * @param context 上下文
     * @param value sp值
     * @return
     */
    public static int sp2px(Context context, float value){
        final float scale = GetScreen.getDensity(context);
        return (int)(value * scale +0.5f);
    }

    /**
     * px转sp
     * @param context 上下文
     * @param value px值
     * @return
     */
    public static int px2sp(Context context, float value){
        final float scale = GetScreen.getDensity(context);
        return (int) (value / scale + 0.5f);
    }
}
