package com.example.sayitahminuygulamam;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class tahmin_activity extends AppCompatActivity {
    private int randomSayi;
    private int sayac=5;
    private Button buttonGonder;
    private TextView textTahmin;
    private TextView textHak;
    private EditText editTextTahminim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);
        buttonGonder=findViewById(R.id.buttonGonder);
        textTahmin=findViewById(R.id.textTahmin);
        textHak= findViewById(R.id.textHak);
        editTextTahminim=findViewById(R.id.editTextTahminim);

        Random r = new Random();
        randomSayi = r.nextInt(101);
        Log.e("Rastgele sayi: ", String.valueOf(randomSayi));

        buttonGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayac= sayac - 1;
                int tahmin= Integer.parseInt(editTextTahminim.getText().toString());
                if (tahmin==randomSayi){
                  Intent i = new Intent(tahmin_activity.this, sonuc_aktivity.class);
                  i.putExtra("sonuc", true);
                  startActivity(i);
                    finish();
                    return;
                }
                if (tahmin<randomSayi){
                    textTahmin.setText("Tahmini Arttır");
                    textHak.setText("Kalan Hak: "+sayac);
                }
                if (tahmin>randomSayi){
                    textTahmin.setText("Tahmini Azalt");
                    textHak.setText("Kalan Hak: "+sayac);
                }
                if (sayac==0){
                    Intent i = new Intent(tahmin_activity.this, sonuc_aktivity.class);
                    i.putExtra("sonuc", false);
                    startActivity(i);
                    finish();
                }
                editTextTahminim.setText("");
            }
        });

    }
}