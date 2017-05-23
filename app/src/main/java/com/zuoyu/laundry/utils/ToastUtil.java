package com.zuoyu.laundry.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zuoyu.laundry.R;
import com.zuoyu.laundry.application.MyApplication;


/**
 * <pre>
 * Function：Toast工具类
 *
 * Created by JoannChen on 2017/2/6 11:46
 * QQ:411083907
 * E-mail:Q8622268@foxmail.com
 * Copyright Notice：版权所有@ChenYongZuo
 * </pre>
 */
public class ToastUtil {

    private static Toast toast;

    private static Toast toastView;

    public ToastUtil() {

    }


    /**
     * 普通的吐司
     *
     * @param str 展示的内容
     */
    public static void show_(String str) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getInstance(), "", Toast.LENGTH_SHORT);
        }

        toast.setText(str);
        toast.show();
    }


    /**
     * 带图标的吐司
     *
     * @param string 显示的文字
     * @param layout 布局,传0显示默认布局
     * @param icon   图标,传0显示默认图标
     */
    public static void show(String string, int layout, int icon) {

        Context context = MyApplication.getInstance();

        View view = LayoutInflater.from(context).inflate(layout == 0 ? R.layout.layout_toast : R.layout.layout_toast, null);

        /*
         * TODO
         * 1080*1920
         */
        RelativeLayout toastRLayout = (RelativeLayout) view.findViewById(R.id.rl_toast);
        ViewUtil.setViewSize(toastRLayout, 0, 120);

        ImageView iconImg = (ImageView) view.findViewById(R.id.iv_icon);
        iconImg.setImageResource(icon == 0 ? R.mipmap.icon_loading : icon);
        ViewUtil.setViewSize(iconImg, 60, 60);

        TextView contentText = (TextView) view.findViewById(R.id.tv_text);
        contentText.setText(string);
        ViewUtil.setTextSize(contentText, 36);
        ViewUtil.setMarginLeft(contentText, 30, ViewUtil.RELATIVELAYOUT);

        if (toastView == null) {
            toastView = new Toast(context);
        }

        toastView.setView(view);
        toastView.setGravity(Gravity.CENTER, 0, 0);
        toastView.setDuration(Toast.LENGTH_LONG);
        toastView.show();
    }


    /**
     * 网络异常
     */
    public static void showNetWorkError() {
        show("网络异常，请稍后再试！", 0, 0);
    }


    /**
     * 普通的吐司
     *
     * @param str 展示的内容
     */
    public static void show(String str) {
        show(str, 0, R.mipmap.icon_sys_error);
    }


}
