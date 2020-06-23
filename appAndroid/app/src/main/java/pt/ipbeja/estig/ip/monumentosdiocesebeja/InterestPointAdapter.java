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

public class InterestPointAdapter extends BaseAdapter {
    private List<InterestPoint> interestPointList;
    private Context context;

    public InterestPointAdapter(List<InterestPoint> interestPointList, Context context) {
        this.interestPointList = interestPointList;
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
        return convertView;
    }
}
