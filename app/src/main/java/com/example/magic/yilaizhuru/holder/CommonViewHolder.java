package com.example.magic.yilaizhuru.holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.magic.yilaizhuru.R;
import com.example.magic.yilaizhuru.adapter.VcardAdapter;
import com.example.magic.yilaizhuru.bean.ItemCommon;
import com.example.magic.yilaizhuru.util.VcardItemType;

/**
 * Created by magic on 17-1-20.
 */

public class CommonViewHolder extends BaseViewHolder<ItemCommon> {

    public CommonViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(final ItemCommon model, int position, VcardAdapter adapter) {
        LinearLayout mLayout = (LinearLayout) getView(R.id.ll_common);
        TextView mTvName = (TextView) getView(R.id.tv_name);
        TextView mTvInfo = (TextView) getView(R.id.tv_info);
        ImageView mIvArrow = (ImageView) getView(R.id.iv_arrow);

        mTvName.setText(model.getTextName());
        mTvInfo.setText(model.getTextInfo());
        mIvArrow.setVisibility(model.isArrowVisible() ? View.VISIBLE : View.GONE);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick(model.getItemType());
            }
        });
    }

    private void handleClick(int itemType) {
        switch (itemType) {
            case VcardItemType.SIGNATURE:
                Log.e("Magic", "handleClick: SIGNATURE");
                break;
            case VcardItemType.COMPANY:
                Log.e("Magic", "handleClick: COMPANY");
                break;
            case VcardItemType.DEPARTMENT:
                Log.e("Magic", "handleClick: DEPARTMENT");
                break;
            case VcardItemType.DUTIES:
                Log.e("Magic", "handleClick: DUTIES");
                break;
            case VcardItemType.CELLPHONE:
                Log.e("Magic", "handleClick: CELLPHONE");
                break;
            case VcardItemType.EMAIL:
                Log.e("Magic", "handleClick: EMAIL");
                break;
            case VcardItemType.PHONE:
                Log.e("Magic", "handleClick: phone");
                break;
            case VcardItemType.MYQR:
                Log.e("Magic", "handleClick: MYQR");
                break;
            default:
                break;
        }
    }
}
