package com.example.android.alextourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namelist);


        final    ArrayList<Name> restaurant = new ArrayList<Name>();
        restaurant.add(new Name("SeaGull Restaurant ", "SeaFood ", R.drawable.seagull,"مطعم سي جل"));
        restaurant.add(new Name("Byblos Restaurant","Lebanese", R.drawable.byos,"مطعم بيبلوس"));
        restaurant.add(new Name("7 Seas Fish Restaurant", "SeaFood", R.drawable.fish,"مطعم سفن سيز"));
        restaurant.add(new Name("China House Restaurant ", "Chinese Food", R.drawable.china,"تشاينا هاوس، Mohamed Ahmed Afify St.، SAN STEFANO، قسم الرمل"));
        restaurant.add(new Name("kfc Restaurant", " ", R.drawable.kfc," kfc alex"));
        restaurant.add(new Name("McDonald's Restaurant", " ", R.drawable.mac,"McDonald's, طريق الجيش، فلمنج، قسم الرمل"));
        restaurant.add(new Name("El-Falah Restaurant", "Popular food", R.drawable.falah," مطعم الفلاح، ميدان، المنشية الكبرى، قسم المنشية "));
        restaurant.add(new Name( "Gad Restaurant", "Popular food", R.drawable.gad," جاد اسكندرية"));
        restaurant.add(new Name("Mohamed Ahmed Restaurant  ", "beans and falafel", R.drawable.mohamed," مطعم محمد احمد فول وفلافل"));
        // Create an {@link NameAdapter}, whose data source is a list of {@link Name}s. Th
        // adapter knows how to create list items for each item in the list.
        // Create an {@link NameAdapter}, whose data source is a list of {@link Name}s. Th
        // adapter knows how to create list items for each item in the list.
        final custom adapter = new custom (this,restaurant,R.color.category_restaurants);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // Name_listrd_list.xml        ListView view = (ListView) findViewById(R.id.list);
        final ListView listview = (ListView) findViewById(R.id.list);




        // Make the {@link ListView} use the {@link NameAdapter} we created above, so that the

        // {@link ListView} will display list items for each {@link Name} in the list.
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long l) {
                Name m=restaurant.get(position);




                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query="+m.getGps());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }



            }
        });
        
    }
}
