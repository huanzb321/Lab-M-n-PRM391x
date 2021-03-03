package funix.prm.prm391x_project2_huannhfx02928;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMenu extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu_layout, container, false);// thực hiện khỏi tạo layout
        return view; // trả về layout hiển thị trong fragment gọi nó
    }
}
