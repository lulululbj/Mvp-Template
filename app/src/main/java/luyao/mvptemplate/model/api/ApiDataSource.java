package luyao.mvptemplate.model.api;

import io.reactivex.Flowable;
import luyao.mvptemplate.model.api.service.ApiService;
import luyao.mvptemplate.model.bean.FilmBean;

/**
 * Created by luyao
 * on 2017/10/18 16:21
 */

public class ApiDataSource implements Api {

    private ApiService apiService;

    public ApiDataSource() {
        apiService = ApiClient.getInstance().getService(ApiService.class, ApiService.BASE_URL);
    }

    @Override
    public Flowable<FilmBean> getData() {
        return apiService.getData();
    }
}
