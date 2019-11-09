package com.example.myapplicationapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        final TextView txt1 =findViewById(R.id.txt1);
        final TextView txt2 =findViewById(R.id.txt2);
        final TextView txt3 =findViewById(R.id.txt3);
        final TextView txt4 =findViewById(R.id.txt4);
        Button btnOk =findViewById(R.id.btnOk);
        Button btnEdit = findViewById(R.id.btnEdit);

        Intent i=getIntent();

        txt1.setText(i.getStringExtra("name"));
        txt2.setText(i.getStringExtra("family"));
        txt3.setText(i.getStringExtra("age"));
        txt4.setText(i.getStringExtra("email"));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent();
                i.putExtra("name",txt1.getText());
                i.putExtra("family",txt2.getText());
                i.putExtra("age",txt3.getText());
                i.putExtra("email",txt4.getText());
                setResult(ProfileActivity.RESULT_OK,i);
                Toast.makeText(ViewActivity.this," successful",Toast.LENGTH_SHORT).show();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("name",txt1.getText());
                i.putExtra("family",txt2.getText());
                i.putExtra("age",txt3.getText());
                i.putExtra("email",txt4.getText());

                PreferenceManager.getDefaultSharedPreferences(ViewActivity.this).getString("name",txt1.getText().toString());
                PreferenceManager.getDefaultSharedPreferences(ViewActivity.this) .getString("family",txt2.getText().toString());
                PreferenceManager.getDefaultSharedPreferences(ViewActivity.this) .getString("age",txt3.getText().toString());
                PreferenceManager.getDefaultSharedPreferences(ViewActivity.this) .getString("email",txt4.getText().toString());
                setResult(ProfileActivity.RESULT_CANCELED);
                Toast.makeText(ViewActivity.this,"retry",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
