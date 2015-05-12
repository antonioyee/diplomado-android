package mx.antonioyee.movieexample.fragments;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.antonioyee.movieexample.Models.Movie;
import mx.antonioyee.movieexample.R;

public class DetailMovieFragment extends Fragment {

    private static final String ARG_PARAM_MOVIE = "movieParam";
    private Movie movie;
    private Bitmap bitmap;
    private ImageView imgPoster;
    private TextView textTitleDetail, textSynopsis;
    RatingBar ratingBarAudience, ratingBarCritic;

    public static DetailMovieFragment newInstance(Movie movie) {
        DetailMovieFragment fragment = new DetailMovieFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.movie = (Movie) getArguments().getSerializable(ARG_PARAM_MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.fragment_detail_movie, container, false);

        imgPoster       = (ImageView) viewRoot.findViewById(R.id.imgPoster);
        textTitleDetail = (TextView) viewRoot.findViewById(R.id.textTitleDetail);
        textSynopsis    = (TextView) viewRoot.findViewById(R.id.textSynopsis);
        ratingBarAudience = (RatingBar) viewRoot.findViewById(R.id.ratingBarAudience);
        ratingBarCritic = (RatingBar) viewRoot.findViewById(R.id.ratingBarCritic);

        double rating1 = movie.getAudienceScore()*0.01*5;
        double rating2 = movie.getCriticScore()*0.01*5;

        ratingBarAudience.setRating((float) rating1);
        ratingBarCritic.setRating((float) rating2);

        String urlPoster = movie.getUrlThumb().replace("tmb", "ori");
        Picasso.with(getActivity()).load(urlPoster).into(imgPoster);
        textTitleDetail.setText(movie.getTitle());
        textSynopsis.setText(movie.getSynopsis());

        return viewRoot;
    }

}
