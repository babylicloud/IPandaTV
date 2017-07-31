package test.bwie.jiyun.com.ins7566.ipandatv.internet;

/**
 * Created by INS7566 on 2017/7/27.
 */

public class HttpFactory {
    private static final int OKHTTP=0;

    private static final int TYPE=OKHTTP;
    public static IHttp create(){
        IHttp iHttp=null;
        switch (TYPE){
            case OKHTTP:
                iHttp= OKHttpUtils.getInstance();
                break;
        }
        return iHttp;
    }

    public static IHttp create1() {
        return HeaderUtils.getInstance();
    }


}
