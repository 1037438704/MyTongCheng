package com.ninetaildemonfox.zdl.mytongcheng.fgt;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.HomeNameListAdp;
import com.ninetaildemonfox.zdl.mytongcheng.adp.HomeViewBottomAdp;
import com.ninetaildemonfox.zdl.mytongcheng.aty.ForumActivity;
import com.ninetaildemonfox.zdl.mytongcheng.aty.SignInActivity;
import com.ninetaildemonfox.zdl.mytongcheng.aty.WinningListActivity;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;
import com.ninetaildemonfox.zdl.mytongcheng.entity.CustomViewsInfo;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/2 9:44
 * 功能描述：首页
 * 联系方式：1037438704@qq.com
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.image_question)
    ImageView imageQuestion;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.reyclerViewBottom)
    RecyclerView reyclerViewBottom;
    @BindView(R.id.banner)
    XBanner banner;
    @BindView(R.id.text_winninglist)
    TextView textWinninglist;
    @BindView(R.id.text_forum)
    TextView textForum;
    //中奖名单
    @BindView(R.id.recycelrViewNameList)
    RecyclerView recycelrViewNameList;
    private HomeNameListAdp homeNameListAdp;
    private HomeViewBottomAdp homeViewBottomAdp;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        initView();
        initData();
    }

    private void initData() {
        List<CustomViewsInfo> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new CustomViewsInfo("http://img2.imgtn.bdimg.com/it/u=2120610136,808118452&fm=26&gp=0.jpg"));
        }
        banner.setBannerData(R.layout.layout_custom_view, data);
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageView image_banner = view.findViewById(R.id.image_banner);
                Glide.with(fgtContext).load(((CustomViewsInfo) model).getXBannerUrl()).into(image_banner);
            }
        });
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Toast.makeText(fgtContext, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
        banner.setPageTransformer(Transformer.Cube);


        homeNameListAdp.setNewData(list);
        homeViewBottomAdp.setNewData(list);
    }

    private void initView() {
        imageQuestion.setVisibility(View.VISIBLE);
        imageQuestion.setImageResource(R.mipmap.icon_home_sign);
        textCenter.setText("同城彩");
        recycelrViewNameList.setLayoutManager(new LinearLayoutManager(fgtContext));
        reyclerViewBottom.setLayoutManager(new LinearLayoutManager(fgtContext));
        homeNameListAdp = new HomeNameListAdp(R.layout.item_view_name_list);
        homeViewBottomAdp = new HomeViewBottomAdp(R.layout.item_home_view_bottom);
        recycelrViewNameList.setAdapter(homeNameListAdp);
        reyclerViewBottom.setAdapter(homeViewBottomAdp);

    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @OnClick({R.id.text_winninglist, R.id.image_question, R.id.text_forum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_winninglist:
                start(fgtContext, WinningListActivity.class);
                break;
            case R.id.image_question:
                start(fgtContext, SignInActivity.class);
                break;
            case R.id.text_forum:
                start(fgtContext, ForumActivity.class);
                break;
            default:
        }
    }
}