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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    TextView tv;
    private Handler hander = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Intent intent = new Intent(this,Main2Activity.class);
        //startActivity(intent);

    }

    class task extends AsyncTask<>{

        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }
    }
}
