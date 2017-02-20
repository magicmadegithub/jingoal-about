package com.example.magic.yilaizhuru.bean;

import com.example.magic.yilaizhuru.type.VcardTypeFactory;

/**
 * Created by magic on 17-1-20.
 */

public class ItemMyQr extends ItemCommon implements ViewItem {

    @Override
    public int type(VcardTypeFactory typeFactory) {
        return typeFactory.type(this);
    }

}
