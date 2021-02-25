package funix.prm.prm391x_project2_huannhfx02928;

import androidx.fragment.app.Fragment;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMenu extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Uri.Builder savedInstanceState) {
        return inflater.inflate(R.layout.activity_menu_layout, container, false);
    }
}
