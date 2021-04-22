package sg.edu.rp.c346.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    TextView title;
    ArrayAdapter aa;
    ArrayList<Holiday> holidayS, holidayR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView) this.findViewById(R.id.lv);
        title = (TextView) this.findViewById(R.id.textView);

        Intent intentRecieved = getIntent();
        String holidayTypes = intentRecieved.getStringExtra("title");
        title.setText(holidayTypes);




        holidayS = new ArrayList<Holiday>();
        holidayS.add(new Holiday("New Year's Day", R.drawable.n ,"1 Jan 2017"));
        holidayS.add(new Holiday("Labour Day", R.drawable.l ,"1 May 2017"));
        holidayR = new ArrayList<Holiday>();
        holidayR.add(new Holiday("Chinese New Year", R.drawable.n ,"28-29 Jan 2017"));
        holidayR.add(new Holiday("Good Friday", R.drawable.n ,"14 April 2017"));
        if(holidayTypes.equals("Secular")){
            aa = new HolidayAdapter(this, R.layout.row, holidayS);
        }else{
            aa = new HolidayAdapter(this, R.layout.row, holidayR);
        }

        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(holidayTypes.equals("Secular")){
                    Holiday selectedHoliday = holidayS.get(position);
                    Toast.makeText(SecondActivity.this, selectedHoliday.getName()
                                    + ": " + selectedHoliday.getDate(),
                            Toast.LENGTH_LONG).show();
                }else{
                    Holiday selectedHoliday = holidayR.get(position);
                    Toast.makeText(SecondActivity.this, selectedHoliday.getName()
                                    + ": " + selectedHoliday.getDate(),
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}