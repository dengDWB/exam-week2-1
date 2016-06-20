package activity.dengwenbin.com.js_with_native;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by 40284 on 2016/6/18.
 */
public class SettingActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        webView = (WebView) findViewById(R.id.settingwebview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.addJavascriptInterface(new JsInterfaceSetting(),"JsInterfaceSetting");
        webView.setWebChromeClient(new WebChromeClient() {
        });
        webView.loadUrl("file:///android_asset/setting.html");
    }

    public class JsInterfaceSetting{
        @JavascriptInterface
        public void toMainActivity(){
            finish();
        }
        @JavascriptInterface
        public void toLoginActivity(){
            Intent intent1 = new Intent(SettingActivity.this,LoginActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
            finish();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Application.activityState = true;
        if(!Tools.isBackstage(this)){
            if(!Application.state){
                Tools.showDialog(this, "开始工作");
                Application.state=true;
            }else if(Application.screenState==false && Application.count>=0){
                Tools.showDialog(this,"欢迎归来");
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Application.activityState = false;
        if(Tools.isBackstage(this)){
            Log.i("State","我休息一下");
            Application.state = false;
        }
    }
}
