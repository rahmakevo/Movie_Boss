package com.example.rahmak.movie_boss;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by rahmak on 9/22/17.
 */

public class API_Service {
    public static final String TAG = Movies.class.getSimpleName();

    public static void fetchApiService(String name, Callback callback){

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.API_KEY, Constants.API_READ_ACCESS_TOKEN);
        consumer.setTokenWithSecret(Constants.API_KEY, Constants.API_READ_ACCESS_TOKEN);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new SigningInterceptor(consumer)).build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_REQUEST_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_MOVIENAME_QUERY_PARAMETER, name);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Results> processResults(Response response){
        ArrayList<Results> results = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            Log.v(TAG, jsonData);

            if (response.isSuccessful()){
                JSONObject jsonObject = new JSONObject(jsonData);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    String title = jsonObject1.getString("title");
                    double vote_average = jsonObject1.getDouble("vote_average");
                    String poster_path = jsonObject1.getString("poster_path");

                    Results results1 = new Results(title, vote_average, poster_path);
                    results.add(results1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return results;
    }
}
