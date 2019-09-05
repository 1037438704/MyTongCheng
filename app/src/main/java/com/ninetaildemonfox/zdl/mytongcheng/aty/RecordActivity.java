package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.RecordAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;

import butterknife.BindView;

/**
 * @author NineTailDemonFox
 * @date 2019/9/4 17:36
 * 功能描述： 战绩
 * 联系方式：1037438704@qq.com
 */
public class RecordActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private RecordAdp recordAdp;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_record;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        textCenter.setText("战绩");
        imageleftFinish.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        recordAdp = new RecordAdp(R.layout.item_record_list_adp);
        recyclerView.setAdapter(recordAdp);
        recordAdp.setNewData(list);
        recordAdp.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        bundle.putInt("documentart", 2);
        start(me, bundle, DocumentaryInformationActivity.class);
    }
}
