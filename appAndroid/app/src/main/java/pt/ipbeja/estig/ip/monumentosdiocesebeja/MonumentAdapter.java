package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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
        return this.monumentList.size();
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
        ImageView imageViewMonumentImage = convertView.findViewById(R.id.imageViewMonumentsImage);
        if (!monument.getMonumentImage().isEmpty()) Glide.with(this.context).load(monument.getMonumentImage()).apply(new RequestOptions().override(500, 500)).into(imageViewMonumentImage);
        textViewMonumentName.setText(monument.getMonumentName());
        return convertView;
    }

    public void updateList(List<Monument> newList) {
        this.monumentList = newList;
        this.notifyDataSetChanged();
    }
}
