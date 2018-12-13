package com.example.android.alextourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namelist);


          final    ArrayList<Name> hotel = new ArrayList<Name>();
        hotel.add(new Name("Four Seasons ", "The Army Road, San Stefano, Department of Sand, Alexandria", R.drawable.hotels_four,"Four Seasons Hotel Alexandria at San Stefano, Egypt"));
        hotel.add(new Name("hilton", "544 El Guish Rd., Sidi Beshr Bahri, Department of Montazah, Alexandria", R.drawable.hotels_hiliton,"Hilton Alexandria Corniche"));
        hotel.add(new Name("Semiramis", "82 El Corniche Rd. Raml Station, Alexandria, Egypt", R.drawable.hotels_smirames,"Semiramis Hotel"));
        hotel.add(new Name("Steigenberger Cecil ", "16 Saad Zaghloul Square، Corniche Road,Alexandria", R.drawable.hotels_sesel,"Steigenberger Cecil Alexandria"));
        hotel.add(new Name("Romance", "303 Tareek El Gueish Saba Pasha, Alexandria", R.drawable.hotels_romans,"Romance Alexandria Corniche"));
        hotel.add(new Name("Sheraton montazah", "Corniche Road, Mandara Bahri, Department of Park, Alexandria", R.drawable.hotels_sheraton_elmontzah,"Sheraton Montazah Hotel"));
        hotel.add(new Name("Tolip", "Army Road, Mostafa Kamel and Bolkly, Department of Sidi Gaber, Alexandria", R.drawable.hotels_tolib,"TOLIP Hotel Alexandria"));
        hotel.add(new Name("Cherry Maryski", "9 Mohamed Farid Street, Massala West and Sharif Pasha, Department of Attarin, Alexandria", R.drawable.hotels_cherry_maryski,"Cherry Maryski Hotel"));
        hotel.add(new Name("Royal Crown", "160 El Guish Road, Cleopatra, Alexandria", R.drawable.hotels_royal_crown,"Royal Crown Hotel, سيدي جابر، قسم سيدى جابر"));
        // Create an {@link NameAdapter}, whose data source is a list of {@link Name}s. Th
        // adapter knows how to create list items for each item in the list.
        final custom adapter = new custom (this,hotel,R.color.category_hotels);
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
                Name m=hotel.get(position);




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
