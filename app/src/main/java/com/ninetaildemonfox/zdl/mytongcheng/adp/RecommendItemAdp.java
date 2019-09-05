package com.ninetaildemonfox.zdl.mytongcheng.adp;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

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

public class RecommendItemAdp extends BaseQuickAdapter<String, BaseViewHolder> {

    public RecommendItemAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public RecommendItemAdp(int item_forum_list_adp) {
        super(item_forum_list_adp);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.text_comment)
                .setText(R.id.text_comment, "命中率100%")
        ;
        TextView text_strand = helper.itemView.findViewById(R.id.text_strand);
        text_strand.setVisibility(View.GONE);
    }

}
