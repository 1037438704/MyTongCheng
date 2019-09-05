package com.ninetaildemonfox.zdl.mytongcheng.fgt;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.MainFragmentPageAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.adp.ScreenAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;
import com.ninetaildemonfox.zdl.mytongcheng.fgt.recommend.DocumentaryFragment;
import com.ninetaildemonfox.zdl.mytongcheng.fgt.recommend.RecommendItemFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/2 10:44
 * 功能描述：推荐界面
 * 联系方式：1037438704@qq.com
 */
public class RecommendFragment extends BaseFragment {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.article_viewpager)
    ViewPager viewPager;
    @BindView(R.id.text_screen)
    TextView textScreen;
    @BindView(R.id.ll_gone_one)
    LinearLayout llGoneOne;
    @BindView(R.id.recyclerVIewCondition)
    RecyclerView recyclerVIewCondition;
    @BindView(R.id.recyclerVIewTyep)
    RecyclerView recyclerVIewTyep;
    private List<Fragment> list;
    private String[] TITLE = {"跟单", "推荐"};
    private int screen = 1;
    private ScreenAdp screenAdp;
    private List<String> screenList;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        initView();
        initData();
    }

    private void initData() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                screen = 1;
                llGoneOne.setVisibility(View.GONE);
                if (i == 0) {
                    textScreen.setText("筛选");
                } else {
                    textScreen.setText("我的推荐");
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initView() {
        screenList = new ArrayList<>();
        recyclerVIewTyep.setLayoutManager(new GridLayoutManager(fgtContext, 4));
        recyclerVIewCondition.setLayoutManager(new GridLayoutManager(fgtContext, 4));
        screenAdp = new ScreenAdp(R.layout.item_screen_list_adp);
        recyclerVIewCondition.setAdapter(screenAdp);
        recyclerVIewTyep.setAdapter(screenAdp);
        for (int i = 0; i < 4; i++) {
            screenList.add("");
        }
        screenAdp.setNewData(screenList);
        list = new ArrayList<>();
        list.add(DocumentaryFragment.newInstance());
        list.add(RecommendItemFragment.newInstance());

        MainFragmentPageAdapter pagerFragmentAdapter = new MainFragmentPageAdapter(getChildFragmentManager(), list, TITLE);
        viewPager.setAdapter(pagerFragmentAdapter);
        viewPager.setOffscreenPageLimit(list.size());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick({R.id.text_screen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_screen:
                if (textScreen.getText().toString().equals("筛选")) {
                    if (screen == 1) {
                        screen = 2;
                        llGoneOne.setVisibility(View.VISIBLE);
                    } else {
                        screen = 1;
                        llGoneOne.setVisibility(View.GONE);
                    }
                } else {
                    if (screen == 1) {
                        screen = 2;
                        llGoneOne.setVisibility(View.VISIBLE);
                    } else {
                        screen = 1;
                        llGoneOne.setVisibility(View.GONE);
                    }
                }
                break;
            default:
        }
    }

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

}
