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
 * @date 2019/9/3 14:23
 * 功能描述： 发布内容
 * 联系方式：1037438704@qq.com
 */
public class PublishContentActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_release)
    TextView text_release;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_publish_content;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        imageleftFinish.setVisibility(View.VISIBLE);
        textCenter.setText("发布内容");

    }

    @OnClick({R.id.image_left_finish, R.id.text_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.text_release:
                finish();
                break;
            default:
        }
    }

}
