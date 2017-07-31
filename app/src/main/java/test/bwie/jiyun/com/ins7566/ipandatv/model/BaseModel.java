package test.bwie.jiyun.com.ins7566.ipandatv.model;


import test.bwie.jiyun.com.ins7566.ipandatv.internet.HttpFactory;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.IHttp;

/**
 * Created by lx on 2017/7/11.
 */

public interface BaseModel {
    public static IHttp iHttp = HttpFactory.create();

    public static IHttp getiHttp=HttpFactory.create1();
}
