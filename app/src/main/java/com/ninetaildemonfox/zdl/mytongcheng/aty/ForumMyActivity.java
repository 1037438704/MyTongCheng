package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.recyclerview.RecyclerViewAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/5 11:32
 * 功能描述： 我的论坛
 * 联系方式：1037438704@qq.com
 */

public class ForumMyActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_forum_my;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(this, list);
        recyclerView.setAdapter(rvAdapter);
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
