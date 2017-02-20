package com.example.magic.yilaizhuru.holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.magic.yilaizhuru.R;
import com.example.magic.yilaizhuru.adapter.VcardAdapter;
import com.example.magic.yilaizhuru.bean.ItemMyQr;

/**
 * Created by magic on 17-1-20.
 */

public class MyQrViewHolder extends BaseViewHolder<ItemMyQr>{

    public MyQrViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(ItemMyQr model, int position, VcardAdapter adapter) {
        RelativeLayout mLayout = (RelativeLayout) getView(R.id.rl_myqr);
        TextView mTvName = (TextView) getView(R.id.tv_name);
        ImageView mIvArrow = (ImageView) getView(R.id.iv_arrow);

        mTvName.setText(model.getTextName());
        mIvArrow.setVisibility(model.isArrowVisible() ? View.VISIBLE : View.GONE);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Magic", "handleClick: MYQR");
            }
        });
    }
}
