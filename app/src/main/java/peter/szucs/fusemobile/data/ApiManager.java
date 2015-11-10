package peter.szucs.fusemobile.data;

import android.content.Context;

import peter.szucs.fusemobile.R;
import retrofit.Retrofit;

/**
 * Created by peterszucs on 10/11/15.
 */
public class ApiManager {

    private final String host;
    private final String version;

    public ApiManager(Context context) {
        host = context.getString(R.string.api_host);
        version = context.getString(R.string.api_version);
    }

    public ApiInterface createCompanySubdomainRetrofit(String companyName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(companyName + "." + host + version)
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
