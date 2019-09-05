package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/3 16:53
 * 功能描述： 比赛详情
 * 联系方式：1037438704@qq.com
 */

public class DetailsOfCompetitionActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_analysis)
    TextView textAnalysis;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_details_of_competition;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        imageleftFinish.setVisibility(View.VISIBLE);
        textAnalysis.setVisibility(View.GONE);
        textCenter.setText("伊斯坦堡普野社希尔VS奥林...");
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
