package com.innovation.user.leave;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewActivity extends Activity {
    CardView cardView;
    ImageView imageView;
    TextView title;
    TextView titleHeader;
    TextView titleHeaderCountry;
    TextView titleHeaderCountryBelow;
    TextView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_item);
        cardView = findViewById(R.id.cardView);
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.title);
        titleHeader = findViewById(R.id.titleHeader);
        titleHeaderCountry = findViewById(R.id.titleHeaderCountry);
        titleHeaderCountryBelow = findViewById(R.id.titleHeaderCountryBelow);
        more = findViewById(R.id.more);
    }
}
