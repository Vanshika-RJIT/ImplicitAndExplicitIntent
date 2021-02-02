package com.example.implicitandexplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtWelcome;
    private Button btnCaptureImage;
    private ImageView imgSelectedImage;
    private  static  int CAPTURE_IMAGE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtWelcome = findViewById(R.id.txt_welcome);
        btnCaptureImage = findViewById(R.id.btn_capture_image);
        imgSelectedImage = findViewById(R.id.img_selected_image);
        String userName = getIntent().getStringExtra("username");
        txtWelcome.setText("Welcome "+userName);
        btnCaptureImage.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,CAPTURE_IMAGE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==CAPTURE_IMAGE){
            if(data!=null&&data.getExtras()!=null){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgSelectedImage.setImageBitmap(bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}