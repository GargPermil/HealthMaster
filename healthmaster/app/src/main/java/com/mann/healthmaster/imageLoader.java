package com.mann.healthmaster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

public class imageLoader {

    public static Bitmap imageLoad(Context context, String path) {
        Bitmap result = null;
        if(path==null)
        {
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_account_circle_black_24dp);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                drawable = (DrawableCompat.wrap(drawable)).mutate();
            }

            result = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        return result;
    }
}
