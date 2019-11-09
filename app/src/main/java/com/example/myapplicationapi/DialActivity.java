package com.example.myapplicationapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dial);

        final EditText edtnum =findViewById(R.id.edtnum);
        Button btnDial = findViewById(R.id.btnreview);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+edtnum.getText().toString()));
                startActivity(i);
                Toast.makeText(DialActivity.this,"add in dial",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
