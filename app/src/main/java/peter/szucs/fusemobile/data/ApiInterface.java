package peter.szucs.fusemobile.data;

import peter.szucs.fusemobile.data.model.Company;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by peterszucs on 10/11/15.
 */
public interface ApiInterface {

    //GET https://[COMPANY NAME].fusion-universal.com/api/v1/company.json

    @GET("/company.json")
    Observable<Company> getCompany();


}
