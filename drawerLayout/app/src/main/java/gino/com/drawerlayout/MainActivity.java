package gino.com.drawerlayout;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        // 為navigatin_view設置點擊事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // 點選時收起選單
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (item.getItemId()){
                    case R.id.home:
                        Toast.makeText(MainActivity.this,"home",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.miaoli:
                        Toast.makeText(MainActivity.this,"miaoli",Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.taichung:
                        Toast.makeText(MainActivity.this,"taichung",Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }


}
