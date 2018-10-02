package gino.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member(1, R.drawable.n1, "number 1"));
        memberList.add(new Member(2, R.drawable.n2, "number 2"));
        memberList.add(new Member(3, R.drawable.n3, "number 3"));
        memberList.add(new Member(4, R.drawable.n4, "number 4"));
        memberList.add(new Member(5, R.drawable.n5, "number 5"));
        memberList.add(new Member(6, R.drawable.n6, "number 6"));
        memberList.add(new Member(7, R.drawable.n7, "number 7"));
        memberList.add(new Member(8, R.drawable.n8, "number 8"));
        memberList.add(new Member(9, R.drawable.n9, "number 9"));
        memberList.add(new Member(10, R.drawable.n10, "number 10"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)); // 2表示兩行,VERTICAL or HORIZONTAL
// MemberAdapter 會在步驟7建立
        recyclerView.setAdapter(new MemberAdapter(this, memberList));
    }
}


//https://spicyboyd.blogspot.com/2018/03/app-recyclerview-cardview.html