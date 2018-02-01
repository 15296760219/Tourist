package com.silent.fiveghos.tourist.model;

import android.content.Context;
import android.net.Uri;

import com.silent.fiveghos.tourist.contract.InfoContract;
import com.silent.fiveghos.tourist.http.HttpCallback;
import com.silent.fiveghos.tourist.http.factorys.HttpConCreate;
import com.silent.fiveghos.tourist.http.factorys.HttpFactorys;
import com.silent.fiveghos.tourist.http.products.HttpRequest;
import com.silent.fiveghos.tourist.http.products.RetrofitRequest;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */

public class InfoModel implements InfoContract.Model {
    @Override
    public void httpRequest(String url, HttpCallback callback) {
        HttpFactorys httpConCreate = new HttpConCreate();
        HttpRequest httpRequest = httpConCreate.conCreate(RetrofitRequest.class);
        Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
        Type[] actualTypeArguments=null;
        for (int i = 0; i < genericInterfaces.length; i++) {
            if(genericInterfaces[i] instanceof ParameterizedType){
                actualTypeArguments = ((ParameterizedType) genericInterfaces[i]).getActualTypeArguments();
            }
        }
        Type types =  actualTypeArguments[0];
        httpRequest.doGet(url,types,callback);

    }

    @Override
    public void httpRequest(String url, Map<String, String> map, HttpCallback callback) {
        HttpFactorys httpConCreate = new HttpConCreate();
        HttpRequest httpRequest = httpConCreate.conCreate(RetrofitRequest.class);
        Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
        Type[] actualTypeArguments=null;
        for (int i = 0; i < genericInterfaces.length; i++) {
            if(genericInterfaces[i] instanceof ParameterizedType){
                actualTypeArguments = ((ParameterizedType) genericInterfaces[i]).getActualTypeArguments();
            }
        }
        Type types =  actualTypeArguments[0];
        httpRequest.doPost(url,types,map,callback);
    }

    @Override
    public void uploadFile(Uri fileUri, HttpCallback callback) {
        HttpFactorys httpConCreate = new HttpConCreate();
        HttpRequest httpRequest = httpConCreate.conCreate(RetrofitRequest.class);
        httpRequest.uploadFile(fileUri,callback);
    }

    @Override
    public void upLoadFiles(List<File> mFiles, HttpCallback callback) {
        HttpFactorys httpConCreate = new HttpConCreate();
        HttpRequest httpRequest = httpConCreate.conCreate(RetrofitRequest.class);
        httpRequest.upLoadFiles(mFiles, callback);
    }
}
