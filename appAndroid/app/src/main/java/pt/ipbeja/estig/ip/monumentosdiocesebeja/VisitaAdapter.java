package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.List;

public class VisitaAdapter extends BaseAdapter {
    private List<Visita> tourList;
    private Context context;

    public VisitaAdapter(Context context, List<Visita> tourList){
        this.tourList = tourList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tourList.size();
    }

    @Override
    public Visita getItem(int position) {
        return this.tourList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.guided_tour_row, parent, false);
        }
        Visita visita = this.getItem(position);

        TextView textViewGuidedTour = convertView.findViewById(R.id.textViewVisitaGuiada);
        TextView textViewMonumentNumber = convertView.findViewById(R.id.textViewMonumentsNumber);
        TextView textViewTourBeginning = convertView.findViewById(R.id.textViewtourBeginning);
        TextView textViewTourFinnish = convertView.findViewById(R.id.textViewtourFinnish);
        ImageView imageViewTourImage = convertView.findViewById(R.id.imageViewTourImage);
        if (!visita.getTourImage().isEmpty()) Glide.with(this.context).load(visita.getTourImage()).apply(new RequestOptions().override(600, 250)).into(imageViewTourImage);
        textViewGuidedTour.setText("Visita " + visita.getId());
        textViewMonumentNumber.setText("número de monumentos: " + visita.getNumberOfMonuments());
        textViewTourBeginning.setText("começo da visita: " + visita.getTourBeginning());
        textViewTourFinnish.setText("fim da visita: " + visita.getTourFinnish());
        return convertView;
    }
}
