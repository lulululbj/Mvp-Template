package luyao.rxmvp.mvp;

import io.reactivex.disposables.Disposable;

/**
 * Created by luyao
 * on 2017/10/16 15:46
 */

public interface BaseView {

    void onRequestStart(Disposable d);

    void onRequestError(String msg);

    void onRequestComplete();

    void onNetError();

}
