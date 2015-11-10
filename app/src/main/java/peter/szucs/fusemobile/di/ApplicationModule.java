package peter.szucs.fusemobile.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import peter.szucs.fusemobile.BaseApplication;
import peter.szucs.fusemobile.data.ApiManager;

/**
 * Created by peterszucs on 10/11/15.
 */
@Module
public class ApplicationModule {

    private BaseApplication application;

    public ApplicationModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context providesBaseContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public ApiManager providesApiManager() {
        return new ApiManager(application.getApplicationContext());
    }

}
