package com.example.magic.yilaizhuru.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.magic.yilaizhuru.bean.ViewItem;
import com.example.magic.yilaizhuru.holder.BaseViewHolder;
import com.example.magic.yilaizhuru.type.VcardTypeFactory;
import com.example.magic.yilaizhuru.type.VcardTypeFactoryImpl;

import java.util.List;

/**
 * Created by magic on 17-1-20.
 */

public class VcardAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private VcardTypeFactory factory;
    private List<ViewItem> models;

    public VcardAdapter(List<ViewItem> models) {
        factory = new VcardTypeFactoryImpl();
        this.models = models;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(viewType, parent, false);
        return factory.createViewHolder(viewType, itemView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setUpView(models.get(position), position, this);
    }

    @Override
    public int getItemCount() {
        if (models == null) {
            return 0;
        }
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position).type(factory);
    }
}
