package com.silent.fiveghos.tourist.db.factor;

import android.content.Context;

import com.silent.fiveghos.tourist.db.product.IOpenHelper;
import com.silent.fiveghos.tourist.http.products.HttpRequest;

/**
 * @author 农民伯伯
 * @version 2017/12/26
 */

public interface DatabaseCreat {
    <T extends HttpRequest> IOpenHelper conCreate(Context context, Class<T> clz);
}
