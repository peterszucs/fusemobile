package peter.szucs.fusemobile.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import peter.szucs.fusemobile.R;
import peter.szucs.fusemobile.data.model.Company;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Bind(R.id.text_input)
    EditText inputField;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        inputField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    presenter.startLookUp(inputField.getText().toString().trim());
                }
                return false;
            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showResults(Company company) {

    }

    @Override
    public void showMessage(int messageResourceId) {

    }
}
