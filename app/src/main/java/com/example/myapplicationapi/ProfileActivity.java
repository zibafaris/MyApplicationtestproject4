package com.example.myapplicationapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        final EditText edtname = findViewById(R.id.edtname);
        final EditText edtfamily = findViewById(R.id.edtfamily);
        final EditText edtage = findViewById(R.id.edtage);
        final EditText edtemail = findViewById(R.id.edtemail);
        Button btnreview = findViewById(R.id.btnreview);

        final String name = edtname.getText().toString();
        final String family = edtfamily.getText().toString();
        final String age = edtage.getText().toString();
        final String email = edtemail.getText().toString();

        edtname.setText(name);
        edtfamily.setText(family);
        edtage.setText(age);
        edtemail.setText(email);

        btnreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, ViewActivity.class);

                i.putExtra("name",edtname.getText().toString());
                i.putExtra("family",edtfamily.getText().toString());
                i.putExtra("age",edtage.getText().toString());
                i.putExtra("email",edtemail.getText().toString());
                startActivityForResult(i,200);
                Toast.makeText(ProfileActivity.this,"btn review",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 210  && resultCode  == RESULT_OK) {
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("name",data.getStringExtra("name")).apply();
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("family",data.getStringExtra("family")).apply();
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("age",data.getStringExtra("age")).apply();
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("mail",data.getStringExtra("mail")).apply();
        }
        else {

        }
    }
}
