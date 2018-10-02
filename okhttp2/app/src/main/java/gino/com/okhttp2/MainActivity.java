package gino.com.okhttp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        sendBtn = (Button) findViewById(R.id.send_request);
        final OkHttpClient client = new OkHttpClient();
        final ExecutorService service = Executors.newSingleThreadExecutor();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.submit(new Runnable() {
                    @Override
                    public void run() {


                        //google搜尋 givemepass 的相關資訊
                        /*
                        HttpUrl.Builder builder = HttpUrl.parse("https://www.google.com.tw/search?").newBuilder();
                        builder.addQueryParameter("q","givemepass");
                        builder.addQueryParameter("oq","givemepass");
                        */

                        Request request = new Request.Builder()
                                //.url(builder.toString())
                                .url("https://www.google.com")
                                .build();

                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, final IOException e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(e.getMessage());
                                    }
                                });
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                final String resStr = response.body().string();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(resStr);
                                    }
                                });
                                /* json parse
                                try {
                                    JSONObject json = new JSONObject(resStr);
                                    final String owner = json.getString("class");
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            textView.setText(resStr);
                                        }
                                    });
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                */
                            }
                        });
                    }
                });
            }
        });
    }


}
