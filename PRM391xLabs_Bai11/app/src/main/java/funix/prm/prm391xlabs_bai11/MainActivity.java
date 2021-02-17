package funix.prm.prm391xlabs_bai11;

import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fragmentOneClick (View view) {
        Fragment fragment = new FragmentOne();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_svitch, fragment);
        fragmentTransaction.commit();
    }

    public void fragmentTwoClick (View view) {
        Fragment fragment = new FragmentTwo();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_svitch, fragment);
        fragmentTransaction.commit();
    }
}