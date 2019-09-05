package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.MainActivity;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/3 9:43
 * 功能描述：登录界面
 * 联系方式：1037438704@qq.com
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_login)
    TextView textLogin;
    @BindView(R.id.text_register)
    TextView textRegister;
    @BindView(R.id.text_forget)
    TextView textForget;
    @BindView(R.id.text_quick)
    TextView textQuick;
    @BindView(R.id.image_wx)
    ImageView imageWx;
    @BindView(R.id.image_qq)
    ImageView imageQq;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        whitchBar();
    }

    @OnClick({R.id.image_left_finish, R.id.text_login, R.id.text_register, R.id.text_forget
            , R.id.text_quick, R.id.image_wx, R.id.image_qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.text_login:
                //登录
                start(me, MainActivity.class);
                finish();
                break;
            case R.id.text_forget:
                //忘记密码  1
                bundle.putString("count","1");
                start(me, bundle,RegisterActivity.class);
                break;
            case R.id.text_register:
                //新用户注册  2
                bundle.putString("count","2");
                start(me, bundle,RegisterActivity.class);
                break;
            case R.id.text_quick:
                //快捷登录  3
                bundle.putString("count","3");
                start(me, bundle,RegisterActivity.class);
                break;
            case R.id.image_wx:
                //微信登录  4
                bundle.putString("count","4");
                start(me, bundle,RegisterActivity.class);
                break;
            case R.id.image_qq:
                //qq登录  5
                bundle.putString("count","5");
                start(me, bundle,RegisterActivity.class);
                break;
            default:
        }
    }

}