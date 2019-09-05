package com.ninetaildemonfox.zdl.mytongcheng.entity;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/2
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class CustomViewsInfo extends SimpleBannerInfo {
    private String info;

    public CustomViewsInfo(String info) {
        this.info = info;
    }
    @Override
    public String getXBannerUrl() {
        return info;
    }
}
