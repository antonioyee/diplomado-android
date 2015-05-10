package mx.antonioyee.girlsappfragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListGirlsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListGirlsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListGirlsFragment extends Fragment {

    private static final String ARG_ARRAY = "arg_array";

    private ArrayList<String> mArray;
    private ListView listGirls;
    private ArrayAdapter adapter;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static ListGirlsFragment newInstance(ArrayList<String> mArray) {
        ListGirlsFragment fragment = new ListGirlsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ARRAY, mArray);
        fragment.setArguments(args);
        return fragment;
    }

    public ListGirlsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mArray = (ArrayList<String>) getArguments().getSerializable(ARG_ARRAY);

        } else {
            this.mArray = Girld.getDataString(getActivity());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_girls, container, false);

        listGirls = (ListView) rootView.findViewById(R.id.listGirls);

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mArray);

        listGirls.setAdapter(adapter);

        listGirls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if ( mListener != null ) {
                    mListener.onGirlSelected(position);
                }
            }
        });

        return rootView;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onGirlSelected(int position);
    }

}
