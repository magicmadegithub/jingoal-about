package com.example.magic.yilaizhuru.itemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.magic.yilaizhuru.R;
import com.example.magic.yilaizhuru.util.ViewUtil;

/**
 * Created by magic on 17-1-21.
 */

public class SimpleDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight;
    private Paint dividerPaint;

    public SimpleDecoration(Context context) {
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.colorDivider));
        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int right = parent.getWidth() - parent.getPaddingRight();
        int padding = ViewUtil.dp2px(parent.getContext(), 12);
        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            int left = parent.getPaddingLeft() + padding;
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
            if (view.getId() == R.id.ll_qr) {
                //二维码信息布局，画上下两条没有padding的横线
                left = parent.getPaddingLeft();
                c.drawRect(left, view.getTop() - dividerHeight, right, view.getTop(), dividerPaint);
            }
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }
}
