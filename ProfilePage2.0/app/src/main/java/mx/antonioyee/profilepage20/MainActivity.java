package mx.antonioyee.profilepage20;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ImageView imgPhoto;
    TextView textName, textEmail, textPhone, textTwitter;
    Button btnBack, btnNext;
    ArrayList<Profile> profiles;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profiles = getData();

        imgPhoto = (ImageView) findViewById(R.id.ImgPhoto);

        textName = (TextView) findViewById(R.id.textName);
        textEmail = (TextView) findViewById(R.id.textEmail);
        textPhone = (TextView) findViewById(R.id.textPhone);
        textTwitter = (TextView) findViewById(R.id.textTwitter);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        loadData();
    }

    public void loadData(){
        Profile profile = profiles.get(position);

        imgPhoto.setImageDrawable(profile.getPhoto());

        textName.setText( profile.getName() );
        textEmail.setText( profile.getEmail() );
        textPhone.setText( profile.getPhone() );
        textTwitter.setText( profile.getTwitter() );
    }

    public ArrayList<Profile> getData(){
        ArrayList<Profile> profiles = new ArrayList<Profile>();

        profiles.add( new Profile("Ricardo Centeno","5514382887", "@rickstart", "ricardo.celj@gmail.com",getResources().getDrawable(R.mipmap.pic_ricardo)) );
        profiles.add(new Profile("Antonio Yee", "6671265734", "@antonioyee", "yee.antonio@gmail.com", getResources().getDrawable(R.mipmap.pic_yee) ));
        profiles.add( new Profile("Antonio Bastidas","6671033236", "@antbastidas", "joa_bastidas@outlook.com",getResources().getDrawable(R.mipmap.pic_antonio)) );
        return profiles;
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

    @Override
    public void onClick(View v) {
        switch ( v.getId() ){
            case R.id.btnBack:
                    if ( position > 0 ){
                        position--;
                        loadData();
                    }
                break;
            case R.id.btnNext:
                    if ( position < profiles.size() - 1 ){
                        position++;
                        loadData();
                    }
                break;
        }
    }
}
