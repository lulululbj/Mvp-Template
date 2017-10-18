package luyao.mvptemplate.ui.main;

import luyao.mvptemplate.data.FilmData;
import luyao.rxmvp.mvp.RxPresenter;
import luyao.rxmvp.mvp.BaseView;


/**
 * Created by luyao
 * on 2017/10/17 10:00
 */

public interface MainContract {

    interface View extends BaseView {
        void getInfo(FilmData info);
    }


    abstract class Presenter extends RxPresenter<View> {
        abstract void getInfo();
    }
}
