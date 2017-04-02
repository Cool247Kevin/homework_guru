package com.appbrainmob.bubblesoft.homeworkguru.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.appbrainmob.bubblesoft.homeworkguru.constants.AppConstants;
import com.appbrainmob.bubblesoft.homeworkguru.networks.Api;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Win 8 on 3/19/2017.
 */
public class RequestApisForCommunication {

    private String question;
    private Context context;
    private ProgressDialog progressDialog;


    public RequestApisForCommunication(Context context) {

        this.context = context;
    }

    public void accessApi(String question) {

        onPreExecute();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.WEBKNOX_BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Api service = retrofit.create(Api.class);

        Call<ResponseBody> result = service.answer(question, "text");

        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("MESSAGE : ", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                try {
                    Log.d("ERROR : ", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        onPostExecute();
    }

    private void onPreExecute() {

        try {
            progressDialog = new ProgressDialog(this.context);
            progressDialog.setTitle("CONNECTING TO THE SERVER !");
            progressDialog.setMessage("PLEASE WAIT !");
            progressDialog.setCancelable(true);
            progressDialog.show();
        } catch (IllegalStateException ise) {
            ise.printStackTrace();
        }
    }

    private void onPostExecute() {

        final int delayTime = 10000;

        try {
            if (progressDialog.isShowing())
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                }, delayTime);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}
