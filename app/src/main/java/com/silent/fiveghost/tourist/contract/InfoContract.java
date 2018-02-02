package com.silent.fiveghost.tourist.contract;

import android.net.Uri;

import com.silent.fiveghost.tourist.http.HttpCallback;

import java.io.File;
import java.util.List;
import java.util.Map;


/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */

public interface InfoContract {
    interface Model {
        void httpRequest(String url,HttpCallback callback);
        void httpRequest(String url, Map<String,String> map, HttpCallback callBack);
        void uploadFile(Uri fileUri, HttpCallback callback);
        void upLoadFiles(List<File> mFiles, HttpCallback callback);

    }

    interface View<T> extends HttpCallback<T> {

    }
    interface Presenter {
        void getData(String url);
        void getData(String url,Map<String,String> map);
        void upFile(Uri fileUri);
        void upFiles(List<File> mFiles);
    }
}
