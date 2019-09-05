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
 * @date 2019/9/5 10:06
 * 功能描述： 钱包
 * 联系方式：1037438704@qq.com
 */

public class WalletActivity extends BaseActivity {
    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_stored_value)
    TextView textStoredValue;
    @BindView(R.id.image_question)
    ImageView image_question;
    @BindView(R.id.text_ledger_details)
    TextView text_ledger_details;
    @BindView(R.id.text_details_of_withdrawal)
    TextView text_details_of_withdrawal;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        imageleftFinish.setVisibility(View.VISIBLE);
        textCenter.setText("钱包");
        image_question.setImageResource(R.mipmap.icon_award_help);

    }

    @OnClick({R.id.image_left_finish, R.id.image_question, R.id.text_stored_value
            , R.id.text_ledger_details, R.id.text_details_of_withdrawal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.text_stored_value:
                //储值
                start(me, StoredValueActivity.class);
                break;
            case R.id.image_question:
                //说明

                break;
            case R.id.text_ledger_details:
                //账本明细
                bundle.putString("count", "1");
                start(me, bundle, DetailedActivity.class);
                break;
            case R.id.text_details_of_withdrawal:
                //提现明细
                bundle.putString("count", "2");
                start(me, bundle, DetailedActivity.class);
                break;
            default:
        }
    }

}
