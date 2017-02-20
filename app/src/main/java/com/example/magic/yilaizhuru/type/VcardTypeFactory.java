package com.example.magic.yilaizhuru.type;

import android.view.View;

import com.example.magic.yilaizhuru.bean.ItemCommon;
import com.example.magic.yilaizhuru.bean.ItemMyQr;
import com.example.magic.yilaizhuru.bean.ItemQrInfo;
import com.example.magic.yilaizhuru.holder.BaseViewHolder;

/**
 * Created by magic on 17-1-20.
 */

public interface VcardTypeFactory {

    int type(ItemCommon itemCommon);

    int type(ItemMyQr itemMyQr);

    int type(ItemQrInfo itemQrInfo);

    BaseViewHolder createViewHolder(int type, View itemView);
}
