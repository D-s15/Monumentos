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

public class TourAdapter extends BaseAdapter {
    private List<Tour> tourList;
    private Context context;
    private Tour tour;
    private Monument monument;
    private MonumentDao monumentDao;

    public TourAdapter(Context context, List<Tour> tourList){
        this.tourList = tourList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tourList.size();
    }

    @Override
    public Tour getItem(int position) {
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
        Tour tour = this.getItem(position);

        TextView textViewGuidedTour = convertView.findViewById(R.id.textViewVisitaGuiada);
        TextView textViewMonumentNumber = convertView.findViewById(R.id.textViewMonumentsNumber);
        TextView textViewTourBeginning = convertView.findViewById(R.id.textViewtourBeginning);
        TextView textViewTourFinnish = convertView.findViewById(R.id.textViewtourFinnish);
        ImageView imageViewTourImage = convertView.findViewById(R.id.imageViewTourImage);
        Glide.with(this.context).load(tour.getTourImage()).apply(new RequestOptions().override(400,400)).into(imageViewTourImage);

        textViewGuidedTour.setText("Visita " + tour.getId());
        textViewMonumentNumber.setText("número de monumentos: " + tour.getNumberOfMonuments());
        textViewTourBeginning.setText("começo da visita: " + tour.getTourBeginning());
        textViewTourFinnish.setText("fim da visita: " + tour.getTourFinnish());
        return convertView;
    }
}
