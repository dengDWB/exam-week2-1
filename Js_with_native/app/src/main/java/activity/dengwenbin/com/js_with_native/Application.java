package activity.dengwenbin.com.js_with_native;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by 40284 on 2016/6/18.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
