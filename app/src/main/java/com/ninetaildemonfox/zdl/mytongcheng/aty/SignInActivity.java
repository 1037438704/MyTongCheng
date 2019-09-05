package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import com.kongzue.baseokhttp.util.Parameter;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.DateUtils;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.ToastUtil;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.datepicker.DPCManager;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.datepicker.DPDecor;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.datepicker.DPMode;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.datepicker.DatePicker;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.map.JSONUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/2/27 10:00
 * 功能描述： 签到界面
 * 联系方式：1037438704@qq.com
 *
 * @author dell-pc
 */

public class SignInActivity extends BaseActivity {
    private int integral_days = 0;//双倍积分日
    Date dateQian = new Date();
    private DPCManager dpcManager;
    private DatePicker myDatepicker;
    private String date;//当前日期
    private TextView tv_month, tv_sign1, tv_sign2, tv_integral, tv_continuous_check_times;
    private RelativeLayout rl_sign;
    private ArrayList<String> tmpd;
    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;


    private void dateType() {
        /**
         * 添加双倍积分
         */
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, integral_days);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数  calendar .add(5,1);则表示对日期进行加一天操作
        date = calendar.getTime();
        dateQian = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-d");
        String dateString = formatter.format(date);
        tv_month.setText(Calendar.MONTH + 3 + "");
        myDatepicker.setDate(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance()
                .get(Calendar.MONTH) + 1); //设置日期
        myDatepicker.setMode(DPMode.NONE); //设置选择模式
        myDatepicker.setFestivalDisplay(false); //是否显示节日
        myDatepicker.setTodayDisplay(true); //是否高亮显示今天
        myDatepicker.setHolidayDisplay(true); //是否显示假期
        myDatepicker.setDeferredDisplay(false); //是否显示补休
        myDatepicker.setIsScroll(false); //是否允许滑动 false表示左右上下都不能滑动  单项设置上下or左右 你需要自己扩展
        myDatepicker.setIsSelChangeColor(true, getResources().getColor(R.color.colorAccent));
        //设置选择的日期字体颜色,不然有的背景颜色和默认的字体颜色不搭
        myDatepicker.setLeftTitle(Calendar.getInstance().get(Calendar.MONTH) + 1 + "月"); //左上方text
        myDatepicker.setRightTitle(false); //是否签到

        //设置预先选中日期的背景颜色
        myDatepicker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
                Bitmap bm_bg = BitmapFactory.decodeResource(getResources(), R.mipmap
                        .icon_sign_true);
                // 得到图片的宽、高
                int width_bg = bm_bg.getWidth();
                int height_bg = bm_bg.getHeight();
                canvas.drawBitmap(bm_bg, rect.centerX() - width_bg / 2, rect.centerY() +
                        height_bg, paint);
            }

        });
    }

    @OnClick({R.id.image_left_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            default:
        }
    }

    public void setEvents() {
        //返回上一页
        //签到点击事件
        myDatepicker.setOnClickSignIn(new DatePicker.OnClickSignIn() {
            @Override
            public void signIn() {

            }
        });
        //点击签到
        rl_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dailySign();
            }
        });

    }

    private void dailySign() {
//        WaitDialog.show(me,"");
        HttpRequest.POST(me, "http://looklessontwo.txunda.com/Api/Index/dailySign"
                , new Parameter()
                        .add("token", token)
                , new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
//                        WaitDialog.dismiss();
                        if (error == null) {
                            Map<String, String> map = JSONUtils.parseKeyAndValueToMap(response);
                            if (map.get("code").equals("1")) {
                                ShowToast(me, map.get("message"));
                                signPage();
                            } else {
                                ShowToast(me, map.get("message"));
                            }

                        } else {
                            ShowToast(me, "网络链接失败");
                        }
                    }
                });
    }

    private void signPage() {
        HttpRequest.POST(me, "http://looklessontwo.txunda.com/Api/Index/signPage"
                , new Parameter()
                        .add("token", token)
                , new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
//                        WaitDialog.dismiss();
                        if (error == null) {
                            Map<String, String> map = JSONUtils.parseKeyAndValueToMap(response);
                            if (map.get("code").equals("1")) {
                                Map<String, String> data = JSONUtils.parseKeyAndValueToMap(map.get("data"));
                                //判斷是否签到
                                String sign = data.get("sign");
                                if (sign.equals("0")) {
                                    rl_sign.setBackgroundResource(R.mipmap.icon_sign_true);
                                    tv_sign1.setText("今日");
                                    tv_sign2.setText("已签到");
                                } else {
                                    rl_sign.setBackgroundResource(R.mipmap.icon_sign_false);
                                    tv_sign1.setText("签到");
                                    tv_sign2.setText("+5积分");
                                }
                                tv_integral.setText(data.get("point"));
                                tv_continuous_check_times.setText(data.get("continuous"));

                                ArrayList<Map<String, String>> sign_date = JSONUtils.parseKeyAndValueToMapList(data.get("sign_date"));
                                if (sign_date == null) {
                                    return;
                                }
                                tmpd = new ArrayList<>();
                                tmpd.clear();
                                for (int i = 0; i < sign_date.size(); i++) {
                                    String date_timestamp1 = DateUtils.formatDateByTimeZone(Long.valueOf(sign_date.get(i).get("date_timestamp") + "000"), "yyyy-M-d");
                                    tmpd.add(date_timestamp1);
                                }
                                dpcManager.clearnDATE_CACHE(); //清除cache
                                dpcManager.setDecorBG(tmpd);
                                dateType();
                            } else {
                                ToastUtil.show(map.get("message"));
                            }
                        } else {
                            ToastUtil.show("网络链接出错");
                        }
                    }
                });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        initViews();
        initData();
        setEvents();
    }

    private void initData() {
        dpcManager = DPCManager.getInstance();
        dpcManager.clearnDATE_CACHE(); //清除cache
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-M-d");
        sf.format(Calendar.getInstance().getTime());
        /**
         * 添加已签到
         */
        date = sf.format(Calendar.getInstance().getTime());
        dateType();
//        signPage();
    }

    private void initViews() {
        tv_continuous_check_times = findViewById(R.id.tv_continuous_check_times);
        tv_integral = findViewById(R.id.tv_integral);
        tv_sign2 = findViewById(R.id.tv_sign2);
        tv_sign1 = findViewById(R.id.tv_sign1);
        tv_month = findViewById(R.id.tv_month);
        rl_sign = findViewById(R.id.rl_sign);
        myDatepicker = findViewById(R.id.my_datepicker);
        imageleftFinish.setVisibility(View.VISIBLE);
        textCenter.setText("签到领积分");
    }

}
