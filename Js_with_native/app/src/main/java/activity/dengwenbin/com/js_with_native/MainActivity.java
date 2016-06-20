package activity.dengwenbin.com.js_with_native;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 40284 on 2016/6/18.
 */
public class MainActivity extends AppCompatActivity{

    private WebView webView;
    private OkHttpClient client;
    private String str="";
    private String s="";
    private String link = "https://api.github.com/repos/square/okhttp/issues/2635";
    private Call call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.mainwebview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.addJavascriptInterface(new JsInterfaceMain(),"JsInterfaceMain");
        webView.setWebChromeClient(new WebChromeClient() {
        });
        webView.loadUrl("file:///android_asset/main.html");
    }

    public class JsInterfaceMain{
        @JavascriptInterface
        public void toSettingActivity(){
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
        }

        @JavascriptInterface
        public void callApi() throws IOException {
            getAPI();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        getAPI();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//            webView.post(new Runnable() {
//                @Override
//                public void run() {
//                    if(s.equals("")){
//                        try {
//                            Log.e("State","Main进入");
//                            Thread.sleep(2000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }else if (!s.equals("")) {
//                            webView.loadUrl("javascript:setLink(\'" + link + "\')");
//                            webView.loadUrl("javascript:setContent(\'" + s + "\')");
//                        }
//                }
//            });
        }
    }

    public void getAPI() throws IOException {
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/square/okhttp/issues/2635")
                .addHeader("Accept", "application/json; q=0.5")
                .build();
//        Response response = client.newCall(request).execute();
        call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                str = response.body().string();
                System.out.println(str);
                String str1 ="'";
                Pattern pattern = Pattern.compile(str1);
                Matcher matcher = pattern.matcher(str);
                s= matcher.replaceAll("l");
                sendPost();
            }
        });
//        str = response.body().string();
//        System.out.println(str);
//        String str1 ="'";
//        Pattern pattern = Pattern.compile(str1);
//        Matcher matcher = pattern.matcher(str);
//        s= matcher.replaceAll("l");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Application.activityState = true;
        if(!Tools.isBackstage(this)) {
            if (!Application.state) {
                Tools.showDialog(this, "开始工作");
                Application.state = true;
            } else if (Application.screenState == false && Application.count >= 0) {
                Tools.showDialog(this, "欢迎归来");
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

    public void sendPost(){
        webView.post(new Runnable() {
            @Override
            public void run() {
                if(s.equals("")){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if (!s.equals("")) {
                    webView.loadUrl("javascript:setLink(\'" + link + "\')");
                    webView.loadUrl("javascript:setContent(\'" + s + "\')");
                }
            }
        });
    }

}
