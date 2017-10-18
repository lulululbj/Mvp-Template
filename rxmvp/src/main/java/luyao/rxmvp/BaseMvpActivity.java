package luyao.rxmvp;

import luyao.rxmvp.mvp.BaseView;
import luyao.rxmvp.mvp.RxPresenter;

/**
 * Created by luyao
 * on 2017/10/17 13:59
 */

public abstract class BaseMvpActivity<P extends RxPresenter> extends BaseActivity implements BaseView {

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onViewCreated() {
        if (mPresenter == null)
            mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onRequestStart() {
    }

    @Override
    public void onRequestComplete() {

    }

    @Override
    public void onRequestError(String msg) {

    }

    @Override
    public void onNetError() {

    }
}
