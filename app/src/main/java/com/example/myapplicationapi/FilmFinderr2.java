package com.example.myapplicationapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplicationapi.Movies.Search;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.picasso.Picasso;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class FilmFinderr2 extends AppCompatActivity {
    MyMoviesViewAdapter adapter;
    ArrayList<Search> MoviesArry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdetail2);
        Intent intent = getIntent();
        String MessageID = intent.getStringExtra("imdbCode");

        String Url = "http://www.omdbapi.com/?i="+MessageID+"&apikey=b80e72c2";// + intent.getStringExtra("ItemID");

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    JSONObject jsonSub = new JSONObject(responseString);
                    TextView txtTitle = findViewById(R.id.tvAnimalNamed);
                    TextView txtYear = findViewById(R.id.txtYeard);
                    TextView txtPlot = findViewById(R.id.txtPlotd);
                    TextView txtActors = findViewById(R.id.txtActorsd);
                    TextView txtCountry = findViewById(R.id.txtCountryd);
                    TextView txtReleased = findViewById(R.id.txtReleased);
                    TextView Runtime = findViewById(R.id.txtRuntime);
                    TextView Awards = findViewById(R.id.txtAwards);
                    ImageView _ImageView = findViewById(R.id.ImageView);
                    Picasso.get().load(String.valueOf(jsonSub.get("Poster"))).into(_ImageView);
                    txtTitle.setText(String.valueOf(jsonSub.get("Title")));
                    txtYear.setText(String.valueOf(jsonSub.get("Year")));
                    txtPlot.setText(String.valueOf(jsonSub.get("Plot")));
                    txtActors.setText(String.valueOf(jsonSub.get("Actors")));
                    txtCountry.setText(String.valueOf(jsonSub.get("Country")));//
                    txtReleased.setText(String.valueOf(jsonSub.get("Released")));
                    Runtime.setText(String.valueOf(jsonSub.get("Runtime")));
                    Awards.setText(String.valueOf(jsonSub.get("Awards")));
                    Log.d("salam4","1" );
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
