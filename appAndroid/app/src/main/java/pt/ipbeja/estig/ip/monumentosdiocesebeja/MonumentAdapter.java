package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonumentAdapter extends BaseAdapter {
    private List<Monument> monumentList;
    private Context context;

    public MonumentAdapter(List<Monument> monumentList, Context context) {
        this.monumentList = monumentList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return monumentList.size();
    }

    @Override
    public Monument getItem(int position) {
        return this.monumentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.monument_row, parent, false);
        }

        Monument monument = this.getItem(position);

        TextView textViewMonumentName = convertView.findViewById(R.id.textViewMonumentName);
        ImageView imageViewMonumentImage = convertView.findViewById(R.id.imageViewMonumentImage);

        textViewMonumentName.setText(monument.getMonumentName());
        //imageViewMonumentImage.setImageResource();
        return convertView;
    }
}
