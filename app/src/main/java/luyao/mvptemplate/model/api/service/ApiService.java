package luyao.mvptemplate.model.api.service;

import io.reactivex.Flowable;
import luyao.mvptemplate.model.bean.FilmBean;
import retrofit2.http.GET;


/**
 * Created by luyao
 * on 2017/10/17 10:19
 */

public interface ApiService {

     String BASE_URL = "https://api.douban.com/";

    @GET("v2/movie/in_theaters")
    Flowable<FilmBean> getData();
}
