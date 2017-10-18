package luyao.mvptemplate.ui.main;

import android.widget.Toast;

import luyao.mvptemplate.R;
import luyao.mvptemplate.data.FilmData;
import luyao.rxmvp.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @Override
    protected void initData() {
        mPresenter.getInfo();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void getInfo(FilmData info) {
        Toast.makeText(this, info.toString(), Toast.LENGTH_SHORT).show();
    }
}
