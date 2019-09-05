package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.ForumAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/3 11:54
 * 功能描述： 论坛中心
 * 联系方式：1037438704@qq.com
 */
public class ForumActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.image_forum)
    ImageView image_forum;
    private ForumAdp forumAdp;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_forum;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        imageleftFinish.setVisibility(View.VISIBLE);
        textCenter.setText("论坛中心");
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        forumAdp = new ForumAdp(R.layout.item_forum_list_adp);
        forumAdp.setForumcount(1);
        recyclerView.setAdapter(forumAdp);
        forumAdp.setNewData(list);
        forumAdp.setOnItemClickListener(this);
    }

    @OnClick({R.id.image_left_finish, R.id.image_forum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.image_forum:
                start(me, PublishContentActivity.class);
                break;
            default:
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        start(this, ForumTextActivity.class);
    }
}
