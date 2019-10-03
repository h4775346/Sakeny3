package com.snonosystems.sakeny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    CardView sellerCard , studentCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        sellerCard = findViewById(R.id.card_seller);
        studentCard = findViewById(R.id.card_buyer);


    }
}
