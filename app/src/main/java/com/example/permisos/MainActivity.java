package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnCall).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                getPackageManager().PERMISSION_DENIED){
            requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, 1987);


        }else {
            Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8715349734"));
            startActivity(intentCall);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       if(requestCode == 1987){
           if(grantResults.length>0 && grantResults[0] == getPackageManager().PERMISSION_GRANTED){
               Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8715349734"));
               startActivity(intentCall);
           }
       }
    }
}