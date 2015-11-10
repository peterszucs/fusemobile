package peter.szucs.fusemobile.view.main;

import android.text.TextUtils;

import javax.inject.Inject;

import peter.szucs.fusemobile.BaseApplication;
import peter.szucs.fusemobile.data.ApiManager;
import peter.szucs.fusemobile.data.model.ErrorType;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by peterszucs on 05/11/15.
 */
public class MainPresenter {

    MainActivityView view;

    @Inject
    ApiManager apiManager;
    private Subscription getCompanySubscription;

    public MainPresenter(MainActivityView view) {
        this.view = view;
        inject();
    }

    private void inject() {
        BaseApplication.getInstance().getApplicationComponent().inject(this);
    }

    public void startLookUp(String companyName) {
        if (TextUtils.isEmpty(companyName)) {
            view.showMessage(ErrorType.COMPANY_NAME_EMPTY.getResourceId());
        } else if (companyName.length() < 2) {
            view.showMessage(ErrorType.COMPANY_NAME_INVALID.getResourceId());
        } else {
            getCompanySubscription = apiManager.createCompanySubdomainRetrofit(companyName).getCompany()
                    .doOnSubscribe(view::showProgress)
                    .doOnUnsubscribe(view::hideProgress)
                    .observeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(view::showResults);
        }
    }

    public void unsubscribe() {
        getCompanySubscription.unsubscribe();
    }


}
