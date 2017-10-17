package luyao.mvptemplate.api;

import java.util.concurrent.TimeUnit;

import luyao.mvptemplate.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luyao
 * on 2017/10/17 10:17
 */

public class Api {

    public static String BASE_URL = "https://api.douban.com/";
    private static final int TIME_OUT = 5;
    private static Api api = null;


    private Api() {

    }

    public static Api getInstance() {
        if (api == null) {
            synchronized (Api.class) {
                if (api == null)
                    api = new Api();
            }
        }
        return api;
    }

    private OkHttpClient getHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }


    private <S> S getService(Class<S> serviceClass, String baseUrl) {
        return new Retrofit.Builder()
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build().create(serviceClass);
    }

    public ApiService getApiSerVice(String baseUrl) {

        return new Retrofit.Builder()
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build().create(ApiService.class);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
//    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
//
//        @Override
//        public T call(HttpResult<T> httpResult) {
////            if (httpResult.get() != 0) {
////                throw new ApiException(httpResult.getResultCode());
////            }
//            return httpResult.getResult();
//        }
//    }
//
//    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
//        o.subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s);
//    }

}
