package peter.szucs.fusemobile;

import android.app.Application;

import lombok.Getter;
import peter.szucs.fusemobile.di.ApplicationComponent;
import peter.szucs.fusemobile.di.ApplicationModule;
import peter.szucs.fusemobile.di.DaggerApplicationComponent;

/**
 * Created by peterszucs on 10/11/15.
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Getter
    private ApplicationComponent applicationComponent;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initializeDagger();
    }

    private void initializeDagger() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
