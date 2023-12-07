package com.example.mymachinetesttechexactly.utils.utils2.misc;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class GridViewImageItem extends RelativeLayout {

    boolean expanded = false;

    public GridViewImageItem(Context context) {
        super(context);
    }

    public GridViewImageItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewImageItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // This is the key that will make the height equivalent to its width
    }


}
