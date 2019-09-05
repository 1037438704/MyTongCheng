package com.ninetaildemonfox.zdl.mytongcheng.adp;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ninetaildemonfox.zdl.mytongcheng.R;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/3
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class ForumAdp extends BaseQuickAdapter<String, BaseViewHolder> {

    public int forumcount;


    public void setForumcount(int forumcount) {
        this.forumcount = forumcount;
    }

    public ForumAdp(int item_forum_list_adp) {
        super(item_forum_list_adp);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView text_snap = helper.itemView.findViewById(R.id.text_snap);
        TextView text_comment = helper.itemView.findViewById(R.id.text_comment);
        //1不隐藏 2 隐藏
        if (forumcount == 1) {
            text_snap.setVisibility(View.VISIBLE);
            text_comment.setVisibility(View.VISIBLE);
        } else {
            text_snap.setVisibility(View.GONE);
            text_comment.setVisibility(View.GONE);
        }
    }
}
