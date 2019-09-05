package com.ninetaildemonfox.zdl.mytongcheng.adp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ninetaildemonfox.zdl.mytongcheng.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/4
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class DocumentaryinforAdp extends BaseQuickAdapter<String, BaseViewHolder> {


    public DocumentaryinforAdp(int item_record_list_adp) {
        super(item_record_list_adp);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        RecyclerView recyclerView = helper.itemView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("");
        }
        ColorAdp colorAdp = new ColorAdp(R.layout.item_color_list_adp);
        recyclerView.setAdapter(colorAdp);
        colorAdp.setNewData(list);
    }

}