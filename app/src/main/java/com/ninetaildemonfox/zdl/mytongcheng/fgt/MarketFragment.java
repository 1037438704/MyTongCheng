package com.ninetaildemonfox.zdl.mytongcheng.fgt;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.MarketAdp;
import com.ninetaildemonfox.zdl.mytongcheng.aty.ShoppingMallDetailsActivity;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;

import butterknife.BindView;

/**
 * @author NineTailDemonFox
 * @date 2019/9/2 10:52
 * 功能描述： 商场
 * 联系方式：1037438704@qq.com
 */
public class MarketFragment extends BaseFragment {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_mall_ash)
    TextView textMallAsh;
    @BindView(R.id.text_convertibility)
    TextView textConvertibility;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MarketAdp marketAdp;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_market;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        textCenter.setText("积分商场");
        recyclerView.setLayoutManager(new GridLayoutManager(fgtContext, 2));
        marketAdp = new MarketAdp(R.layout.item_market_adp);
        recyclerView.setAdapter(marketAdp);
        marketAdp.setNewData(list);
        marketAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                start(fgtContext,ShoppingMallDetailsActivity.class);
            }
        });
    }

    public static MarketFragment newInstance() {
        return new MarketFragment();
    }
}