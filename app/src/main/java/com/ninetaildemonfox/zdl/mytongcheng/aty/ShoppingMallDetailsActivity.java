package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.ShoppingMallDetailsAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/2 14:21
 * 功能描述： 积分详情
 * 联系方式：1037438704@qq.com
 */
public class ShoppingMallDetailsActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.text_translate)
    TextView textTranslate;
    private ShoppingMallDetailsAdp shoppingMallDetailsAdp;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_shopping_mall_details;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        whitchBar();
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        shoppingMallDetailsAdp = new ShoppingMallDetailsAdp(R.layout.item_view_name_list);
        recyclerView.setAdapter(shoppingMallDetailsAdp);
        shoppingMallDetailsAdp.setNewData(list);
    }


    @OnClick({R.id.text_translate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_translate:
                start(me, SubmitExchangeActivity.class);
                break;
            default:
        }
    }
}