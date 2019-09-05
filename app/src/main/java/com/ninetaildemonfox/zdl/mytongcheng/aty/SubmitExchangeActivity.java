package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import butterknife.BindView;

/**
 * @author NineTailDemonFox
 * @date 2019/9/2 15:11
 * 功能描述： 提交兑换
 * 联系方式：1037438704@qq.com
 */

public class SubmitExchangeActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_submit_exchange;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        imageleftFinish.setVisibility(View.VISIBLE);
        textCenter.setText("提交兑换");

    }
}