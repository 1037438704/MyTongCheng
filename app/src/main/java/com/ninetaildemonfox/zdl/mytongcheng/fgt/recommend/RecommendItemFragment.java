package com.ninetaildemonfox.zdl.mytongcheng.fgt.recommend;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.RecommendItemAdp;
import com.ninetaildemonfox.zdl.mytongcheng.aty.RecommendationDetailsActivity;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;

import butterknife.BindView;

/**
 * @author NineTailDemonFox
 * @date 2019/9/4 10:39
 * 功能描述：推荐中的推荐界面
 * 联系方式：1037438704@qq.com
 */
public class RecommendItemFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private RecommendItemAdp recommendItemAdp;

    public static RecommendItemFragment newInstance() {
        return new RecommendItemFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_recommend_item;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(fgtContext));
        recommendItemAdp = new RecommendItemAdp(R.layout.item_recdommend_list_adp);
        recyclerView.setAdapter(recommendItemAdp);
        recommendItemAdp.setNewData(list);
        recommendItemAdp.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.text_comment:
                bundle.putInt("count", 0);
                start(fgtContext, bundle, RecommendationDetailsActivity.class);
                break;
            default:
        }
    }

}
