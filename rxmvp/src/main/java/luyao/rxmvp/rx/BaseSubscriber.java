package luyao.rxmvp.rx;


import io.reactivex.subscribers.ResourceSubscriber;
import luyao.rxmvp.mvp.BaseView;

/**
 * Created by luyao
 * on 2017/9/12 14:46
 */

public class BaseSubscriber<T> extends ResourceSubscriber<T> {

    private BaseView v;

    public BaseSubscriber(BaseView v) {
        this.v = v;
    }

    @Override
    protected void onStart() {
        super.onStart();
        v.onRequestStart();
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        v.onRequestError(t.getMessage());
    }

    @Override
    public void onComplete() {
        v.onRequestComplete();
    }
}
