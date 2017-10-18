package luyao.mvptemplate.ui.main;

import io.reactivex.disposables.Disposable;
import luyao.mvptemplate.api.Api;
import luyao.mvptemplate.data.FilmData;
import luyao.rxmvp.rx.BaseSubscriber;
import luyao.rxmvp.rx.RxSchedulers;

/**
 * Created by luyao
 * on 2017/10/17 10:11
 */

public class MainPresenter extends MainContract.Presenter {

    @Override
    public void getInfo() {
        Disposable d = Api.getInstance().getApiSerVice(Api.BASE_URL)
                .getData()
                .compose(RxSchedulers.<FilmData>switchThread())
                .subscribeWith(new BaseSubscriber<FilmData>(mView) {
                    @Override
                    public void onNext(FilmData filmData) {
                        mView.getInfo(filmData);
                    }
                });
        subscribe(d);
    }
}
