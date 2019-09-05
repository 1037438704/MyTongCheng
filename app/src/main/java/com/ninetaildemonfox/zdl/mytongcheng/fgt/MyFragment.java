package com.ninetaildemonfox.zdl.mytongcheng.fgt;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.aty.PersonalActivity;
import com.ninetaildemonfox.zdl.mytongcheng.aty.WalletActivity;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author NineTailDemonFox
 * @date 2019/9/2 10:52
 * 功能描述： 我的界面
 * 联系方式：1037438704@qq.com
 */
public class MyFragment extends BaseFragment {
    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_my_moeny)
    TextView textMyMoeny;
    @BindView(R.id.image_question)
    ImageView imageQuestion;
    @BindView(R.id.image_head)
    ImageView imageHead;
    @BindView(R.id.text_forum)
    TextView text_forum;


    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_my;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        textCenter.setVisibility(View.GONE);
        imageQuestion.setVisibility(View.VISIBLE);
        imageQuestion.setImageResource(R.mipmap.icon_my_install);
    }

    @OnClick({R.id.image_head, R.id.text_my_moeny, R.id.text_forum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_head:
                start(fgtContext, PersonalActivity.class);
                break;
            case R.id.text_my_moeny:
                //钱包
                start(fgtContext, WalletActivity.class);
                break;
            case R.id.text_forum:
                //论坛界面
//                start(fgtContext, WalletActivity.class);
                break;
            default:
        }
    }
}
