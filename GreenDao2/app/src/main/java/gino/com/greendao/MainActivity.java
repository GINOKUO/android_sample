
package gino.com.greendao;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;


import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import java.util.Random;

import gino.com.greendaoFile.UserDao;

public class MainActivity extends AppCompatActivity {

    private static Context mContext;

    private static final String[] lastNames = {"王", "陳", "林", "洪", "楊", "許", "蔡", "詹"};
    private static final String[] firstNames = {"冠廷", "雅婷", "冠宇", "怡萱", "家豪", "怡君", "承翰", "詩涵", "伯翰", "怡婷"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        greenDaoManger.getInstance();

        for(int i = 0 ; i < 5; i++)
            insertDate();
        quaryData();

    }

    private String generateName() {
        Random random = new Random();
        int lastname = random.nextInt(lastNames.length);
        int firstname = random.nextInt(firstNames.length);
        return lastNames[lastname] + firstNames[firstname];
    }

    private int generateAge() {
        Random random = new Random();
        int num = random.nextInt(10);
        return 10+num;
    }

    public static Context getContext() {
        return mContext;
    }

    private void insertDate() {
        User insertdate = new User(null,generateName(),generateAge());
        getUserDao().insert(insertdate);
    }

    private void quaryData() {
        List<User> users = getUserDao().loadAll();
        Log.d("gino","all data size = "+users.size());
        for(int i = 0; i < users.size(); i++) {
            Log.d("gino","getId = " + users.get(i).getId() + " getName = " + users.get(i).getName() +
                    " getAge = " + users.get(i).getAge());
        }

    }

    private UserDao getUserDao () {
        return greenDaoManger.getInstance().getSession().getUserDao();
    }


}
