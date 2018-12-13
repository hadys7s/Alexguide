package com.example.android.alextourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView restaurant = (TextView) findViewById(R.id.restaurants);
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent res = new Intent(MainActivity.this, restaurants.class);
                startActivity(res);


            }
        });
            TextView hotels = (TextView) findViewById(R.id.hotels);
            hotels.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent hot = new Intent(MainActivity.this, Hotels.class);
                    startActivity(hot);


                }
            });
                TextView hospitals = (TextView) findViewById(R.id.hospitals);
                hospitals.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent hos = new Intent(MainActivity.this, hospitals.class);
                        startActivity(hos);


                    }
                });
                    TextView cafes = (TextView) findViewById(R.id.cafes);
                cafes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent caf = new Intent(MainActivity.this, Cafes.class);
                            startActivity(caf);


                        }
                });
                        TextView shop = (TextView) findViewById(R.id.shopiing);
                        shop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent sho = new Intent(MainActivity.this, Shopping.class);
                                startActivity(sho);


                            }
                        });

    }
}
