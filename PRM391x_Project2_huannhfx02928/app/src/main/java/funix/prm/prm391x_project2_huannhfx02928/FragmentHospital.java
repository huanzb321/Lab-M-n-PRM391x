package funix.prm.prm391x_project2_huannhfx02928;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.ListFragment;

public class FragmentHospital extends ListFragment {

    CustomAdapter customAdapter;

    public  FragmentHospital(CustomAdapter cus){
        customAdapter = cus;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_hospital_layout, container, false);
        setListAdapter(customAdapter);
        return view;
    }
}
