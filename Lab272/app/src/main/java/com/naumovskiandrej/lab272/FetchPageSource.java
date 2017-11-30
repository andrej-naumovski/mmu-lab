package com.naumovskiandrej.lab272;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.widget.TextView;

public class FetchPageSource extends AsyncTaskLoader<String> {
    private String mUrl;
    private String mProtocol;

    public FetchPageSource(Context context, String url, String protocol) {
        super(context);
        mUrl = url;
        mProtocol = protocol;
    }

    @Override
    public String loadInBackground() {
        return NetworkUtils.doGet(mUrl, mProtocol);
    }


}
