package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.ColorAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/4 11:11
 * 功能描述： 推荐详情
 * 联系方式：1037438704@qq.com
 */
public class RecommendationDetailsActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_strand)
    TextView text_strand;
    @BindView(R.id.text_comment)
    TextView textComment;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.text_pay)
    TextView text_pay;
    @BindView(R.id.ll_gone_one)
    LinearLayout ll_gone_one;
    @BindView(R.id.ll_gone_two)
    LinearLayout ll_gone_two;
    private int count = 0;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_recommendation_details;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        count = getIntent().getExtras().getInt("count");
        if (count == 1) {
            ll_gone_two.setVisibility(View.VISIBLE);
            ll_gone_one.setVisibility(View.GONE);
        }

        imageleftFinish.setVisibility(View.VISIBLE);
        text_strand.setVisibility(View.GONE);
        textCenter.setText("支付成功");
        textComment.setText("命中率100%");
        recyclerView.setLayoutManager(new LinearLayoutManager(me, LinearLayoutManager.HORIZONTAL, false));
        ColorAdp colorAdp = new ColorAdp(R.layout.item_color_list_adp);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("");
        }
        recyclerView.setAdapter(colorAdp);
        colorAdp.setNewData(list);

    }

    @OnClick({R.id.image_left_finish, R.id.text_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.text_pay:
                bundle.putInt("success",1);
                start(me,bundle ,SuccessPayActivity.class);
                break;
            default:
        }
    }
}
