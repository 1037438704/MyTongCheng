package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kongzue.dialog.interfaces.OnMenuItemClickListener;
import com.kongzue.dialog.v3.BottomMenu;
import com.kongzue.takephoto.TakePhotoUtil;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/5 8:52
 * 功能描述： 个人信息
 * 联系方式：1037438704@qq.com
 */
public class PersonalActivity extends BaseActivity {

    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.text_sex)
    TextView textSex;
    @BindView(R.id.text_change_password2)
    TextView text_change_password2;
    @BindView(R.id.text_change_password)
    TextView text_change_password;
    @BindView(R.id.image_head_portrait)
    ImageView imageHeadPortrait;
    @BindView(R.id.ll_phone)
    LinearLayout ll_phone;
    private File file;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_personal;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        initData();
    }

    private void initData() {
        TakePhotoUtil.getInstance(this).setReturnPhoto(new TakePhotoUtil.ReturnPhoto() {
            @Override
            public void onGetPhotos(String[] selectImagePaths) {
                file = new File(selectImagePaths[0]);
//                Logger.d(selectImagePaths[0]);
                Glide.with(me).load(selectImagePaths[0]).apply(new RequestOptions().circleCrop()).into(imageHeadPortrait);

            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    }

    @OnClick({R.id.image_left_finish, R.id.image_head_portrait
            , R.id.text_sex, R.id.text_change_password
            , R.id.text_change_password2, R.id.ll_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            case R.id.image_head_portrait:
                BottomMenu.show(this, new String[]{"拍照", "从相册里选择"}, new OnMenuItemClickListener() {
                    @Override
                    public void onClick(String text, int index) {
                        switch (index) {
                            case 0:
                                //使用相机拍摄
                                TakePhotoUtil.getInstance(me).doOpenCamera();
                                break;
                            case 1:
                                TakePhotoUtil.getInstance(me).doOpenGallery();
                                break;
                            default:
                        }
                    }
                });
                break;
            case R.id.text_sex:
                BottomMenu.show(this, new String[]{"男", "女"}, new OnMenuItemClickListener() {
                    @Override
                    public void onClick(String text, int index) {
                        switch (index) {
                            case 0:
                                textSex.setText("男");
                                break;
                            case 1:
                                textSex.setText("女");
                                break;
                            default:
                        }
                    }
                });
                break;
            case R.id.text_change_password:
                //修改密码
                bundle.putString("count", "7");
                start(me, bundle, RegisterActivity.class);
                break;
            case R.id.text_change_password2:
                //修改密码
                bundle.putString("count", "6");
                start(me, bundle, RegisterActivity.class);
                break;
            case R.id.ll_phone:
                //验证身份
                bundle.putString("count", "8");
                start(me, bundle, RegisterActivity.class);
                break;
            default:
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TakePhotoUtil.getInstance(me).onActivityResult(requestCode, resultCode, data);
    }
}