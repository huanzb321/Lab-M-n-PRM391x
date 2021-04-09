package funix.prm.prm391xlabs_18_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    private Activity mContext;

    public MyAsyncTask(Activity contextParent) {
        this.mContext = contextParent;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Hàm này sẽ chạy đầu tiên khi AsyncTask này được gọi
        // Ở đây sẽ thông báo quá trình load bắt đầu "Start"
        Toast.makeText(mContext, "Start", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected Void doInBackground(Void... params) {
        // Hàm được hiện tiếp sau hàm onPreExecute ()
        // Hàm này thực hiện các tác vụ chạy ngầm
        // Tuyệt đối K vễ giao diện trong hàm này
        for (int i  = 0; i <= 100; i ++) {
            SystemClock.sleep(100);
            // Khi gọi hàm này thì onProgressUpdate sẽ thực thi
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // Hàm này thực hiện update giao diện khi có dữ liệu từ hàm onInBackground gửi xuống
        super.onProgressUpdate(values);
        // Thông qua context để lấy được control trong MainActivity
        ProgressBar progressBar = (ProgressBar) mContext.findViewById(R.id.prbDemo);
        // vì publiahProgress chỉ truyền 1 đối số
        // nên mảng values chỉ có 1 phần tử
        int number = values[0];
        // tăng giá trị  của Progreebar lên
        progressBar.setProgress(number);
        // đồng thời hiển thị giá trị là % lên TextView
        TextView textView = (TextView) mContext.findViewById(R.id.txtStatus);
        textView.setText(number + "%");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Hàm này được thực hiện khi tiến trình kết thúc
        // Ở đây mình thông báo là đã "Finshed" để người dùng biết
        Toast.makeText(mContext, "Okie, Finished", Toast.LENGTH_SHORT).show();
    }
}
