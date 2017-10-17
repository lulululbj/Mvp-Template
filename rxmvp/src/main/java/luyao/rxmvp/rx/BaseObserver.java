package luyao.rxmvp.rx;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import luyao.rxmvp.mvp.BaseView;

/**
 * Created by luyao
 * on 2017/9/12 14:46
 */

public class BaseObserver<T> implements Observer<T> {

    private BaseView v;

    public BaseObserver(BaseView v) {
        this.v = v;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        v.onRequestStart(d);
    }

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {
        v.onRequestError(e.getMessage());
    }

    @Override
    public void onComplete() {
        v.onRequestComplete();
    }
}
