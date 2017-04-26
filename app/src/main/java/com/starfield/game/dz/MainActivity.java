package com.starfield.game.dz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.freepoker.cstarpokeren.R;
import com.u8.sdk.IU8SDKListener;
import com.u8.sdk.InitResult;
import com.u8.sdk.PayResult;
import com.u8.sdk.U8SDK;
import com.u8.sdk.plugin.U8User;
import com.u8.sdk.verify.UToken;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        U8SDK.getInstance().init(this);
        U8SDK.getInstance().setSDKListener(new IU8SDKListener() {
            @Override
            public void onResult(int code, String msg) {

            }

            @Override
            public void onInitResult(InitResult result) {

            }

            @Override
            public void onLoginResult(String data) {

            }

            @Override
            public void onSwitchAccount() {

            }

            @Override
            public void onSwitchAccount(String data) {

            }

            @Override
            public void onLogout() {

            }

            @Override
            public void onAuthResult(UToken authResult) {
            }

            @Override
            public void onPayResult(PayResult result) {

            }
        });

        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sdkLogin();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        U8SDK.getInstance().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onStart(){
        U8SDK.getInstance().onStart();
        super.onStart();
    }

    public void onPause(){
        U8SDK.getInstance().onPause();
        super.onPause();
    }
    public void onResume(){
        U8SDK.getInstance().onResume();
        super.onResume();
    }
    public void onNewIntent(Intent newIntent){
        U8SDK.getInstance().onNewIntent(newIntent);
        super.onNewIntent(newIntent);
    }
    public void onStop(){
        U8SDK.getInstance().onStop();
        super.onStop();
    }
    public void onDestroy(){
        U8SDK.getInstance().onDestroy();
        super.onDestroy();
    }
    public void onRestart(){
        U8SDK.getInstance().onRestart();
        super.onRestart();
    }

    static public void sdkLogin(){
        U8User.getInstance().login();
    }

    static public void sdkLogout(){
        U8User.getInstance().logout();
    }
}
