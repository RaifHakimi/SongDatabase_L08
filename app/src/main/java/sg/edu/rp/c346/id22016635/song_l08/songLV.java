package sg.edu.rp.c346.id22016635.song_l08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class songLV extends AppCompatActivity {

    ListView LV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper db = new DBHelper(songLV.this);
        setContentView(R.layout.activity_song_lv);


        LV = findViewById(R.id.LV);
        ArrayList al  = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<>(songLV.this,android.R.layout.simple_list_item_1,al);
        LV.setAdapter(adapter);



        al.addAll(db.getSong());
        adapter.notifyDataSetChanged();
        db.close();
    }
}