package mx.antonioyee.girlsappfragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class GirlDetailFragment extends Fragment {

    private static final String ARG_PARAM_POSITION = "param_position";
    private int mPosition;
    private ImageView imgPhoto;
    private TextView textName;
    private ImageButton btnLink;
    private ArrayList<Girld> girls;
    private Girld girl;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GirlDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GirlDetailFragment newInstance(int mPosition) {
        GirlDetailFragment fragment = new GirlDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_POSITION, mPosition);
        fragment.setArguments(args);
        return fragment;
    }

    public GirlDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_PARAM_POSITION);
        }

        girls = Girld.getData(getActivity());
        girl = girls.get(mPosition);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_girl_detail, container, false);

        imgPhoto = (ImageView) rootView.findViewById(R.id.imgPhoto);
        textName = (TextView) rootView.findViewById(R.id.textName);
        btnLink = (ImageButton) rootView.findViewById((R.id.btnLink));

        imgPhoto.setImageDrawable(girl.getPicture());;
        textName.setText(girl.getName());

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(girl.getLink()));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
