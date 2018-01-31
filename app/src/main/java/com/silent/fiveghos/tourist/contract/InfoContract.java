package com.silent.fiveghos.tourist.contract;

import android.content.Context;

import com.silent.fiveghos.tourist.http.HttpCallback;


/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */

public interface InfoContract {
    interface Model {
        void httpRequest(Context context, String url, HttpCallback callBack);
    }

    interface View<T> extends HttpCallback<T> {

    }
    interface Presenter {
        void getData(String url);
    }
}
