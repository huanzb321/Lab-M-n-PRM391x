package funix.prm.prm391x_project2_huannhfx02928;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context mContent;
    private int layout;
    List<Item> itemList;
    private int mImage [];
    private LayoutInflater mInflater;

    public CustomAdapter (Context applicationContext, int layout, List<Item> listItem, int [] image) {
        this.mContent = applicationContext;
        this.layout = layout;
        this.itemList = listItem;
        this.mImage = image;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        mInflater = (LayoutInflater.from(mContent));
        view = mInflater.inflate(layout, null);
        TextView txt1 = view.findViewById(R.id.textView);
        ImageView icon = view.findViewById(R.id.icon);
        Item item = itemList.get(position);
        txt1.setText(item.getName());
        icon.setImageResource(mImage[position]);
        return view;
    }
}
