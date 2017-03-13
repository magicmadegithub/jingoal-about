package com.example.magic.yilaizhuru.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.magic.yilaizhuru.R;
import com.example.magic.yilaizhuru.adapter.VcardAdapter;
import com.example.magic.yilaizhuru.bean.ItemCommon;
import com.example.magic.yilaizhuru.bean.ItemMyQr;
import com.example.magic.yilaizhuru.bean.ItemQrInfo;
import com.example.magic.yilaizhuru.bean.ViewItem;
import com.example.magic.yilaizhuru.itemdecoration.SimpleDecoration;
import com.example.magic.yilaizhuru.util.VcardItemType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.store_house_ptr_frame)
    PtrFrameLayout ptrFrameLayout;
    @BindView(R.id.appBar)
    AppBarLayout appBarLayout;
    @BindView(R.id.toobar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollap;
    @BindView(R.id.iv_point)
    ImageView mIvPoint;

    private VcardAdapter mAdapter;
    private List<ViewItem> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ptr);
        ButterKnife.bind(this);
        initView();
        initToolBar();
        initData();
        initAdapter();
    }

    private void initView() {
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new SimpleDecoration(this));
        appBarLayout.addOnOffsetChangedListener(this);
        ptrFrameLayout.setBackgroundColor(getResources().getColor(R.color.vcard_femal_end_color));
        //1.默认经典头布局
        PtrClassicDefaultHeader defaultHeader = new PtrClassicDefaultHeader(this);
        defaultHeader.setBackgroundColor(getResources().getColor(R.color.vcard_femal_end_color));
        //给Ptr添加头布局
        ptrFrameLayout.setHeaderView(defaultHeader);
        //使头布局的状态和刷新状态同步
        ptrFrameLayout.addPtrUIHandler(defaultHeader);
        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Toast.makeText(MainActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();
                ptrFrameLayout.refreshComplete();
            }
        });
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        //添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //去掉title显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initData() {

        fillItemCommon("个性签名", "我是谁", true, VcardItemType.SIGNATURE);

        ItemMyQr itemMyQr = new ItemMyQr();
        itemMyQr.setTextName("我的二维码");
        itemMyQr.setArrowVisible(true);
        models.add(itemMyQr);

        ItemQrInfo itemQrInfo = new ItemQrInfo();
        itemQrInfo.setTextInfo("用“今目标”扫描个人二维码，将展示部门、职务、手机号等详细的个人信息。");
        models.add(itemQrInfo);

        fillItemCommon("部门", "工作部", true, VcardItemType.DEPARTMENT);
        fillItemCommon("职务", "项目经理", true, VcardItemType.DUTIES);
        fillItemCommon("手机", "15512341234", true, VcardItemType.CELLPHONE);
        fillItemCommon("Email", "12306@qq.com", false, VcardItemType.EMAIL);
        fillItemCommon("电话", "010-1234567", false, VcardItemType.PHONE);
    }

    private void initAdapter() {
        mAdapter = new VcardAdapter(models);
        mRvList.setAdapter(mAdapter);
    }

    private void fillItemCommon(String name, String info, boolean arrowVisible, int itemType) {
        ItemCommon itemCommon = new ItemCommon();
        itemCommon.setTextName(name);
        itemCommon.setTextInfo(info);
        itemCommon.setArrowVisible(arrowVisible);
        itemCommon.setItemType(itemType);
        models.add(itemCommon);
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        Log.e("Magic", "--verticalOffset--" + verticalOffset);
        if (ptrFrameLayout == null) {
            return;
        }
        if (verticalOffset == 0) {
            //展开状态
            Log.e("Magic", "--展开状态--" + verticalOffset);
            ptrFrameLayout.setEnabled(true);
            toolbar.setNavigationIcon(R.mipmap.arrowback);
            mIvPoint.setBackgroundResource(R.mipmap.ic_point);
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            //折叠状态
            Log.e("Magic", "--折叠状态--" + verticalOffset);
            ptrFrameLayout.setEnabled(false);
            toolbar.setNavigationIcon(R.mipmap.arrowback_gray);
            mIvPoint.setBackgroundResource(R.mipmap.ic_point_gray);

        } else {
            //中间状态
            Log.e("Magic", "--中间状态--" + verticalOffset);
            ptrFrameLayout.setEnabled(false);
        }
    }
}
