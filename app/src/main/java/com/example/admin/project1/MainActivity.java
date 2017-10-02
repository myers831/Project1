package com.example.admin.project1;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout dlLayout;
    private ListView lvList;
    String[] planets;
    private ActionBarDrawerToggle drawerListener;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        dlLayout = (DrawerLayout) findViewById(R.id.dlDrawer);
        lvList = (ListView) findViewById(R.id.lvList);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        planets = getResources().getStringArray(R.array.planets);
        lvList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));

        lvList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, planets[position] + " was selected", Toast.LENGTH_SHORT).show();
        //getSupportActionBar().setTitle(planets[position]);

        switch (position){
            case 0:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("title",planets[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent);
                break;

            case 1:
                Intent intent1 = new Intent(this, Main3Activity.class);
                intent1.putExtra("title",planets[position]);
                intent1.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent1);
                break;

            case 2:
                Intent intent2 = new Intent(this, Main4Activity.class);
                intent2.putExtra("title",planets[position]);
                intent2.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;

            case R.id.action_settings:
             // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
