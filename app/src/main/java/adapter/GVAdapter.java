package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cxria.ndkapplication.R;

/**
 * Created by yukun on 17-9-19.
 */

public class GVAdapter extends BaseAdapter{
    Context mContext;
    String[] mList;
    public GVAdapter(Context context) {
        mContext = context;
        mList=mContext.getResources().getStringArray(R.array.number);
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(mContext).inflate(R.layout.layout_item,null);
        TextView textView= (TextView) convertView.findViewById(R.id.tv_num);
        textView.setText(mList[position]);
        return convertView;
    }
}
