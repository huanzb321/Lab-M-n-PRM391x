package funix.prm.prm391x_project2_huannhfx02928;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.ListFragment;

public class FragmentMetro extends ListFragment {

    CustomAdapter customAdapter;

    public  FragmentMetro (CustomAdapter cus){
        customAdapter = cus;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_metro_layout, container, false); // thực hiện khỏi tạo layout
        setListAdapter(customAdapter); // Truyền đối số vào phương thức setListAdapter
        return view; // trả về layout hiển thị trong fragment gọi nó
    }
}
