package com.ninetaildemonfox.zdl.mytongcheng.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.jaeger.library.StatusBarUtil;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.AppManager;
import com.ninetaildemonfox.zdl.mytongcheng.utlis.Preferences;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/8/23
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public abstract class BaseActivity extends AppCompatActivity {
    public String token;
    public View viewError;
    public AppCompatActivity me;
    public List<String> list;
    public Bundle bundle;
    /**
     * 当前页码
     */
    protected int currentpage = 1;
    private int REQUEST_CODE_PERMISSION = 0x00099;
    /**
     * 页面数据量
     */
    protected int pageSize = 1;

    protected abstract int getLayoutResource();

    protected abstract void onInitialization(Bundle bundle);

    //    protected SwipeBackHelper mSwipeBackHelper;
    //权限申请回调
    private OnPermissionResponseListener onPermissionResponseListener;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        me = this;
        token = Preferences.getInstance().getString(me, "user", "token");
        viewError = getLayoutInflater().inflate(R.layout.view_error, null);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        bundle = new Bundle();
        AppManager.getInstance().pushActivity(me);
        setStatusBar();
        if (getLayoutResource() != 0) {
            setContentView(getLayoutResource());
            bind = ButterKnife.bind(this);
        }
        //控制是否滑动删除
        onInitialization(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        AppManager.getInstance().deleteActivity(me);
    }

    public void finishActivity() {
        super.finish();
    }

    public int setToolBar(Toolbar toolbar, boolean isChangeToolbar, boolean isChangeStatusBar, DrawerLayout drawerLayout) {
        int vibrantColor = Color.TRANSPARENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.BLACK);
        }
        if (isChangeToolbar) {
            toolbar.setBackgroundColor(vibrantColor);
        }
        if (isChangeStatusBar) {
            StatusBarUtil.setColor(this, vibrantColor);
        }
        if (drawerLayout != null) {
            StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, vibrantColor);
        }
        return vibrantColor;
    }

    //获取状态栏的高度
    public int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        try {
            return getResources().getDimensionPixelSize(resourceId);
        } catch (Resources.NotFoundException e) {
            return 0;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }


    public static void ShowToast(Context me, String msg) {
        Toast toast = Toast.makeText(me, msg, Toast.LENGTH_LONG);
        toast.setText(msg);
        toast.show();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
    }

    /**
     * 确认所有的权限是否都已授权
     *
     * @param grantResults
     * @return
     */
    private boolean verifyPermissions(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 请求权限
     * <p>
     * 警告：此处除了用户拒绝外，唯一可能出现无法获取权限或失败的情况是在AndroidManifest.xml中未声明权限信息
     * Android6.0+即便需要动态请求权限（重点）但不代表着不需要在AndroidManifest.xml中进行声明。
     *
     * @param permissions                  请求的权限
     * @param onPermissionResponseListener 回调监听器
     */
    public void requestPermission(OnPermissionResponseListener onPermissionResponseListener, String... permissions) {
        this.onPermissionResponseListener = onPermissionResponseListener;
        if (checkPermissions(permissions)) {
            if (onPermissionResponseListener != null) {
                onPermissionResponseListener.onSuccess(permissions);
            }
        } else {
            List<String> needPermissions = getDeniedPermissions(permissions);
            ActivityCompat.requestPermissions(this, needPermissions.toArray(new String[needPermissions.size()]), REQUEST_CODE_PERMISSION);
        }
    }

    public interface OnPermissionResponseListener {
        void onSuccess(String[] permissions);

        void onFail();
    }

    /**
     * 检测所有的权限是否都已授权
     *
     * @param permissions
     * @return
     */
    public boolean checkPermissions(String... permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     */
    private List<String> getDeniedPermissions(String... permissions) {
        List<String> needRequestPermissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) !=
                    PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                needRequestPermissionList.add(permission);
            }
        }
        return needRequestPermissionList;
    }

    /**
     * 启动当前应用设置页面
     */
    public void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    public void start(AppCompatActivity mContext, Bundle bundle, Class up) {
        Intent intent = new Intent(mContext, up);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void start(AppCompatActivity mContext, Class up) {
        mContext.startActivity(new Intent(mContext, up));
    }

    public void start(AppCompatActivity mContext, Class up, int tag) {
        mContext.startActivityForResult(new Intent(mContext, up), tag);
    }

    public void start(AppCompatActivity mContext, Bundle bundle, Class up, int tag) {
        Intent intent = new Intent(mContext, up);
        intent.putExtras(bundle);
        mContext.startActivityForResult(intent, tag);
    }

    public void whitchBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.whileColor), 0);
        StatusBarUtil.setLightMode(me);
    }
}
