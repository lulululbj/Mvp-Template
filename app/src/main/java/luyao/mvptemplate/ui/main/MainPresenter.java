package luyao.mvptemplate.ui.main;

import io.reactivex.disposables.Disposable;
import luyao.mvptemplate.model.DataManager;
import luyao.mvptemplate.model.bean.FilmBean;
import luyao.rxmvp.rx.BaseSubscriber;
import luyao.rxmvp.rx.RxSchedulers;

/**
 * Created by luyao
 * on 2017/10/17 10:11
 */

public class MainPresenter extends MainContract.Presenter {

    @Override
    public void getInfo() {
        Disposable d = DataManager.getInstance()
                .getData()
                .compose(RxSchedulers.<FilmBean>switchThread())
                .subscribeWith(new BaseSubscriber<FilmBean>(mView) {
                    @Override
                    public void onNext(FilmBean filmData) {
                        mView.getInfo(filmData);
                    }
                });
        subscribe(d);
    }
}
