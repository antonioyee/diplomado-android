package mx.antonioyee.listintentsamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by antonioyee on 07/05/15.
 */
public class ActionsIntentAdapter extends ArrayAdapter {

    ArrayList<ActionsIntent> array;
    private Context context;


    public ActionsIntentAdapter(Context context, int resource, ArrayList<ActionsIntent> array) {
        super(context, resource, array);
        this.array = array;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rootView = inflater.inflate(R.layout.item_list_intent, parent, false);

        ViewHolder holder = new ViewHolder();

        holder.textDescripcion = (TextView) rootView.findViewById(R.id.textDescription);
        holder.btnAction = (ImageButton) rootView.findViewById((R.id.btnAction));

        holder.textDescripcion.setText(array.get(position).getDescription());
        holder.btnAction.setImageDrawable(array.get(position).getIcon());

        holder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(array.get(position).getIntent());
            }
        });

        return rootView;
    }

    class ViewHolder {
        TextView textDescripcion;
        ImageButton btnAction;
    }

}
