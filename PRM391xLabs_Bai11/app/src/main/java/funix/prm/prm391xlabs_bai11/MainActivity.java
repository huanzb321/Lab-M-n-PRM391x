package funix.prm.prm391xlabs_bai11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fragmentOneClick (View view) {
        Fragment fragment = new FragmentOne();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // Chỗ này để gõ cho chuẩn thì tốt nhất dùng phần gợi ý của IDE
        // Ví dụ gõ R. sau đó chờ IDE gợi ý và cứ thế cho đén khi đc thành phần mong muốn
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }

    public void fragmentTwoClick (View view) {
        Fragment fragment = new FragmentTwo();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }
}