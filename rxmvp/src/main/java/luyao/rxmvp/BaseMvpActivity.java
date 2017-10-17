package luyao.rxmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import luyao.rxmvp.mvp.BasePresenter;
import luyao.rxmvp.mvp.BaseView;

/**
 * Created by luyao
 * on 2017/10/17 13:59
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);

        initView();
        if (mPresenter == null)
            mPresenter = createPresenter();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unSubscribe();
    }

    protected abstract int getLayoutResId();

    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onRequestStart(Disposable d) {
        mPresenter.subscribe(d);
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
