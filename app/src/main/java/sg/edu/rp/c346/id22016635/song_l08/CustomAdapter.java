package sg.edu.rp.c346.id22016635.song_l08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id ;
    ArrayList<Song> versionList = new ArrayList<Song>();

    public CustomAdapter(Context parent_context,int resource, ArrayList<Song> Object){
        super(parent_context,resource,Object);
        this.parent_context = parent_context;
        this.layout_id = resource;
        this.versionList = Object;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvprintYear);
        TextView tvStar = rowView.findViewById(R.id.tvStarprint);
        TextView tvSinger = rowView.findViewById(R.id.tvSingername);

        // Obtain the Android Version information based on the position
        Song currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvYear.setText(String.valueOf(currentVersion.getYear()));
        tvStar.setText(currentVersion.toString());
        tvSinger.setText(currentVersion.getSingers());
        return rowView;
    }

}
