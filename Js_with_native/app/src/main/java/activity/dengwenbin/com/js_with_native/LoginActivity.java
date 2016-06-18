package activity.dengwenbin.com.js_with_native;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by 40284 on 2016/6/18.
 */
public class LoginActivity extends AppCompatActivity {

    private Boolean state = true;
    static Boolean activityState = true;
    private WebView webView;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i("State", "1");
        webView = (WebView) findViewById(R.id.loginwebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JsInterfaceLogin(),"JsInterfaceLogin");
        webView.setWebChromeClient(new WebChromeClient() {
        });
        webView.loadUrl("file:///android_asset/login.html");
    }

    public class JsInterfaceLogin{
        @JavascriptInterface
        public void toMainActivity(){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("State", "2");
        Application.activityState = true;
        Log.i("State",""+Application.count + "   "+ ""+ Application.screenState);
        if(!Tools.isBackstage(this)){
            Log.i("State", "开始工作");
            if(!state) {
                Tools.showDialog(this, "开始工作");
                state = true;
            }else if(Application.screenState==false && Application.count>=0){
                Tools.showDialog(this,"欢迎归来");
            }


        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("State", "5");
        Application.activityState = false;
        if(Tools.isBackstage(this)) {
            Log.i("State", "我休息一下");
            state = false;
        }
    }


}
