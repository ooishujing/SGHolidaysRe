package sg.edu.rp.c346.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvType);
        ArrayList<String> typeArray = new ArrayList<>();
        typeArray.add("Secular");
        typeArray.add("Ethnic & Religion");

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, typeArray);
        lv.setAdapter(aa);

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String holiday = typeArray.get(position);
               Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
               intent.putExtra("title", holiday);
               startActivity(intent);
           }
       });
    }

}