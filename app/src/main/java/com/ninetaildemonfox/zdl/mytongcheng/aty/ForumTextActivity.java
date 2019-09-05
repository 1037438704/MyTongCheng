package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.ForumAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/3 13:09
 * 功能描述： 论坛正文
 * 联系方式：1037438704@qq.com
 */
public class ForumTextActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ForumAdp forumAdp;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_forum_text;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        textCenter.setText("论坛正文");
        imageleftFinish.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        forumAdp = new ForumAdp(R.layout.item_forum_list_adp);
        forumAdp.setForumcount(2);
        recyclerView.setAdapter(forumAdp);
        forumAdp.setNewData(list);
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
