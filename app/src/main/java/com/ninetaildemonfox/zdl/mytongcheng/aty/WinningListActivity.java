package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.WinningListAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author NineTailDemonFox
 * @date 2019/9/3 10:49
 * 功能描述： 中奖名单
 * 联系方式：1037438704@qq.com
 */
public class WinningListActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private WinningListAdp winningListAdp;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_winning_list;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        textCenter.setText("中奖名单");
        imageleftFinish.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        winningListAdp = new WinningListAdp(R.layout.item_winning_list_adp);
        recyclerView.setAdapter(winningListAdp);
        winningListAdp.setNewData(list);
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
