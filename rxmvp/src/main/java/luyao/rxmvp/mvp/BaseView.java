package luyao.rxmvp.mvp;

/**
 * Created by luyao
 * on 2017/10/16 15:46
 */

public interface BaseView {

    void onRequestStart();

    void onRequestError(String msg);

    void onRequestComplete();

    void onNetError();

}
