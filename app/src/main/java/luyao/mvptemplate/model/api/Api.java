package luyao.mvptemplate.model.api;

import io.reactivex.Flowable;
import luyao.mvptemplate.model.bean.FilmBean;

/**
 * Created by luyao
 * on 2017/10/18 16:20
 */

public interface Api {
    Flowable<FilmBean> getData();
}
