package funix.prm.prm391x_project3_huannhfx02928;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class BaoThucAdapter extends BaseAdapter { // Custom adapter trong listView

    private final MainActivity context;
    private final int itemLayout;
    private final ArrayList<BaoThuc> baoThucList;

    public BaoThucAdapter(MainActivity context, int itemLayout, ArrayList<BaoThuc> baoThucList) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.baoThucList = baoThucList;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = LayoutInflater.from(context).inflate(itemLayout, parent, false);
        }

        BaoThuc baoThuc = baoThucList.get(position);

        ((TextView) view.findViewById(R.id.tv_ten_bao_thuc)).setText(baoThuc.getName());

        int hour = baoThuc.getHour();
        int minute = baoThuc.getMinute();
        String thoiGian; // Lấy chuỗi thời gian người dùng chọn Sa hay Ch
        if (hour < 12) {
            thoiGian = String.format("%02d:%02d SA", hour, minute);
        } else {
            thoiGian = String.format("%02d:%02d CH", (hour - 12), minute);
        }
        ((TextView) view.findViewById(R.id.tv_thoi_gian)).setText(thoiGian);

        ToggleButton tb = view.findViewById(R.id.toggle);
        tb.setChecked(baoThuc.isEnabled());
        final int pos = position;
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                context.onToggleItem(pos, isChecked);
            }
        });

        view.findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.onAddOrEditClick(pos);
            }
        });

        view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.onDeleteClick(pos);
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return baoThucList.size();
    }

    @Override
    public Object getItem(int position) {
        return baoThucList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return baoThucList.get(position).getId();
    }
}
