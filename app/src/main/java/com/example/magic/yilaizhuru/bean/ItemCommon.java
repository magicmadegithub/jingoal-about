package com.example.magic.yilaizhuru.bean;

import com.example.magic.yilaizhuru.type.VcardTypeFactory;

/**
 * Created by magic on 17-1-20.
 */

public class ItemCommon implements ViewItem {

    //名称
    private String textName;
    //详情
    private String textInfo;
    //详情颜色
    private int infoColor;
    //右三角是否可见
    private boolean arrowVisible;
    //整个条目是否可点击
    private boolean itemClick;
    //详情是否可点击
    private boolean infoClick;
    //条目的类型
    private int itemType;

    @Override
    public int type(VcardTypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }

    public boolean isArrowVisible() {
        return arrowVisible;
    }

    public void setArrowVisible(boolean arrowVisible) {
        this.arrowVisible = arrowVisible;
    }

    public int getInfoColor() {
        return infoColor;
    }

    public void setInfoColor(int infoColor) {
        this.infoColor = infoColor;
    }

    public boolean isItemClick() {
        return itemClick;
    }

    public void setItemClick(boolean itemClick) {
        this.itemClick = itemClick;
    }

    public boolean isInfoClick() {
        return infoClick;
    }

    public void setInfoClick(boolean infoClick) {
        this.infoClick = infoClick;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
