package sg.edu.rp.c346.id22016635.song_l08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class songLV extends AppCompatActivity {

    ListView LV;

    Button btn5star;
    ArrayList<Song> al;
    //ArrayAdapter<Song>adapter;

    CustomAdapter adapter;
    @Override
    protected void onResume() {
        super.onResume();
        al  = new ArrayList<Song>();
      //  adapter = new ArrayAdapter<Song>(songLV.this,android.R.layout.simple_list_item_1,al);
        adapter = new CustomAdapter(this,R.layout.row,al);
        LV.setAdapter(adapter);

        Intent i = getIntent();
        DBHelper db = new DBHelper(songLV.this);
        al.clear();
        al.addAll(db.getSong());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_song_lv);

        btn5star = findViewById(R.id.btn5Star);
        LV = findViewById(R.id.LV);





        btn5star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(songLV.this);
                al.clear();
                String filterText = "*****";
                al.addAll(dbh.filterSongs(String.valueOf(filterText.length())));
                adapter.notifyDataSetChanged();
                
            }
        });
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Song data = al.get(position);
            Intent i = new Intent(songLV.this, EditSong.class);
            i.putExtra("_id", data);
            i.putExtra("title",data);
            i.putExtra("singer",data);
            i.putExtra("year",data);
            i.putExtra("star",data);
            startActivity(i);

        }
    });
    }

}