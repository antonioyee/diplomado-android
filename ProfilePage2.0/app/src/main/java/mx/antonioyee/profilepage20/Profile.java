package mx.antonioyee.profilepage20;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by antonioyee on 04/05/15.
 */
public class Profile {

    private String name;
    private String phone;
    private String twitter;
    private String email;
    private Drawable photo;

    public Profile(String name, String phone, String twitter, String email, Drawable photo) {
        this.name = name;
        this.phone = phone;
        this.twitter = twitter;
        this.email = email;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

}
