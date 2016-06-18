package activity.dengwenbin.com.js_with_native;

import android.content.Context;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by 40284 on 2016/6/18.
 */
public class Application extends android.app.Application {

    Context context;
    static Boolean screenState = true;
    static int count=0;
    static Boolean activityState= true;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        ScreenListener l = new ScreenListener(this);
        l.begin(new ScreenListener.ScreenStateListener() {

            @Override
            public void onUserPresent() {
                Log.e("State", "解锁");

                screenState=true;
                count = count+1;
                Log.e("State",""+count + "   "+ ""+ screenState);
                if(activityState==false){
                    Log.e("State","我知道但不吭声");
                }
            }

            @Override
            public void onScreenOn() {
                Log.e("State", "开屏");
            }

            @Override
            public void onScreenOff() {
                Log.e("State", "锁屏");
                screenState=false;
            }
        });
    }
}
