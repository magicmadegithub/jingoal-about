package com.example.magic.yilaizhuru.holder;

import android.view.View;
import android.widget.TextView;

import com.example.magic.yilaizhuru.R;
import com.example.magic.yilaizhuru.adapter.VcardAdapter;
import com.example.magic.yilaizhuru.bean.ItemQrInfo;

/**
 * Created by magic on 17-1-20.
 */

public class QrInfoViewHolder extends BaseViewHolder<ItemQrInfo> {

    public QrInfoViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(ItemQrInfo model, int position, VcardAdapter adapter) {
        TextView mTvInfo = (TextView) getView(R.id.tv_qrinfo);

        mTvInfo.setText(model.getTextInfo());
    }
}
