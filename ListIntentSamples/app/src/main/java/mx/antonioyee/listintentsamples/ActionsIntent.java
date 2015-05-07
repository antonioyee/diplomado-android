package mx.antonioyee.listintentsamples;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by antonioyee on 07/05/15.
 */
public class ActionsIntent {

    private String description;
    private Intent intent;
    private Drawable icon;

    public ActionsIntent(String description, Intent intent, Drawable icon) {
        this.description = description;
        this.intent = intent;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public static ArrayList<ActionsIntent> getData(Context context){

        ArrayList<ActionsIntent> actions = new ArrayList<ActionsIntent>();


        Intent intentCall = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:(521) 5514382887"));
        intentCall.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ActionsIntent action = new ActionsIntent("Llamar",intentCall,context.getResources().getDrawable(R.mipmap.ic_phone));

        actions.add(action);


        Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
        intentEmail.setType("text/plain");
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject of email");
        intentEmail.putExtra(Intent.EXTRA_TEXT, "Body of email");
        intentEmail.setData(Uri.parse("mailto:ricardo.celj@gmail.com"));
        intentEmail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        actions.add(new ActionsIntent("Enviar Email",intentEmail,context.getResources().getDrawable(R.mipmap.ic_email)));

        Intent intentBrowser = new Intent(Intent.ACTION_VIEW);
        intentBrowser.setData(Uri.parse("http://www.github.com"));
        intentBrowser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        actions.add(new ActionsIntent("Abrir GitHub",intentBrowser,context.getResources().getDrawable(R.mipmap.ic_browser)));

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentCamera.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        actions.add(new ActionsIntent("Tomar Foto",intentCamera,context.getResources().getDrawable(R.mipmap.ic_camara)));

        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("text/plain");
        intentShare.putExtra(android.content.Intent.EXTRA_SUBJECT, "ETSTSTS");
        intentShare.putExtra(android.content.Intent.EXTRA_TEXT, "Example text");
        intentShare.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        actions.add(new ActionsIntent("Compartir",intentShare,context.getResources().getDrawable(R.mipmap.ic_compartir)));

        Intent intentActivity = new Intent(context, SecondActivity.class);
        intentActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        actions.add(new ActionsIntent("Cambiar de Pantalla",intentActivity,context.getResources().getDrawable(R.mipmap.ic_pantalla)));

        Intent intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=antonioyee"));
        actions.add(new ActionsIntent("Abrir en Twitter",intentTwitter,context.getResources().getDrawable(R.mipmap.ic_twitter)));

        return actions;

    }

}
