package com.example.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public void tableCal(int j){
        ListView listView = findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<String>();
        int multiply=j;
        for(int i = 1;i<=10;i++){
            multiply=j*i;
            arrayList.add(j+" * "+i+" = "+multiply);
        }
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekSet);
        seekBar.setMax(9);
        seekBar.setProgress(1);
        tableCal(2);
        final TextView textView = (TextView) findViewById(R.id.textView);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("seek bar position", Integer.toString(progress));

                int progressNew;
                progressNew=progress+1;
                textView.setText("table of " +Integer.toString(progressNew));

                tableCal(progressNew);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
