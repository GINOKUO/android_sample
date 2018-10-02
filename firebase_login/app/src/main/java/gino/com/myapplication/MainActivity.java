package gino.com.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ChildEventListener {

    ArrayAdapter<String> fileDBAdapter;

    private FirebaseAuth fileAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1);
        listView.setAdapter(adapter);

        fileAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Log.e("gino", "onAuthStateChanged");
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user==null) {
                    Log.e("gino", "Try to Login: ");
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                } else {
                    Log.e("gino", "Login Success");
                    FirebaseDatabase fireDB = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = fireDB.getReference("contacts");
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            adapter.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                adapter.add(ds.child("name").getValue().toString());
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Log.w("gino", "Failed to read value.", error.toException());
                        }
                    });
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        fileAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        if (authStateListener != null){
            fileAuth.removeAuthStateListener(authStateListener);
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        fileAuth.signOut();
        super.onDestroy();
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        fileDBAdapter.add(
                String.valueOf(dataSnapshot.child("name").getValue()));
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        fileDBAdapter.remove(
                String.valueOf(dataSnapshot.child("name").getValue()));
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

    @Override
    public void onCancelled(DatabaseError databaseError) { }
}
