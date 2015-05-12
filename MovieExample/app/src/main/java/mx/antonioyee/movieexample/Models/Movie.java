package mx.antonioyee.movieexample.Models;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by antonioyee on 11/05/15.
 */
public class Movie implements Serializable {

    private String title;
    private int year;
    private int criticScore;
    private int audienceScore;
    private String synopsis;
    private String urlThumb;
    private Bitmap bitmap;

    public Movie(String title, int year, int criticScore, int audienceScore, String synopsis, String urlThumb) {
        this.title = title;
        this.year = year;
        this.criticScore = criticScore;
        this.audienceScore = audienceScore;
        this.synopsis = synopsis;
        this.urlThumb = urlThumb;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCriticScore() {
        return criticScore;
    }

    public void setCriticScore(int criticScore) {
        this.criticScore = criticScore;
    }

    public int getAudienceScore() {
        return audienceScore;
    }

    public void setAudienceScore(int audienceScore) {
        this.audienceScore = audienceScore;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUrlThumb() {
        return urlThumb;
    }

    public void setUrlThumb(String urlThumb) {
        this.urlThumb = urlThumb;
    }

    public static ArrayList<Movie> parseJSON(String response){
        ArrayList<Movie> movies = new ArrayList<Movie>();

        try {

            JSONObject jsonObject = new JSONObject(response);
            JSONArray arrayMovies = jsonObject.getJSONArray("movies");

            for (int i=0; i < arrayMovies.length(); i++){

                JSONObject jsonMovie = arrayMovies.getJSONObject(i);

                String title =  jsonMovie.getString("title");

                int year =  jsonMovie.optInt("year", 1600);

                JSONObject jsonRating = jsonMovie.getJSONObject("ratings");
                int criticScore     =  jsonRating.optInt("critics_score");
                int audienceScore   =  jsonRating.optInt("audience_score");

                String synopsis =  jsonMovie.optString("synopsis", "UNKNOW");

                JSONObject jsonPosters = jsonMovie.getJSONObject("posters");
                String urlThumb =  jsonPosters.optString("thumbnail", null);

                Movie movie = new Movie(title, year, criticScore, audienceScore, synopsis, urlThumb);
                movies.add(movie);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return movies;
    }

}
