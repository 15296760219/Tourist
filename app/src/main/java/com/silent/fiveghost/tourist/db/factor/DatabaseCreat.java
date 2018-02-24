package com.silent.fiveghost.tourist.db.factor;

import android.content.Context;

import com.silent.fiveghost.tourist.db.product.IOpenHelper;
import com.umeng.message.util.HttpRequest;

/**
 * @author 农民伯伯
 * @version 2017/12/26
 */

public interface DatabaseCreat {
    <T extends HttpRequest> IOpenHelper conCreate(Context context, Class<T> clz);
}
