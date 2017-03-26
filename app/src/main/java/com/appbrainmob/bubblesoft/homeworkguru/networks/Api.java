package com.appbrainmob.bubblesoft.homeworkguru.networks;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Win 8 on 3/12/2017.
 */
public interface Api {

    @GET("users/{user}")
    Call<ResponseBody> list(@Path("user") String user);

    @GET("?")
    Call<ResponseBody> answer(@Query("q") String question, @Query("format") String format);

    @GET("questions/answers?")
    Call<ResponseBody> question(@Query("question") String question, @Query("answerLookup") boolean lookUp,
                                @Query("answerSearch") boolean answerSearch, @Query("apiKey") String apiKey );
}
