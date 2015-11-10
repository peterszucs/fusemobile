package peter.szucs.fusemobile.di;

import dagger.Component;
import peter.szucs.fusemobile.view.main.MainPresenter;

/**
 * Created by peterszucs on 10/11/15.
 */
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // Presenter Layer Injection
    void inject(MainPresenter mainPresenter);

}
