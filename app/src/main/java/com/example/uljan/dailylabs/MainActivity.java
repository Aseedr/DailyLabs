package com.example.uljan.dailylabs;

import android.os.Bundle;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    String[] editT = { "", "", "", "", "", "", "", "", "", "", "", "" };
    String[] editLabs = { "Lab1", "Lab2", "Lab3", "Lab4", "Lab5", "Lab6" };
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView lvMain = (ListView) findViewById(R.id.main_list);
        lvMain.setOnItemClickListener(new OnItemClickListener() {
                                          public void onItemClick(AdapterView<?> parent, View view,
                                                                  int position, long id) {

                                              labs();

                                          }
                                      });
    // Example of a call to a native method
    //TextView tv = (TextView) findViewById(R.id.sample_text);
    //tv.setText(stringFromJNI());
    }

    public void buttonOnClick(View v){
        ListView lvMain = (ListView) findViewById(R.id.main_list);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, editT);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);
    }

    public void labs() {
        ListView lvMain = (ListView) findViewById(R.id.main_list);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, editLabs);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_1) {

            EditText editText = (EditText)findViewById(R.id.editText);
            editT[count] = editText.getText().toString();
            count++;
            ListView lvMain = (ListView) findViewById(R.id.main_list);

            // создаем адаптер
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, editT);

            // присваиваем адаптер списку
            lvMain.setAdapter(adapter);




            return true;
        }

        if (id == R.id.action_settings_2) {

            if (count > 0) {
                count--;
                editT[count] = "";
                ListView lvMain = (ListView) findViewById(R.id.main_list);

                // создаем адаптер
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, editT);

                // присваиваем адаптер списку
                lvMain.setAdapter(adapter);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
