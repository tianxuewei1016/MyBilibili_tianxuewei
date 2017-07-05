package com.mybilibili_tianxuewei.common;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * 作者：田学伟 on 2017/7/3 19:33
 * QQ：93226539
 * 作用：
 */

public class MyApplication extends Application {

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger打日志工具
        Logger.addLogAdapter(new AndroidLogAdapter());

        //初始化LeakCanary内存泄露检测工具
        initLeak();

        //初始化crashHandler,当上线的时候开启,当出现bug的时候退出软件
//        CrashHandler.getInstance().init(this);
    }

    private void initLeak() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        } else {
            refWatcher = LeakCanary.install(this);
        }
    }
}

