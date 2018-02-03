package com.silent.fiveghost.tourist.presenter;


import android.net.Uri;

import com.silent.fiveghost.tourist.contract.InfoContract;
import com.silent.fiveghost.tourist.model.InfoModel;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */

public class InfoPresenter implements InfoContract.Presenter {
    private InfoContract.View view;
    private InfoModel mModel;


    public InfoPresenter(InfoContract.View view){
        this.view=view;
        mModel = new InfoModel();
    }


    @Override
    public void getData(String url) {
        mModel.httpRequest(url,view);
    }

    @Override
    public void getData(String url, Map<String, String> map) {
        mModel.httpRequest(url,map,view);
    }

    @Override
    public void upFile(Uri fileUri) {
        mModel.uploadFile(fileUri,view);

    }

    @Override
    public void upFiles(List<File> mFiles) {
        mModel.upLoadFiles(mFiles,view);
    }
}
