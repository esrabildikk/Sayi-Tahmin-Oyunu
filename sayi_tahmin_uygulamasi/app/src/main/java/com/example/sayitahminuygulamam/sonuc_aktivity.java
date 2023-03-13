package com.example.sayitahminuygulamam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class sonuc_aktivity extends AppCompatActivity {
    private Button buttonAgain;
    private  boolean sonuc;
    private TextView textView;
    private ImageView imageKaybetti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_aktivity);

        buttonAgain=findViewById(R.id.buttonAgain);
        imageKaybetti = findViewById(R.id.imageKaybetti);
        textView= findViewById(R.id.textView);

      sonuc = getIntent().getBooleanExtra("sonuc", false);
            if (sonuc){
                textView.setText("Kazandınız");
                imageKaybetti.setImageResource(R.drawable.kazandi);
            }else {
                textView.setText("Tekrar Dene");
                imageKaybetti.setImageResource(R.drawable.kaybetti
                );
            }

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                startActivity(new Intent(sonuc_aktivity.this,MainActivity.class));
            }
        });

    }
}