package sg.edu.rp.c346.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView iv;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        iv = (ImageView) rowView.findViewById(R.id.iv);

        Holiday current = holiday.get(position);
        tvName.setText(current.getName());
        iv.setImageResource(current.getImage());
        tvDate.setText(current.getDate());

        return rowView;
    }


}
