/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2016 cocos2d-x.org
Copyright (c) 2013-2016 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package org.cocos2dx.lua;

import android.content.Intent;
import android.os.Bundle;

import com.u8.sdk.IU8SDKListener;
import com.u8.sdk.InitResult;
import com.u8.sdk.PayResult;
import com.u8.sdk.U8SDK;
import com.u8.sdk.plugin.U8User;
import com.u8.sdk.verify.UToken;

import org.cocos2dx.lib.Cocos2dxActivity;


public class AppActivity extends Cocos2dxActivity {
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
