package mx.antonioyee.listviewfirstexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView listNames;
    ImageTextAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> names = new ArrayList<String>();

        names.add("Carlos");
        names.add("Yee");
        names.add("Ricardo");
        names.add("Antonio");

        ArrayList<Profile> profiles = new ArrayList<Profile>();
        profiles.add( new Profile("Ricardo Centeno","5514382887", "@rickstart", "ricardo.celj@gmail.com",getResources().getDrawable(R.mipmap.pic_ricardo)) );
        profiles.add(new Profile("Antonio Yee", "6671265734", "@antonioyee", "yee.antonio@gmail.com", getResources().getDrawable(R.mipmap.pic_yee) ));
        profiles.add( new Profile("Antonio Bastidas","6671033236", "@antbastidas", "joa_bastidas@outlook.com",getResources().getDrawable(R.mipmap.pic_antonio)) );

        listNames = (ListView) findViewById(R.id.listNames);
        adapter = new ImageTextAdapter(getApplicationContext(),R.layout.simple_list_item_1,profiles);

        listNames.setAdapter(adapter);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
