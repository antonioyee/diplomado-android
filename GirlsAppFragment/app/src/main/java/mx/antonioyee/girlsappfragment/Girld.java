package mx.antonioyee.girlsappfragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by antonioyee on 09/05/15.
 */
public class Girld {

    private String name;
    private Drawable picture;
    private String link;

    public Girld(String name, Drawable picture, String link) {
        this.name = name;
        this.picture = picture;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static ArrayList<Girld> getData(Context context){
        ArrayList<Girld> girl= new ArrayList<Girld>();

        girl.add(new Girld("EMMA STONE", context.getResources().getDrawable(R.mipmap.emma_stone), "http://www.emma-stone.org/"));
        girl.add(new Girld("CAMILA SODI", context.getResources().getDrawable(R.mipmap.camila_sodi), "http://www.camilasodionline.com/"));
        girl.add(new Girld("CERSEI LANNISTER", context.getResources().getDrawable(R.mipmap.cersei_lannister), "http://gameofthrones.wikia.com/wiki/Cersei_Lannister"));
        girl.add(new Girld("DANERIS TANGERIAN - KHALESSI", context.getResources().getDrawable(R.mipmap.khalessi), "http://gameofthrones.wikia.com/wiki/Daenerys_Targaryen"));
        girl.add(new Girld("MELISANDRE", context.getResources().getDrawable(R.mipmap.melisandre), "http://gameofthrones.wikia.com/wiki/Melisandre"));

        return girl;
    }

    public static ArrayList<String> getDataString(Context context){
        ArrayList<String> girlsName = new ArrayList<String>();

        ArrayList<Girld> girls = getData(context);

        for (int i = 0; i < girls.size(); i++){
            girlsName.add(girls.get(i).getName());
        }

        return girlsName;
    }

}
