package com.cms.zup.escolacms;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

    /**
     * Created by ZUP on 04/07/2017.
     */

    public class MyApplication extends Application {
        private static MyApplication myInstance;
        private static RequestQueue myRequestQueue;
        private static String TAG = "DEFAULT";
        private ImageLoader imageLoader;

        @Override
        public void onCreate() {
            super.onCreate();
        }
    }

