package com.example.netflix_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.AsyncTask;
import android.os.Bundle;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    //private static final String URL = "https://api.themoviedb.org/3/tv/1?api_key=f792e3ba42b2731b3a26e95c16c914c1&language=en-US";
    private static final String URL = "https://api.themoviedb.org/3/movie/popular?api_key=f792e3ba42b2731b3a26e95c16c914c1&language=en-US";
    //private String[] mData = {"Movie 1", "Movie 2", "Movie 3", "Movie 4"};

    private List<String> lstTitle = new ArrayList<String>(Arrays.asList("Popular"));
    private List<MovieModel> mMovieData = new ArrayList<>();

    MovieModel mMovieModel = new MovieModel();
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mRecyclerView = findViewById(R.id.rc_mainContent);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MovieAdapter(mMovieData, lstTitle); // Should pass a list as a presentation of data.
        mRecyclerView.setAdapter(mAdapter);

        // Setup Network and Cache
        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();

        // Setup the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequsetQueu with the cache and network
        //queue = new RequestQueue(cache, network);

        // Start the queue
        queue.start();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = (JSONArray) response.get("results");
//                    System.out.println(jsonArray.get(0));
//                    MovieModel model = gson.fromJson(jsonArray.get(0).toString(), MovieModel.class);
//                    System.out.println(model.getTitle());
                    for(int i = 0; i < jsonArray.length(); i++){
                        mMovieData.add(gson.fromJson(jsonArray.get(i).toString(), MovieModel.class));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //System.out.println(response.keys());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        //queue.add(stringRequest);
    }



}