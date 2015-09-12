package com.example.charliebuckets.nnba_android.rest;

import android.util.Log;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Dustin on 9/6/15.
 */
public class GetDataErrorHandler implements ErrorHandler {
    protected final String TAG = "DataErrorHandler";
    @Override
    public Throwable handleError(RetrofitError cause) {
        Response r = cause.getResponse();
        if (r != null && r.getStatus() == 401) {
            Log.e(TAG, "Error:", cause);
        }
        return cause;

    }
}
