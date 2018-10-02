package gino.com.savedinstancestate;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tv,tv2,tv3;
    private Handler handler = new Handler();
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);


        go();
    }

    public void go() {
        System.out.println("go: " + Thread.currentThread().getName());
        new Thread() {
            public void run() {
                System.out.println("run: " + Thread.currentThread().getName());
                for (i = 1; ; i += 2) {
                    //method 1
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(i+"");
                        }
                    });

                    //method 2
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv2.setText(i+"");
                        }
                    });

                    //method 3
                    mhander.sendEmptyMessage(0);

                    System.out.println(i);
                    SystemClock.sleep(1000);
                }
            }
        }.start();
    }

    private Handler mhander = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    tv3.setText(i+"");
                    break;
            }
        }
    };
}