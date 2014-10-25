package com.mgm.sfotipy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int size = getResources().getDimensionPixelSize(R.dimen.fab_size);

        Outline outline = new Outline();

        outline.setOval(0, 0, size, size);

        ImageButton fab_1 = (ImageButton) findViewById(R.id.fab_1);
        fab_1.setOutline(outline);
    }

    public void getActivity(View view) {
        // Toast.makeText(this, "Hola estoy escuchando", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MyMusic.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
