package peter.szucs.fusemobile.data;

import android.content.Context;
import android.util.Log;

import peter.szucs.fusemobile.BuildConfig;
import peter.szucs.fusemobile.R;
import peter.szucs.fusemobile.data.model.Company;
import retrofit.RestAdapter;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by peterszucs on 10/11/15.
 */
public class ApiManager {

    private final String host;
    private final String version;

    ApiInterface apiInterface;

    public ApiManager(Context context) {
        host = context.getString(R.string.api_host);
        version = context.getString(R.string.api_version);
    }

    public ApiManager createCompanySubdomainRetrofit(String companyName) {
        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint("https://" + companyName + "." + host + version)
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        return this;
    }

    public Observable<Company> getCompany() {
        return apiInterface.getCompany()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());

    }

}
