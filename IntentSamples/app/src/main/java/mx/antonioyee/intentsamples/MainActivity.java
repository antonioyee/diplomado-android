package mx.antonioyee.intentsamples;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ImageButton btnCall, btnCamara, btnEmail, btnFB, btnBrowser, btnPantalla, btnCompartir;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (ImageButton) findViewById(R.id.btnCall);
        btnCamara = (ImageButton) findViewById(R.id.btnCamara);
        btnEmail = (ImageButton) findViewById(R.id.btnEmail);
        btnFB = (ImageButton) findViewById(R.id.btnFB);
        btnBrowser = (ImageButton) findViewById(R.id.btnBrowser);
        btnPantalla = (ImageButton) findViewById(R.id.btnPantalla);
        btnCompartir = (ImageButton) findViewById(R.id.btnCompartir);

        btnCall.setOnClickListener(this);
        btnCamara.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnFB.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
        btnPantalla.setOnClickListener(this);
        btnCompartir.setOnClickListener(this);
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
        switch ( v.getId() ) {
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(667) 7572172"));

                startActivity(intent);
                break;

            case R.id.btnCamara:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivity(intent);
                break;

            case R.id.btnEmail:
                intent = new Intent(Intent.ACTION_SEND,
                        Uri.fromParts(
                                "mailto", "yee.antonio@gmail.com", null));

                intent.putExtra(Intent.EXTRA_SUBJECT, "TITULO CORREO");
                intent.putExtra(Intent.EXTRA_TEXT, "CUERPO DEL CORREO");
                intent.setData(Uri.parse("mailto:yee.antonio@gmail.com"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                break;

            case R.id.btnFB:
               /* intent = new Intent("android.intent.category.LAUNCHER");
                intent.setClassName("com.twitter.android", "0");

                startActivity(intent);*/

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=antonioyee"));
                startActivity(intent);
                break;

            case R.id.btnBrowser:
                intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("http://antonioyee.mx"));

                startActivity(intent);
                break;

            case R.id.btnPantalla:
                //intent = new Intent(this, SecondActivity.class);
                //startActivity(intent);
                break;

            case R.id.btnCompartir:
                intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "AAAA");
                intent.putExtra(Intent.EXTRA_TEXT, "bbbb");

                startActivity(intent);
                break;
        }
    }
}
