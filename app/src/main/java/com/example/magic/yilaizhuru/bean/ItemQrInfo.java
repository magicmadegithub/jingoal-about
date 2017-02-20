package com.example.magic.yilaizhuru.bean;

import com.example.magic.yilaizhuru.type.VcardTypeFactory;

/**
 * Created by magic on 17-1-20.
 */

public class ItemQrInfo implements ViewItem {

    private String textInfo;

    @Override
    public int type(VcardTypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }
}
