package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.AppManager;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/4 11:26
 * 功能描述：支付成功界面   1 支付成功  2储值成功  3跟单成功
 * 联系方式：1037438704@qq.com
 */

public class SuccessPayActivity extends BaseActivity {
    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.image_question)
    ImageView imageQuestion;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_context)
    TextView text_context;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_success)
    TextView textSuccess;
    private int success;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_success_pay;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        success = getIntent().getExtras().getInt("success");

//        1 支付成功  2储值成功
        if (success == 1) {
            textCenter.setText("支付成功");
        } else if (success == 2) {
            textCenter.setText("储值成功");
            text_context.setText("现在可以用余额跟单啦~");
            textSuccess.setText("去跟单");
        } else if (success == 3) {
            textCenter.setText("跟单成功");
            text_context.setText("在个人中心跟单订单里查看详情");
            textSuccess.setText("订单详情");
        }

        imageleftFinish.setVisibility(View.VISIBLE);
        imageQuestion.setVisibility(View.VISIBLE);
        imageQuestion.setImageResource(R.mipmap.icon_award_help);
    }

    @OnClick({R.id.image_left_finish, R.id.text_success, R.id.image_question})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.image_question:
                ToastUtil.show("未开通");
                break;
            case R.id.text_success:
                switch (success) {
                    case 1:
                        AppManager.getInstance().killActivity(RecommendationDetailsActivity.class);
                        bundle.putInt("count", 1);
                        start(me, bundle, RecommendationDetailsActivity.class);
                        finish();
                        break;
                    case 2:
                        finish();
                        break;
                    case 3:
                        //订单详情
                        start(me, OrderDetailsActivity.class);
                        break;
                    default:
                }
                break;
            default:
        }
    }
}
