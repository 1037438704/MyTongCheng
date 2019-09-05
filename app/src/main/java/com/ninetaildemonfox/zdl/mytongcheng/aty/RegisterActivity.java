package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.MainActivity;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/3 9:47
 * 功能描述： 注册       1忘记密码           2新用户注册            3快捷登录        4 微信登录     5qq登录      6绑定手机号
 * 6修改密码   7修改密码     8  验证身份
 * 联系方式：1037438704@qq.com
 */
public class RegisterActivity extends BaseActivity {
    private String count;

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_title)
    TextView textTitle;
    //邀请码
    @BindView(R.id.edit_invitation)
    EditText editInvitation;

    @BindView(R.id.edit_phone)
    EditText editPhone;
    //验证框
    @BindView(R.id.fl_verification)
    FrameLayout flVerification;

    //密码框
    @BindView(R.id.fl_psd)
    FrameLayout flPsd;
    @BindView(R.id.text_gone)
    TextView textGone;
    @BindView(R.id.ll_gone)
    LinearLayout llGone;
    @BindView(R.id.text_login)
    TextView textLogin;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_register;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        initView();
    }

    private void initView() {
        whitchBar();
        count = getIntent().getExtras().getString("count");
//       1  忘记密码          2新用户注册           3  快捷登录      4 微信登录    5qq登录
//            6修改密码   7修改密码     8  验证身份   9修改绑定手机号
        if (count.equals("1")) {
            textTitle.setText("找回密码");
            editInvitation.setVisibility(View.GONE);
            textGone.setVisibility(View.GONE);
            llGone.setVisibility(View.GONE);
            textLogin.setText("确定");
        } else if (count.equals("2")) {

        } else if (count.equals("3")) {
            textTitle.setText("快捷登录");
            editInvitation.setVisibility(View.GONE);
            flPsd.setVisibility(View.GONE);
            textLogin.setText("登录");
        } else if (count.equals("4")) {
            textTitle.setText("绑定手机号");
            editInvitation.setVisibility(View.GONE);
            flPsd.setVisibility(View.GONE);
            textLogin.setText("立即绑定");
        } else if (count.equals("5")) {
            textTitle.setText("绑定手机号");
            editInvitation.setVisibility(View.GONE);
            flPsd.setVisibility(View.GONE);
            textLogin.setText("立即绑定");
        } else if (count.equals("6")) {
            textTitle.setText("设置密码");
            editInvitation.setVisibility(View.GONE);
            textGone.setVisibility(View.GONE);
            llGone.setVisibility(View.GONE);
            textLogin.setText("确定");
        } else if (count.equals("7")) {
            textTitle.setText("设置密码");
            editInvitation.setVisibility(View.GONE);
            textGone.setVisibility(View.GONE);
            llGone.setVisibility(View.GONE);
            textLogin.setText("确定");
        } else if (count.equals("8")) {
            textTitle.setText("验证身份");
            editInvitation.setVisibility(View.GONE);
            textGone.setVisibility(View.GONE);
            llGone.setVisibility(View.GONE);
            textLogin.setText("下一步");
        } else if (count.equals("9")) {
            textTitle.setText("修改绑定手机号");
            editInvitation.setVisibility(View.GONE);
            textGone.setVisibility(View.GONE);
            llGone.setVisibility(View.GONE);
            textLogin.setText("立即绑定");
        }
    }

    @OnClick({R.id.image_left_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.text_login:
                setEvent();
                break;
            default:
        }
    }

    private void setEvent() {
        //       1  忘记密码          2新用户注册           3  快捷登录      4 微信登录    5qq登录
//            6修改密码   7修改密码     8  验证身份   9修改绑定手机号
        if (count.equals("1")) {
            finish();
        } else if (count.equals("2")) {
            finish();
        } else if (count.equals("3")) {
            start(me, MainActivity.class);
            finish();
        } else if (count.equals("4")) {
            start(me, MainActivity.class);
            finish();
        } else if (count.equals("5")) {
            start(me, MainActivity.class);
            finish();
        } else if (count.equals("6")) {
            finish();
        } else if (count.equals("7")) {
            finish();
        } else if (count.equals("8")) {
            start(me, bundle, RegisterActivity.class);
            finish();
        } else if (count.equals("9")) {
            finish();
        }
    }

}