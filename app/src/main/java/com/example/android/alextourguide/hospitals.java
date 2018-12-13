package com.example.android.alextourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class hospitals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namelist);
        final ArrayList<Name> hospita = new ArrayList<Name>();
        hospita.add(new Name("Louran hospital", "", R.drawable.lauran,"مستشفى لوران"));
        hospita.add(new Name("Alexandria International Hospital", "", R.drawable.official,"مستشفى الإسكندرية الدولي"));
        hospita.add(new Name("Andalusia Hospital Smouha", "", R.drawable.andalos,"مستشفي أندلسية سموحة"));
        hospita.add(new Name("Beit El - Naama Hospital", "", R.drawable.naema,"مستشفى بيت النعمة"));
        hospita.add(new Name("City Hospital for Women", "", R.drawable.mdina,"مستشفى المدينة للمرأة"));
        hospita.add(new Name("Al-Badrawi Hospital", " ", R.drawable.badra,"مستشفي البدراوي"));
        hospita.add(new Name("Al Ahly Hospital", " ", R.drawable.ahli," Al Ahly Hospital، الدكتور برجي، أبو النواتير، قسم سيدى جابر"));
        hospita.add(new Name("German Military Hospital", "", R.drawable.german," المستشفى الألماني العسكري"));
        hospita.add(new Name("Royal Hospital", "", R.drawable.royal," مستشفى الملكي، أبو النواتير، Qesm Sidi Gaber"));
        // Create an {@link NameAdapter}, whose data source is a list of {@link Name}s. Th
        // adapter knows how to create list items for each item in the list.
        final custom adapter = new custom (this,hospita,R.color.category_hospitals);
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
                Name m=hospita.get(position);




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
