package sg.edu.rp.c346.id22016635.song_l08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4;
    EditText et1,et2,et3;

    Button btnInsert, btnList;


    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);

        rg = findViewById(R.id.rgStar);

        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int checkedID = rg.getCheckedRadioButtonId();
                RadioButton button = rg.findViewById(checkedID);
                int stars = Integer.parseInt(button.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);
                db.insertSong(et1.getText().toString(), et2.getText().toString(),Integer.parseInt(et3.getText().toString()) , stars);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), songLV.class);
                startActivity(i);
                DBHelper db = new DBHelper(MainActivity.this);
                db.close();


            }
        });

    }
}