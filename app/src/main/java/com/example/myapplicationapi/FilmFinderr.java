package com.example.myapplicationapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplicationapi.Movies.Search;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class FilmFinderr extends AppCompatActivity implements MyMoviesViewAdapter.ItemClickListener,MyRecyclerViewAdapter.ItemClickListener{
    MyMoviesViewAdapter adapter;
    MyRecyclerViewAdapter adapterLeft;
    ArrayList<Search> MoviesArry;
    RecyclerView recyclerView;
    EditText edtsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_finder);

        recyclerView = findViewById(R.id.resnewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(FilmFinderr.this));

        Button btnfind = findViewById(R.id.btnfind);
        edtsearch = findViewById(R.id.edtsearch);
        btnfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchFilm= edtsearch.getText().toString();

                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://www.omdbapi.com/?apikey=98869092&t="+searchFilm, new JsonHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        try {
                            MoviesArry=new ArrayList<>();
                            JSONObject jsonobject = new JSONObject(responseString);
                            JSONArray jsonoArray = new JSONArray(jsonobject.getString("Search"));
                            for (int i = 0; i < jsonoArray.length(); i++) {
                                JSONObject jsonSub = jsonoArray.getJSONObject(i);
                                MoviesArry.add(new Search(jsonSub.getString("Poster"),jsonSub.getString("Title"),jsonSub.getString("Year"),jsonSub.getString("imdbID"),"","",""));

                            }
                            adapter = new MyMoviesViewAdapter(FilmFinderr.this, MoviesArry);
                            adapter.setClickListener(FilmFinderr.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapterLeft.getItem(position).name == "Movie Search") {

        }
    }

    @Override
    public void onItemClickMovie(View view, int position) {
    }
}
