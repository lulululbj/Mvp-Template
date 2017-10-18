package luyao.rxmvp.mvp;

import android.support.annotation.UiThread;

import io.reactivex.disposables.Disposable;

/**
 * Created by luyao
 * on 2017/10/16 15:47
 */

public interface BasePresenter<V extends BaseView> {

    @UiThread
    void attachView(V view);

    @UiThread
    void detachView();
}
