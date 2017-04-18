package com.u8.sdk;

/**
 * Created by paili on 17/4/18.
 */
public class FacebookSDK {

    private static FacebookSDK instance;

    private String appID;

    private FacebookSDK(){

    }

    public static FacebookSDK getInstance(){
        if(instance == null){
            instance = new FacebookSDK();
        }
        return instance;
    }


    public void initSDK(SDKParams params){
        this.parseSDKParams(params);
        this.initSDK();
    }

    private void initSDK(){
        //TODO::这里调用AAA的SDK初始化方法
    }

    private void parseSDKParams(SDKParams params){

        this.appID = params.getString("FACEBOOK_APPID");
    }

    public void login(){
        //TODO::这里调用AAA的登录方法
    }

    public void switchLogin(){
        //TODO::这里调用AAA切换帐号的方法
        //如果没有提供切换帐号的方法，那么切换帐号的逻辑就是[先登出，再登录]，也就是先调用logout，再调用login
    }

    public void logout(){
        //TODO::调用AAA的登出方法
    }

    public void showUserCenter(){
        //TODO::调用AAA显示个人中心的方法
        //如果AAA没有提供对应的接口，则不用实现该方法
    }

    public void exit(){
        //TODO::调用AAA显示退出确认框接口
        //如果AAA没有提供对应的接口，则不用实现该方法
    }

    public void submitGameData(UserExtraData data){
        //TODO::调用AAA上报玩家数据接口
        //如果AAA没有提供对应的接口，则不用实现该方法
    }

    public void pay(PayParams data){
        //TODO::调用AAA充值接口
    }
}
