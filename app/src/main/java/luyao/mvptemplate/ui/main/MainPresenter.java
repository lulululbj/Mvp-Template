package luyao.mvptemplate.ui.main;

import io.reactivex.annotations.NonNull;
import luyao.mvptemplate.api.Api;
import luyao.rxmvp.rx.BaseObserver;
import luyao.mvptemplate.data.FilmData;
import luyao.rxmvp.rx.RxSchedulers;

/**
 * Created by luyao
 * on 2017/10/17 10:11
 */

public class MainPresenter extends MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        mView = view;
    }


    @Override
    public void getInfo() {
        Api.getInstance().getApiSerVice(Api.BASE_URL)
                .getData()
                .compose(RxSchedulers.<FilmData>switchThread())
                .subscribe(new BaseObserver<FilmData>(mView) {
                    @Override
                    public void onNext(@NonNull FilmData data) {
                        mView.getInfo(data);
                    }
                });
    }
}
