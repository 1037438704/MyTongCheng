package com.ninetaildemonfox.zdl.mytongcheng.adp;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ninetaildemonfox.zdl.mytongcheng.R;

import java.util.List;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/3
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class LotteryAdp extends BaseQuickAdapter<String, BaseViewHolder> {

    public LotteryAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public LotteryAdp(int item_lottery_list_adp) {
        super(item_lottery_list_adp);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.text_analysis);
    }
}
