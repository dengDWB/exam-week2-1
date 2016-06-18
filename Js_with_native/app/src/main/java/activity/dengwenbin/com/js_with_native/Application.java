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
    static Boolean state = true;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        context = this;
        ScreenListener l = new ScreenListener(this);
        l.begin(new ScreenListener.ScreenStateListener() {

            @Override
            public void onUserPresent() {

                screenState=true;
                count = count+1;
                if(activityState==false){
                    Log.e("State","我知道但不吭声");
                }
            }

            @Override
            public void onScreenOn() {
            }

            @Override
            public void onScreenOff() {
                screenState=false;
            }
        });
    }
}
