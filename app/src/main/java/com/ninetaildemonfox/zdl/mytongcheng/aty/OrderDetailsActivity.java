package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/4 17:09
 * 功能描述： 订单详情
 * 联系方式：1037438704@qq.com
 */

public class OrderDetailsActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_order_details;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        textCenter.setText("订单详情");
        imageleftFinish.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.image_left_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            default:
        }
    }

}
