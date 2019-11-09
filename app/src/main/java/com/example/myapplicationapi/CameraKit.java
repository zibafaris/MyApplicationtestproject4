package com.example.myapplicationapi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.camerakit.CameraKitView;
import java.io.File;
import java.io.FileOutputStream;

public class CameraKit extends AppCompatActivity {
    private CameraKitView cameraKitView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        cameraKitView = findViewById(R.id.camera);
        Button btnCamera = findViewById(R.id.btncamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(CameraKit.this,
                        Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CameraKit.this, new String[]{Manifest.permission.CAMERA}, 1500);
                } else {
                    cameraKitView.captureImage(new CameraKitView.ImageCallback() {
                        @Override
                        public void onImage(CameraKitView cameraKitView, final byte[] capturedImage) {
                            File savedPhoto = new File(Environment.getRootDirectory(), "photo.jpg");
                            try {
                                FileOutputStream outputStream = new FileOutputStream(savedPhoto.getPath());
                                outputStream.write(capturedImage);
                                outputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

            }
        });
    }





    @Override
    protected void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraKitView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraKitView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cameraKitView.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}