package com.appbrainmob.bubblesoft.homeworkguru.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.appbrainmob.bubblesoft.homeworkguru.activities.MainActivity;
import com.appbrainmob.bubblesoft.homeworkguru.networks.Api;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Win 8 on 3/16/2017.
 */
public class SetApiIntegration extends AsyncTask<Void, Void, Void> {

    private Context context;

    public SetApiIntegration(Context context) {

        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        ProgressDialog pDialog = getInstance().getpDialog();

        try {
            getInstance().setpDialog(pDialog = new ProgressDialog(this.context));
            pDialog.setTitle("CONNECTING TO THE SERVER !");
            pDialog.setMessage("PLEASE WAIT !");
            pDialog.setCancelable(true);
            pDialog.show();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Void doInBackground(Void... params) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.duckduckgo.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Api service = retrofit.create(Api.class);

        Call<ResponseBody> result = service.list("Cool");

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

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

        super.onPostExecute(result);

        ProgressDialog pDialog = getInstance().getpDialog();

        try {
            if(pDialog.isShowing())
                pDialog.dismiss();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private MainActivity getInstance() {

        MainActivity mainActivity = new MainActivity();
        return  mainActivity;
    }
}
