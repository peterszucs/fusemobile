package peter.szucs.fusemobile.view.main;

import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import peter.szucs.fusemobile.R;
import peter.szucs.fusemobile.data.model.Company;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Bind(R.id.text_input)
    EditText inputField;

    @Bind(R.id.text_input_wrapper)
    TextInputLayout textInputLayout;

    @Bind(R.id.progress_bar)
    ProgressBar progressBar;

    @Bind(R.id.company_logo)
    ImageView imageView;

    @BindColor(R.color.red)
    int COLOR_RED;

    @BindColor(R.color.green)
    int COLOR_GREEN;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

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

    private void setEnabledInput(boolean enabled) {
        textInputLayout.setEnabled(enabled);
        textInputLayout.setFocusable(enabled);

    }

    @Override
    public void showProgress() {
        runOnUiThread(() -> {
            setEnabledInput(false);
            progressBar.setVisibility(View.VISIBLE);
        });

    }

    @Override
    public void hideProgress() {
        runOnUiThread(() -> {
            setEnabledInput(true);
            progressBar.setVisibility(View.GONE);
        });
    }

    @Override
    public void showResults(Company company) {
        // in case of showin any info about company..
        runOnUiThread(() -> {
            Picasso.with(this).load(company.getLogo()).into(imageView);
            imageView.setVisibility(View.VISIBLE);
            inputField.setText(company.getName());
            inputField.setBackgroundColor(COLOR_GREEN);
            inputField.setTextColor(Color.WHITE);
        });
        presenter.unsubscribe();
    }

    @Override
    public void showMessage(int messageResourceId) {
        runOnUiThread(() ->
                        Toast.makeText(this, getString(messageResourceId), Toast.LENGTH_LONG).show()
        );
    }

    @Override
    public void showMessage(String message) {
        runOnUiThread(() ->
                        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        );
    }

    public void setInputFieldRed() {
        runOnUiThread(() -> {
            inputField.setBackgroundColor(COLOR_RED);
        });
    }

    @Override
    public void resetView() {
        runOnUiThread(() -> {
            inputField.setBackground(null);
            inputField.setTextColor(Color.BLACK);
            imageView.setVisibility(View.GONE);
        });
    }
}
