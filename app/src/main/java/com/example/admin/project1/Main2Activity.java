package com.example.admin.project1;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout dlLayout;
    private ListView lvList;
    String[] planets;
    private ActionBarDrawerToggle drawerListener;
    private Toolbar myToolbar;
    private static TextView tv;
    private static SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        dlLayout = (DrawerLayout) findViewById(R.id.dlDrawer2);
        lvList = (ListView) findViewById(R.id.lvList2);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String title = getIntent().getExtras().getString("title");

        getSupportActionBar().setTitle(title);

        planets = getResources().getStringArray(R.array.planets);
        lvList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));

        lvList.setOnItemClickListener(this);

        seekBar();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, planets[position] + " was selected", Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle(planets[position]);

        switch (position){
            case 0:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("title",planets[position]);
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

    public void seekBar(){

        tv = (TextView) findViewById(R.id.textView);
        sb = (SeekBar) findViewById(R.id.seekBar);

        tv.setText("Covered : " + sb.getProgress() + " / " + sb.getMax());



        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                tv.setText("Covered : " + progress + " / " + sb.getMax());
                Toast.makeText(Main2Activity.this, "SeekBar in progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


                Toast.makeText(Main2Activity.this, "SeekBar Start Tracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText("Covered : " + progressValue + " / " + sb.getMax());

                Toast.makeText(Main2Activity.this, "SeekBar Stop Tracking", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
