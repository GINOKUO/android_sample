package gino.com.gridview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private GridView grid;
    private String[] text = {"n1", "n2", "n3", "n4", "n5", "n6",
            "n7", "n8", "n9", "n10"};
    private int[] imageId = {R.drawable.n1, R.drawable.n2, R.drawable.n3,
            R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7,
            R.drawable.n8, R.drawable.n9, R.drawable.n10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGrid adapter = new CustomGrid(MainActivity.this, text, imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //[+position] +的功用是?
                Toast.makeText(MainActivity.this, "你選取了" + text[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

//https://spicyboyd.blogspot.com/2018/03/app-gridview.html