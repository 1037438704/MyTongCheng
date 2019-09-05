package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/5
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class AccountDetailsAdp extends BaseQuickAdapter<String,BaseViewHolder>{

    public AccountDetailsAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public AccountDetailsAdp(int item_account_list_adp) {
        super(item_account_list_adp);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
