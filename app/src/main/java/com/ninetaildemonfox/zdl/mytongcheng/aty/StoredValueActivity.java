package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.PayAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import com.ninetaildemonfox.zdl.mytongcheng.entity.PayNamePayBean;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.ToastUtil;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/4 15:59
 * 功能描述： 储值
 * 联系方式：1037438704@qq.com
 */
public class StoredValueActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_recharge)
    TextView textRecharge;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.edit_money)
    EditText edit_money;
    private List<PayNamePayBean> list;
    private PayAdapter payAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_stored_value;
    }

    @Override
    protected void onInitialization(Bundle bundle) {

        imageleftFinish.setVisibility(View.VISIBLE);
        textCenter.setText("跟单信息");
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        payAdapter = new PayAdapter(R.layout.item_pay_list_adp);
        list = new ArrayList<>();
        recyclerView.setAdapter(payAdapter);
        list.add(new PayNamePayBean("微信支付", false, R.mipmap.icon_pay_weixin));
        list.add(new PayNamePayBean("支付宝支付", false, R.mipmap.icon_pay_zhifubao));
        payAdapter.setNewData(list);
        payAdapter.setOnItemClickListener(this);
    }

    @OnClick({R.id.image_left_finish, R.id.text_recharge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.text_recharge:
                if (edit_money.getText().toString().trim() == null) {
                    ToastUtil.show("充值金额不能为空");
                    return;
                }
                //充值
                bundle.putInt("success", 2);
                start(me, bundle, SuccessPayActivity.class, 1);
//                start(me, bundle, SuccessPayActivity.class);
                finish();
                break;
            default:
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        List<PayNamePayBean> data = payAdapter.getData();
        PayNamePayBean payNamePayBean = data.get(position);
        if (payNamePayBean.getChoice() == true) {
            payNamePayBean.setChoice(false);
        } else {
            for (int i = 0; i < data.size(); i++) {
                data.get(i).setChoice(false);
            }
            payNamePayBean.setChoice(true);
        }
        payAdapter.notifyDataSetChanged();
    }
}
