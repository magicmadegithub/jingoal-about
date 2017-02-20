package com.example.magic.yilaizhuru.type;

import android.view.View;

import com.example.magic.yilaizhuru.R;
import com.example.magic.yilaizhuru.bean.ItemCommon;
import com.example.magic.yilaizhuru.bean.ItemMyQr;
import com.example.magic.yilaizhuru.bean.ItemQrInfo;
import com.example.magic.yilaizhuru.holder.BaseViewHolder;
import com.example.magic.yilaizhuru.holder.CommonViewHolder;
import com.example.magic.yilaizhuru.holder.MyQrViewHolder;
import com.example.magic.yilaizhuru.holder.QrInfoViewHolder;

/**
 * Created by magic on 17-1-20.
 */

public class VcardTypeFactoryImpl implements VcardTypeFactory {

    private final int TYPE_RESOURCE_COMMON = R.layout.layout_item_common;
    private final int TYPE_RESOURCE_MYQR = R.layout.layout_item_myqr;
    private final int TYPE_RESOURCE_QRINFO = R.layout.layout_item_qrinfo;

    @Override
    public int type(ItemCommon itemCommon) {
        return TYPE_RESOURCE_COMMON;
    }

    @Override
    public int type(ItemMyQr itemMyQr) {
        return TYPE_RESOURCE_MYQR;
    }

    @Override
    public int type(ItemQrInfo itemQrInfo) {
        return TYPE_RESOURCE_QRINFO;
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        BaseViewHolder viewHolder = null;
        switch (type) {
            case TYPE_RESOURCE_COMMON:
                viewHolder = new CommonViewHolder(itemView);
                break;
            case TYPE_RESOURCE_MYQR:
                viewHolder = new MyQrViewHolder(itemView);
                break;
            case TYPE_RESOURCE_QRINFO:
                viewHolder = new QrInfoViewHolder(itemView);
                break;
            default:
                break;
        }
        return viewHolder;
    }
}
