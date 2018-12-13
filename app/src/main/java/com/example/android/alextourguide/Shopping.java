package com.example.android.alextourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namelist);
         final ArrayList<Name> shop = new ArrayList<Name>();
        shop.add(new Name("City Centre Alexandria", "", R.drawable.center,"City Centre Alexandria"));
        shop.add(new Name("Designia", "", R.drawable.des,"Designia, طريق الأسكندريه الصحراوي، قطاع الطريق الصحراوي، قسم العامرية"));
        shop.add(new Name("Green Plaza Mall", "", R.drawable.green,"Green Plaza Mall, طريق 14 مايو، سموحة، قسم سيدى جابر"));
        shop.add(new Name("zahran city mall", "", R.drawable.zhran,"zahran city mall"));
        shop.add(new Name("Carrefour", "", R.drawable.carf," Carrefour alex"));
        shop.add(new Name("Deeb Mall", " ", R.drawable.deeb,"Deeb Mall, سوريا، سيدي جابر، قسم سيدى جابر"));
        shop.add(new Name("Khair Zad Super Market", " ", R.drawable.khir," Khair Zad Super Market | Kafr Abdo | Alexandria"));
        shop.add(new Name("Adidas", "", R.drawable.adi," Adidas, طريق الجيش، سان استيفانو، قسم الرمل"));
        //shop.add(new Name(" ", "", R.drawable.,"  "));
        // Create an {@link NameAdapter}, whose data source is a list of {@link Name}s. Th
        // adapter knows how to create list items for each item in the list.
        final custom adapter = new custom (this,shop,R.color.category_shopping);
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
                Name m=shop.get(position);




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
