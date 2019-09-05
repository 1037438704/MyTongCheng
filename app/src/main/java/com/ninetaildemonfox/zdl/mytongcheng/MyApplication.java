package com.ninetaildemonfox.zdl.mytongcheng;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.kongzue.baseokhttp.util.BaseOkHttp;
import com.kongzue.dialog.util.DialogSettings;
import com.kongzue.takephoto.TakePhotoUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import static com.kongzue.dialog.util.DialogSettings.STYLE.STYLE_IOS;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/8/23
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastManager.instance.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        BaseOkHttp.DEBUGMODE = true;
        BaseOkHttp.serviceUrl = "http://shejiao.txunda.com/index.php/Api/";
        DialogSettings.isUseBlur = true;                   //是否开启模糊效果，默认关闭
        DialogSettings.style = STYLE_IOS;          //全局主题风格，提供三种可选风格，STYLE_MATERIAL, STYLE_KONGZUE,
        TakePhotoUtil.ALLOW_MULTIPLE = false;                               //是否允许多选图片
        TakePhotoUtil.COMPRESSED_PICS = true;                               //是否开启压缩
        TakePhotoUtil.DEFAULT_QUALITY = 90;                                 //压缩框架：图片质量
        TakePhotoUtil.DEFAULT_MAX_WIDTH = 1080;                             //压缩框架：图片最大宽度
        TakePhotoUtil.DEFAULT_MAX_HEIGHT = 1080;                            //压缩框架：图片最大高度
        TakePhotoUtil.DEFAULT_PIC_TYPE = Bitmap.CompressFormat.JPEG;        //压缩框架：默认压缩格式
    }

    public enum ToastManager {
        instance;
        private TextView contentTextView;
        private Toast toast;

        public void init(Context context) {
            contentTextView = (TextView) LayoutInflater.from(context).inflate(R.layout.view_toast, null);
            toast = new Toast(context);
            toast.setView(contentTextView);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }

        public void show(CharSequence charSequence, int duration) {
            if (!TextUtils.isEmpty(charSequence)) {
                contentTextView.setText(charSequence);
                toast.setDuration(duration);
                toast.show();
            }
        }
    }
}
