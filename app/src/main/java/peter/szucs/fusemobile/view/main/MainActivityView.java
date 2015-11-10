package peter.szucs.fusemobile.view.main;

import peter.szucs.fusemobile.data.model.Company;

/**
 * Created by peter on 2015. 11. 09..
 */
public interface MainActivityView {

    void showProgress();
    void hideProgress();
    void showResults(Company company);
    void showMessage(int messageResourceId);

}
