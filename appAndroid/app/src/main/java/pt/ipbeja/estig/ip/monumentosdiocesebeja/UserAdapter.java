package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<User> userlist;
    private UserDao userDao;
    private User user;

    public void userAdapter(Context context, List<User> userlist){
        this.context = context;
        this.userlist = userlist;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Override
    public User getItem(int position) {
        return userlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = this.getItem(position);

        EditText editTextCreateEmail = convertView.findViewById(R.id.editTextRegisterEmail);
        EditText editTextCreatePassword = convertView.findViewById(R.id.editTextRegisterPassword);
        return convertView;
    }
}
