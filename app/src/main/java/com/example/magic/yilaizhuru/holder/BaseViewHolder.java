package com.example.magic.yilaizhuru.holder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.example.magic.yilaizhuru.adapter.VcardAdapter;

/**
 * Created by magic on 17-1-20.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    private View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        mItemView = itemView;
    }

    public View getView(int resID) {
        View view = views.get(resID);
        if (view == null) {
            view = mItemView.findViewById(resID);
            views.put(resID, view);
        }
        return view;
    }

    public abstract void setUpView(T model, int position, VcardAdapter adapter);
}
