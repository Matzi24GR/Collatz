package com.example.geomatmatzi.collatz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        final NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberpicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(999999999);
        numberPicker.setWrapSelectorWheel(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        final TextView textView = (TextView) findViewById(R.id.textView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = numberPicker.getValue();
                ArrayList<Integer> list = new ArrayList();
                int i = 0;
                while (x != 1) {
                    if (x % 2 == 0) {
                        i++;
                        x = x / 2;
                        Log.v("even",Integer.toString(x));
                        Log.v("even",Integer.toString(i));
                        list.add(new Integer(x));
                    } else {
                        i++;
                        x = 3 * x + 1;
                        Log.v("odd",Integer.toString(x));
                        Log.v("odd",Integer.toString(i));
                        list.add(new Integer(x));
                    }
                }

                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                listView.setAdapter(arrayAdapter);
                int max = Collections.max(list);
                String maxS = NumberFormat.getInstance().format(max);
                textView.setText(i + " / "+ maxS);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
