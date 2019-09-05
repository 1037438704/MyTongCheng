package com.ninetaildemonfox.zdl.mytongcheng.fgt;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.LotteryAdp;
import com.ninetaildemonfox.zdl.mytongcheng.aty.DetailsAwardActivity;
import com.ninetaildemonfox.zdl.mytongcheng.aty.DetailsOfCompetitionActivity;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/2 10:53
 * 功能描述： 开奖界面
 * 联系方式：1037438704@qq.com
 */
public class LotteryFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_mall_ash)
    TextView text_mall_ash;
    @BindView(R.id.recycelrView)
    RecyclerView recycelrView;
    @BindView(R.id.ll_gone)
    LinearLayout ll_gone;
    @BindView(R.id.text_convertibility)
    TextView text_convertibility;
    @BindView(R.id.text_finish)
    TextView text_finish;
    @BindView(R.id.text_immediate)
    TextView text_immediate;
    private LotteryAdp lotteryAdp;
    private int abloon = 1;
    private int kaijiang = 1;
    private Drawable drawable;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_lottery;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        textCenter.setText("开奖");
        recycelrView.setLayoutManager(new LinearLayoutManager(fgtContext));
        lotteryAdp = new LotteryAdp(R.layout.item_lottery_list_adp);
        recycelrView.setAdapter(lotteryAdp);
        lotteryAdp.setNewData(list);
        lotteryAdp.setOnItemChildClickListener(this);
        xuanze();

    }

    private void xuanze() {
        if (kaijiang == 1) {
            text_mall_ash.setTextColor(fgtContext.getResources().getColor(R.color.colorAccent));
            text_convertibility.setTextColor(fgtContext.getResources().getColor(R.color.text_gray_666666));
        } else {
            text_mall_ash.setTextColor(fgtContext.getResources().getColor(R.color.text_gray_666666));
            text_convertibility.setTextColor(fgtContext.getResources().getColor(R.color.colorAccent));
        }
    }

    @OnClick({R.id.text_mall_ash, R.id.text_convertibility, R.id.ll_gone, R.id.text_immediate, R.id.text_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_mall_ash:
                if (kaijiang == 1) {
                    if (abloon == 1) {
                        drawable = fgtContext.getResources().getDrawable(R.mipmap.icon_award_up);
                        ll_gone.setVisibility(View.VISIBLE);
                        abloon = 2;
                    } else {
                        drawable = fgtContext.getResources().getDrawable(R.mipmap.icon_award_down);
                        ll_gone.setVisibility(View.GONE);
                        abloon = 1;
                    }
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    text_mall_ash.setCompoundDrawables(null, null, drawable, null);
                }
                text_mall_ash.setTextColor(fgtContext.getResources().getColor(R.color.colorAccent));
                text_convertibility.setTextColor(fgtContext.getResources().getColor(R.color.text_gray_666666));
                kaijiang = 1;
                lotteryAdp = new LotteryAdp(R.layout.item_lottery_list_adp);
                recycelrView.setAdapter(lotteryAdp);
                lotteryAdp.setNewData(list);
                lotteryAdp.setOnItemChildClickListener(this);
                break;
            case R.id.text_convertibility:
                //即时
                ll_gone.setVisibility(View.GONE);
                abloon = 1;
                text_mall_ash.setTextColor(fgtContext.getResources().getColor(R.color.text_gray_666666));
                text_convertibility.setTextColor(fgtContext.getResources().getColor(R.color.colorAccent));
                kaijiang = 2;
                lotteryAdp = new LotteryAdp(R.layout.item_immediate_list_adp);
                recycelrView.setAdapter(lotteryAdp);
                lotteryAdp.setNewData(list);
                lotteryAdp.setOnItemChildClickListener(this);
                break;
            case R.id.text_finish:
                text_mall_ash.setText("完场");
                drawable = fgtContext.getResources().getDrawable(R.mipmap.icon_award_down);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                text_mall_ash.setCompoundDrawables(null, null, drawable, null);
                ll_gone.setVisibility(View.GONE);
                abloon = 1;
                break;
            case R.id.text_immediate:
                text_mall_ash.setText("即时");
                drawable = fgtContext.getResources().getDrawable(R.mipmap.icon_award_down);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                text_mall_ash.setCompoundDrawables(null, null, drawable, null);
                ll_gone.setVisibility(View.GONE);
                abloon = 1;
                break;
            case R.id.ll_gone:
                ll_gone.setVisibility(View.GONE);
                abloon = 1;
                break;
            default:
        }
    }

    public static LotteryFragment newInstance() {
        return new LotteryFragment();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.text_analysis:
                if (kaijiang == 1) {
                    start(fgtContext, DetailsOfCompetitionActivity.class);
                } else {
                    start(fgtContext, DetailsAwardActivity.class);
                }
                break;
            default:
        }
    }
}