package com.naumovskiandrej.lab272;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private Spinner mProtocolSelect;
    private EditText mUrlInput;
    private Button mSubmitTask;
    private TextView mPageSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProtocolSelect = findViewById(R.id.protocolSelect);
        mUrlInput = findViewById(R.id.urlInput);
        mSubmitTask = findViewById(R.id.submitTask);
        mPageSource = findViewById(R.id.pageSource);

        List<String> spinnerElements = Arrays.asList(NetworkUtils.HTTP, NetworkUtils.HTTPS);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerElements);
        mProtocolSelect.setAdapter(adapter);

        mSubmitTask.setOnClickListener(view -> {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            if (connectivityManager.getActiveNetworkInfo() == null) {
                AlertDialog dialog = new AlertDialog.Builder(this).create();
                dialog.setTitle("Error");
                dialog.setMessage("You don't seem to be connected to the Internet. Please check your network and try again");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (dial, id) -> dial.dismiss());
                dialog.show();
            } else {
                getLoaderManager().initLoader(10, null, this).forceLoad();
            }
        });
    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        return new FetchPageSource(
                this,
                mUrlInput.getText().toString(),
                mProtocolSelect.getSelectedItem().toString());
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String s) {
        mPageSource.setText(s);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
