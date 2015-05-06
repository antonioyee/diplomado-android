package mx.antonioyee.listviewfirstexample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by antonioyee on 06/05/15.
 */
public class ImageTextAdapter extends ArrayAdapter {

    ArrayList<Profile> array;
    private Context context;

    public ImageTextAdapter(Context context, int resource, ArrayList<Profile> array) {
        super(context, resource, array);

        this.array = array;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rootView = inflater.inflate(R.layout.simple_list_item_1, parent, false);
        ViewHolder holder = new ViewHolder();

        holder.text1 = (TextView) rootView.findViewById(R.id.text1);
        holder.textEMail = (TextView) rootView.findViewById(R.id.textEmail);
        holder.imgthumbnail = (ImageView) rootView.findViewById(R.id.imgthumbnail);
        holder.text1.setText(array.get(position).getName());
        holder.textEMail.setText(array.get(position).getEmail());
        holder.imgthumbnail.setImageDrawable(array.get(position).getPhoto());

        return rootView;
    }

    class ViewHolder {
        TextView text1;
        TextView textEMail;
        ImageView imgthumbnail;
    }
}
