package luyao.mvptemplate.model;

import io.reactivex.Flowable;
import luyao.mvptemplate.model.api.Api;
import luyao.mvptemplate.model.bean.FilmBean;

/**
 * Created by luyao
 * on 2017/10/18 16:10
 */

public class DataManager implements Api {

    private static DataManager mInstance;
    private Api api;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (mInstance == null) {
            synchronized (DataManager.class) {
                if (mInstance == null) mInstance = new DataManager();
            }
        }
        return mInstance;
    }

    public void init(Api api) {
        this.api = api;
    }

    @Override
    public Flowable<FilmBean> getData() {
        return api.getData();
    }
}
