package com.ninetaildemonfox.zdl.mytongcheng.adp;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/4
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class ScreenAdp extends BaseQuickAdapter<String, BaseViewHolder> {


    public ScreenAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public ScreenAdp(int item_screen_list_adp) {
        super(item_screen_list_adp);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
