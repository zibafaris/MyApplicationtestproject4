package com.example.myapplicationapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

public class FilmFinderr  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_finder);
        final EditText name=findViewById(R.id.edtsearch);
        final TextView title=findViewById(R.id.title);
        final TextView year=findViewById(R.id.yeartxt);
        final TextView genre=findViewById(R.id.genre);
        final TextView director=findViewById(R.id.director);
        final TextView writer=findViewById(R.id.writer);
        final TextView actors=findViewById(R.id.actors);
        final TextView plot=findViewById(R.id.plot);
        final TextView lang=findViewById(R.id.lang);
        final TextView country=findViewById(R.id.country);
        final TextView awards=findViewById(R.id.awards);
        final TextView poster=findViewById(R.id.poster);
        final TextView rating=findViewById(R.id.rating);
        final TextView website=findViewById(R.id.website);
        Button btnsearch=findViewById(R.id.btnfind);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //url=http://www.omdbapi.com/?i=tt3896198&apikey=254f905a

                final EditText name=findViewById(R.id.edtsearch);
                String search = "http://www.omdbapi.com/?i="+name.getText()+"&apikey=254f905a";

                AsyncHttpClient client = new AsyncHttpClient();
                client.get(search, new  JsonHttpResponseHandler() {

                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        try {
                            title.setText(response.getString("Title"));
                            year.setText(response.getString("Year"));
                            genre.setText(response.getString("Genre"));
                            director.setText(response.getString("Director"));
                            writer.setText(response.getString("Writer"));
                            actors.setText(response.getString("Actors"));
                            plot.setText(response.getString("Plot"));
                            lang.setText(response.getString("Language"));
                            country.setText(response.getString("Country"));
                            poster.setText(response.getString("Poster"));
                            awards.setText(response.getString("Awards"));
                            rating.setText(response.getString("Rating"));
                            website.setText(response.getString("Website"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                    }
                });
            }
        });
    }
}
