package com.u8.sdk.baina;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.accountkit.AccountKit;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.u8.sdk.IActivityCallback;
import com.u8.sdk.PayParams;
import com.u8.sdk.SDKParams;
import com.u8.sdk.U8Code;
import com.u8.sdk.U8SDK;
import com.u8.sdk.UserExtraData;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by paili on 17/4/20.
 */
public class FacebookSDK implements IActivityCallback {
    private CallbackManager mCallbackManager = null;

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
        FacebookSdk.sdkInitialize(U8SDK.getInstance().getContext());
        AppEventsLogger.activateApp(U8SDK.getInstance().getApplication());
        mCallbackManager = CallbackManager.Factory.create();
        AccountKit.initialize(U8SDK.getInstance().getContext(), new AccountKit.InitializeCallback() {
            @Override
            public void onInitialized() {
                U8SDK.getInstance().onResult(U8Code.CODE_INIT_SUCCESS, "");
            }
        });

        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getUserInfo(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                U8SDK.getInstance().onResult(U8Code.CODE_LOGIN_FAIL, "User");
            }

            @Override
            public void onError(FacebookException e) {
                U8SDK.getInstance().onResult(U8Code.CODE_LOGIN_FAIL, e.toString());
            }
        });
        U8SDK.getInstance().setActivityCallback(this);
    }

    private void getUserInfo(AccessToken accessToken)
    {
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                if (graphResponse == null) {
                    U8SDK.getInstance().onResult(U8Code.CODE_LOGIN_FAIL, "No response");
                    return;
                }

                JSONObject responseJsonObject = graphResponse.getJSONObject();
                if (responseJsonObject == null) {
                    U8SDK.getInstance().onResult(U8Code.CODE_LOGIN_FAIL, "Can't parse login responseJsonObject");
                    return;
                }
                U8SDK.getInstance().onLoginResult(responseJsonObject.toString());
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,cover,link,email,gender,locale,timezone,updated_time,verified");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void parseSDKParams(SDKParams params){

        this.appID = params.getString("FACEBOOK_APPID");
    }

    public void login(){
        //TODO::这里调用AAA的登录方法
        try {
            LoginManager.getInstance().logInWithReadPermissions(U8SDK.getInstance().getContext(), Arrays.asList("public_profile", "user_friends"));
        }
        catch (Exception e){
            Log.e("facebook", e.getMessage());
        }
    }

    public void switchLogin(){
        //TODO::这里调用AAA切换帐号的方法
        //如果没有提供切换帐号的方法，那么切换帐号的逻辑就是[先登出，再登录]，也就是先调用logout，再调用login
    }

    public void logout(){
        //TODO::调用AAA的登出方法
        AccountKit.logOut();
        LoginManager.getInstance().logOut();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onNewIntent(Intent newIntent) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onBackPressed() {

    }
}