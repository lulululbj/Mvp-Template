package luyao.rxmvp.mvp;

import android.support.annotation.UiThread;

import io.reactivex.disposables.Disposable;

/**
 * Created by luyao
 * on 2017/10/16 15:47
 */

public interface MvpPresenter {

    @UiThread
    void subscribe(Disposable disposable);

    @UiThread
    void unSubscribe();
}
