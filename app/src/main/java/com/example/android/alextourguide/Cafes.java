package com.example.android.alextourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Cafes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namelist);



        final ArrayList<Name> cafe = new ArrayList<Name>();
        cafe.add(new Name("starbucks Cafe", "", R.drawable.star,"Starbucks Coffee, سان ستفانو، Alexandria"));
        cafe.add(new Name("Carlos Cafe", "", R.drawable.carlo,"Starbucks Coffee, سان ستفانو، Alexandria"));
        cafe.add(new Name("Owl Café Espanyol", "", R.drawable.olia,"اوليه كافيه اسبانيول"));
        cafe.add(new Name("Grand Cafe  ", "", R.drawable.grand,"جراند كافيه، حسين باشا عاصم، المزار، قسم الجمرك"));
        cafe.add(new Name("Brazilian Coffee ", "", R.drawable.barzil    ," محلات البن البرازيلى، شارع صلاح سالم، Al Munhsiyah، قسم العطارين"));
        cafe.add(new Name("sol Cafe", " ", R.drawable.sol,"Sol Cafe, كوبرى استانلى، فلمنج، قسم سيدى جابر"));
        cafe.add(new Name("Opa Cafe", " ", R.drawable.lopa,"Opa cafe alex"));
        cafe.add(new Name("Santos Cafe", "", R.drawable.san," Santo Cafe, المندرة بحري، قسم المنتزه"));
        cafe.add(new Name("Hammock Cafe", "", R.drawable.hams," Hammock Cafe, أبيس، قسم محرم بك"));
        // Create an {@link NameAdapter}, whose data source is a list of {@link Name}s. Th
        // adapter knows how to create list items for each item in the list.
        final custom adapter = new custom (this,cafe,R.color.category_Cafes);
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
                Name m=cafe.get(position);




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
