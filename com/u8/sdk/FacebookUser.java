package com.u8.sdk;

import android.app.Activity;

import com.u8.sdk.utils.Arrays;

/**
 * Created by paili on 17/4/18.
 */
public class FacebookUser implements IUser {

    private String[] supportedMethods = {"login","switchLogin","logout","exit"};

    /**
     * 必须定义包含一个Activity参数的构造函数，否则实例化的时候，会失败
     *
     * 一般SDK初始化方法的调用也在这里调用。除非SDK要求要在Application对应的方法调用。
     * @param context
     */
    public FacebookUser(Activity context){
        FacebookSDK.getInstance().initSDK(U8SDK.getInstance().getSDKParams());
    }

    @Override
    public void login() {
        FacebookSDK.getInstance().login();
    }

    @Override
    public void loginCustom(String customData) {

    }

    @Override
    public void switchLogin() {
        FacebookSDK.getInstance().switchLogin();
    }

    @Override
    public boolean showAccountCenter() {
        return false;
    }

    @Override
    public void logout() {
        FacebookSDK.getInstance().logout();
    }

    @Override
    public void submitExtraData(UserExtraData extraData) {

    }

    @Override
    public void exit() {
        FacebookSDK.getInstance().exit();
    }

    @Override
    public void realNameRegister() {

    }

    @Override
    public void queryAntiAddiction() {

    }

    @Override
    public boolean isSupportMethod(String methodName) {
        return Arrays.contain(supportedMethods, methodName);
    }
}
