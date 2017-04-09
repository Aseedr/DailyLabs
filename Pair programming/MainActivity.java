package com.example.irina.recipebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, d.getName() + d.getType(), Toast.LENGTH_LONG).show();

        System.out.println("Reading all labs");
        Dairy dairy = getAllLabs();
        for (Dairy cn : lab) {
            Toast.makeText(MainActivity.this, cn.getName(), Toast.LENGTH_LONG).show();;
        }
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

        switch (id) {
            case R.id.action_settings: {
                Intent intent = new Intent(MainActivity.this, FindRecipeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.action_item1: {

                Intent intent = new Intent(MainActivity.this, FridgeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.action_item2: {
                Intent intent = new Intent(MainActivity.this, FavoriteRecipeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.action_item3: {
                Intent intent = new Intent(MainActivity.this, ShoppingListActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, getString(R.string.action_item3), Toast.LENGTH_LONG).show();
            }
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.lab :{
                changeActivity("1");
            }
            break;
            case R.id.lab:{
                changeActivity("2");
            }
            break;
            case R.id.lab:{
                changeActivity("3");
            }
            break;
            case R.id.lab:{
                changeActivity"4");
            }
            break;
            case R.id.lab {
                changeActivity("5");
            }
            break;
            case R.id.lab{
                changeActivity("6");
            }
            break;
            case R.id.lab{
                changeActivity("7");
            }
            break;
           case R.id.lab{
                changeActivity("8");
            }
            break;
            case R.id.lab {
                changeActivity("9");
            }
            break;
        }
    }

    public void changeActivity(String type){
        // Go to new window
        Intent intent = new Intent(MainActivity.this, ShowRecipeActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}