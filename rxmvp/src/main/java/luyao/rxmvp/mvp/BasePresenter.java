package luyao.rxmvp.mvp;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by luyao
 * on 2017/10/16 15:49
 */

public class BasePresenter<V extends BaseView> implements MvpPresenter {

    protected V mView;

    @NonNull
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe(Disposable disposable) {
        if (mCompositeDisposable.isDisposed())
            mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void unSubscribe() {
        mView = null;
        mCompositeDisposable.clear();
    }
}
