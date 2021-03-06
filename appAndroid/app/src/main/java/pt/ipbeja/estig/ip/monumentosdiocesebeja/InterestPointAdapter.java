package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class InterestPointAdapter extends BaseAdapter {
    private List<InterestPoint> interestPointList = new ArrayList<>();
    private Context context;

    public InterestPointAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return interestPointList.size();
    }

    @Override
    public InterestPoint getItem(int position) {
        return this.interestPointList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.interest_point_row, parent, false);
        }

        InterestPoint interestPoint = this.getItem(position);

        TextView textViewInterestPoint = convertView.findViewById(R.id.textViewInterestPoint);
        textViewInterestPoint.setText(interestPoint.getInterestPointName());
        ImageView imageViewFavourite = convertView.findViewById(R.id.imageViewfavourite);

        imageViewFavourite.setVisibility(interestPoint.isSeen() ? View.VISIBLE : View.INVISIBLE);

        return convertView;
    }

    public void updateList(List<InterestPoint> newList){
        this.interestPointList = newList;
        notifyDataSetChanged();
        }
    }
