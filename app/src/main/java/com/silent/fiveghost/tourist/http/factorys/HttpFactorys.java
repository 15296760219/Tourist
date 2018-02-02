package com.silent.fiveghost.tourist.http.factorys;

import com.silent.fiveghost.tourist.http.products.HttpRequest;


/**
 * @author 农民伯伯
 * @version 2017/12/22
 *          抽象工厂中的抽象工厂
 */

public interface HttpFactorys {
     <T extends HttpRequest> HttpRequest conCreate(Class<T> clz);


}
