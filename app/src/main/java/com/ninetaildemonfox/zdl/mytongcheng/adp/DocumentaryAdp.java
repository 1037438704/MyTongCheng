package com.ninetaildemonfox.zdl.mytongcheng.adp;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ninetaildemonfox.zdl.mytongcheng.R;

import java.util.List;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/4
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class DocumentaryAdp extends BaseQuickAdapter<String, BaseViewHolder> {

    public DocumentaryAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public DocumentaryAdp(int item_documentary_list_adp) {
        super(item_documentary_list_adp);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.text_comment);
    }
}
