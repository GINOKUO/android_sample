package gino.com.queue;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity{

    Button btn;
    TextView tv;
    private Handler hander = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        final Queue q = new LinkedList();
        q.offer("First");
        q.offer("Second");
        q.offer("Third");
        Object o;
        System.out.println(q.toString());
        while((o = q.poll()) != null) {
            final String s = (String)o;
            System.out.println(s);
            hander.post(new Runnable() {
                @Override
                public void run() {
                    tv.setText(s);
                }
            });
        }
        System.out.println(q.toString());
    }
}
