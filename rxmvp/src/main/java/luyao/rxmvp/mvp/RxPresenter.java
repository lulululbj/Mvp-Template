package luyao.rxmvp.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by luyao
 * on 2017/10/16 15:49
 */

public class RxPresenter<V extends BaseView> implements BasePresenter<V> {

    protected V mView;

    private CompositeDisposable mCompositeDisposable;

    public RxPresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        unSubscribe();
    }

    private void unSubscribe() {
        mView = null;
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

    protected void subscribe(Disposable disposable) {
        if (mCompositeDisposable == null)
            mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(disposable);
    }
}
