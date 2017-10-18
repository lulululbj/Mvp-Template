package luyao.mvptemplate;

import android.app.Application;

import luyao.mvptemplate.model.DataManager;
import luyao.mvptemplate.model.api.ApiDataSource;

/**
 * Created by luyao
 * on 2017/10/18 16:35
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataManager.getInstance().init(new ApiDataSource());
    }
}
