package luyao.mvptemplate.api;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import luyao.mvptemplate.data.FilmData;
import retrofit2.http.GET;


/**
 * Created by luyao
 * on 2017/10/17 10:19
 */

public interface ApiService {

    @GET("v2/movie/in_theaters")
    Flowable<FilmData> getData();
}
