package sg.edu.rp.c346.id22016635.song_l08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditSong extends AppCompatActivity {

    TextView selectID,tv1 , tv2, tv3, tv4, tv5;
    Button update, delete, cancel;
    EditText etTitle, etSinger, etYear;
    RadioGroup stars;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    Song id,title,singer,year,star;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        cancel = findViewById(R.id.btnCancel);

        tv1 = findViewById(R.id.tvSongID);
        tv2 = findViewById(R.id.tvSongTitle);
        tv3 = findViewById(R.id.tvSingers);
        tv4 = findViewById(R.id.tvYear);
        tv5 = findViewById(R.id.tvStars);

        selectID = findViewById(R.id.tvForID);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        stars = findViewById(R.id.starRG);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);

        Intent i = getIntent();
        //id TV
        id = (Song) i.getSerializableExtra("_id");
        selectID.setText(String.valueOf(id.getId()));

        //title ET
        title = (Song) i.getSerializableExtra("title");
        etTitle.setText(title.getTitle());

        //Singer ET
        singer = (Song) i.getSerializableExtra("singer");
        etSinger.setText(singer.getSingers());

        //Year ET
        year = (Song) i.getSerializableExtra("year");
        etYear.setText(String.valueOf(year.getYear()));

        star = (Song) i.getSerializableExtra("star");
        //tv1.setText(String.valueOf(star.getStars()));
        if(String.valueOf(star.getStars()).equalsIgnoreCase("1")){
            rb1.setChecked(true);
        }else if(String.valueOf(star.getStars()).equalsIgnoreCase("2")){
            rb2.setChecked(true);
        }else if(String.valueOf(star.getStars()).equalsIgnoreCase ("3")){
            rb3.setChecked(true);
        }else if(String.valueOf(star.getStars()).equalsIgnoreCase("4")){
            rb4.setChecked(true);
        }else if(String.valueOf(star.getStars()).equalsIgnoreCase("5")){
            rb5.setChecked(true);
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                String updTitle = String.valueOf(etTitle.getText());
                String updSinger = String.valueOf(etSinger.getText());
                int updYear = Integer.valueOf(etYear.getText().toString());
                int updStar = 0;

                int starRadioID = stars.getCheckedRadioButtonId();
                if(starRadioID == R.id.rb1){
                    updStar = 1;
                }else if(starRadioID == R.id.rb2){
                    updStar = 2;
                }else if(starRadioID == R.id.rb3){
                    updStar = 3;
                }else if(starRadioID == R.id.rb4){
                    updStar = 4;
                }else if(starRadioID == R.id.rb5){
                    updStar = 5;
                }

                title.setTitle(updTitle);
                singer.setSingers(updSinger);
                year.setYear(updYear);
                star.setStars(updStar);

                dbh.updateSong(title,singer,year,star);
                dbh.close();
                //Intent i = new Intent(EditSong.this,songLV.class);
                //startActivity(i);
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                dbh.deleteSong(id.getId());
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v) {
               onBackPressed();
            }
        });
    }
}