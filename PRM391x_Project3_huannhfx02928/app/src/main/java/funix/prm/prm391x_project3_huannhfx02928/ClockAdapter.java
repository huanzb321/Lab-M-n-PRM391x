package funix.prm.prm391x_project3_huannhfx02928;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ClockAdapter extends BaseAdapter {
    Alarm alarm;
    private final ArrayList<Alarm> alarmList;
    private final MainActivity context;
    private final int itemLayout;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param alarmList the set of alarm clock.
     */
    public ClockAdapter(MainActivity context, int itemLayout, ArrayList<Alarm> alarmList) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.alarmList = alarmList;
    }

    @Override
    public int getCount() {
        return alarmList.size();
    }

    @Override
    public Object getItem(int position) {
        return alarmList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alarmList.get(position).getId();
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = LayoutInflater.from(context).inflate(itemLayout, parent, false);
        }

        alarm = alarmList.get(position);

        ((TextView) view.findViewById(R.id.name_alarm)).setText(alarm.getName());

        int hours = alarm.getHours();
        int minutes = alarm.getMinutes();
        String time;
        if (hours < 12) {
            time = String.format("%02d:%02d SA", hours, minutes);
        } else {
            time = String.format("%02d:%02d CH", (hours - 12), minutes);
        }
        ((TextView) view.findViewById(R.id.time)).setText(time);

        ToggleButton toggle = view.findViewById(R.id.toggle_button);
        toggle.setChecked(alarm.isEnabled());

        view.findViewById(R.id.edit).setOnClickListener(v -> {
            context.onAddOrEditClick(position);
            //Toast.makeText(context.getApplicationContext(), ""+position, Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.delete).setOnClickListener(v -> {
            context.onDeleteClick(position+1);
            // Toast.makeText(context.getApplicationContext(), ""+(position+1), Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
