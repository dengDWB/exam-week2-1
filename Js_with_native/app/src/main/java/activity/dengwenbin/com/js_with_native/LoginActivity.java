package activity.dengwenbin.com.js_with_native;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by 40284 on 2016/6/18.
 */
public class LoginActivity extends AppCompatActivity {

    private WebView webView;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        webView = (WebView) findViewById(R.id.loginwebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JsInterface(),"JsInterface");
        webView.setWebChromeClient(new WebChromeClient() {
        });
        webView.loadUrl("file:///android_asset/login.html");
    }

    public class JsInterface{
        @JavascriptInterface
        public void toMainActivity(){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

    }

}
