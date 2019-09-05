package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.DocumentaryinforAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/4 11:02
 * 功能描述： 跟单信息
 * 联系方式：1037438704@qq.com
 */
public class DocumentaryInformationActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_comment)
    TextView textComment;
    @BindView(R.id.text_pay)
    TextView textPay;
    @BindView(R.id.btnDecrease)
    Button btnDecrease;
    @BindView(R.id.btnIncrease)
    Button btnIncrease;
    @BindView(R.id.edit_count)
    EditText edit_count;
    @BindView(R.id.text_money)
    TextView text_money;
    @BindView(R.id.text_time)
    TextView text_time;
    @BindView(R.id.text_unpaid)
    TextView text_unpaid;
    @BindView(R.id.text_yue)
    TextView text_yue;
    @BindView(R.id.recyclerVIew)
    RecyclerView recyclerVIew;
    @BindView(R.id.ll_gone_one)
    LinearLayout ll_gone_one;
    @BindView(R.id.ll_gone_two)
    LinearLayout ll_gone_two;
    private int amount = 1;
    private int money = 0;
    private int documentart;
    private DocumentaryinforAdp documentaryinforAdp;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_documentary_information;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        textCenter.setText("跟单信息");
        //1  首页推荐 - 》跟单界面   购买跟单界面
        documentart = getIntent().getExtras().getInt("documentart");
        if (documentart == 1) {
            ll_gone_one.setVisibility(View.VISIBLE);
            ll_gone_two.setVisibility(View.GONE);
        } else {
            ll_gone_one.setVisibility(View.GONE);
            ll_gone_two.setVisibility(View.VISIBLE);
        }


        textComment.setTextColor(me.getResources().getColor(R.color.colorAccent));
        textComment.setTypeface(Typeface.DEFAULT_BOLD);
        textComment.setBackgroundResource(R.color.whileColor);
        textComment.setText("跟单中");
        imageleftFinish.setVisibility(View.VISIBLE);
        textRight.setVisibility(View.VISIBLE);
        textRight.setText("跟单规则");
        text_time.setText("查看战绩 >");


        recyclerVIew.setLayoutManager(new LinearLayoutManager(me));
        documentaryinforAdp = new DocumentaryinforAdp(R.layout.item_dinformation_list_adp);
        recyclerVIew.setAdapter(documentaryinforAdp);
        documentaryinforAdp.setNewData(list);
    }

    @OnClick({R.id.image_left_finish, R.id.text_right, R.id.btnDecrease, R.id.btnIncrease, R.id.text_pay, R.id.text_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.text_right:
                finish();
                break;
            case R.id.btnDecrease:
                //减号
                if (amount == 1) {
                    return;
                }
                amount--;
                edit_count.setText(amount + "");
                break;
            case R.id.btnIncrease:
                //加号
                amount++;
                edit_count.setText(amount + "");
                break;
            case R.id.text_pay:
                //1 进储值
                if (money == 0) {
                    start(me, StoredValueActivity.class, 1);
                    money = 100;
                    return;

                }
                //2进跟单成功
                bundle.putInt("success", 3);
                start(me, bundle, SuccessPayActivity.class);
                break;
            case R.id.text_time:
                start(me, RecordActivity.class);
                break;
            default:
        }
    }

    //结果处理函数，当从secondActivity中返回时调用此函数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            money = Integer.valueOf(bundle.getString("moeny"));
            text_money.setText("￥" + money);
        }
    }
}