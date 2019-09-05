package com.ninetaildemonfox.zdl.mytongcheng.fgt.recommend;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.DocumentaryAdp;
import com.ninetaildemonfox.zdl.mytongcheng.aty.DocumentaryInformationActivity;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 首页推荐 - 》跟单界面
 */
public class DocumentaryFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private DocumentaryAdp documentaryAdp;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_documentary;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(fgtContext));
        documentaryAdp = new DocumentaryAdp(R.layout.item_documentary_list_adp);
        recyclerView.setAdapter(documentaryAdp);
        documentaryAdp.setNewData(list);
        documentaryAdp.setOnItemChildClickListener(this);

    }

    public static DocumentaryFragment newInstance() {
        return new DocumentaryFragment();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.text_comment:
                bundle.putInt("documentart",1);
                start(fgtContext, bundle,DocumentaryInformationActivity.class);
                break;
            default:
        }
    }
}
