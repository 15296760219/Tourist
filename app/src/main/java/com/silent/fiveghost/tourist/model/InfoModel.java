package com.silent.fiveghost.tourist.model;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.silent.fiveghost.tourist.config.RetrofitApi;
import com.silent.fiveghost.tourist.contract.InfoContract;
import com.silent.fiveghost.tourist.http.HttpCallback;
import com.silent.fiveghost.tourist.http.httptoos.RetrofitTools;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */

public class InfoModel implements InfoContract.Model {

    @Override
    public void httpRequest(String url, final HttpCallback callback) {
        RetrofitApi api = RetrofitTools.getInstance().create(RetrofitApi.class);

        Observable<ResponseBody> doGet = api.doGet(url);
        doGet.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("TAG", string);

                            Gson gson = new Gson();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments=null;
                            for (int i = 0; i < genericInterfaces.length; i++) {
                                if(genericInterfaces[i] instanceof ParameterizedType){
                                    actualTypeArguments = ((ParameterizedType) genericInterfaces[i]).getActualTypeArguments();
                                }
                            }
                            Type types =  actualTypeArguments[0];
                            Object o = gson.fromJson(string, types);
                            callback.success(o);

                        } catch (IOException e) {
                            e.printStackTrace();
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void httpRequest(String url, Map<String, String> map, final HttpCallback callback) {
        RetrofitApi api = RetrofitTools.getInstance().create(RetrofitApi.class);
        Observable<ResponseBody> post = api.doPost(url, map);
        post.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            Log.e("TAG", string);
                            //TODO 注意这个地方：
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments=null;
                            for (int i = 0; i < genericInterfaces.length; i++) {
                                if(genericInterfaces[i] instanceof ParameterizedType){
                                    actualTypeArguments = ((ParameterizedType) genericInterfaces[i]).getActualTypeArguments();
                                }
                            }
                            Type types =  actualTypeArguments[0];
                            Object o = gson.fromJson(string, types);
                            callback.success(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void uploadFile(Uri fileUri, final HttpCallback callback) {
        File file = new File(String.valueOf(fileUri));

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);

        // finally, execute the request
        Call<ResponseBody> upload = RetrofitTools.getInstance().create(RetrofitApi.class).upload(description, body);
        upload.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                callback.success(new String("成功"));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.failure(t);
            }
        });

    }

    @Override
    public void upLoadFiles(List<File> mFiles, final HttpCallback callback) {
        Map<String, RequestBody> paramsMap = new HashMap<>();
        for (int i = 0; i < mFiles.size(); i++) {
            File file = mFiles.get(i);
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), mFiles.get(i));
            paramsMap.put(file.getName(), fileBody);
        }
        Observable<String> upLoad = RetrofitTools.getInstance().create(RetrofitApi.class).upLoad(paramsMap);
        upLoad.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        callback.success(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
