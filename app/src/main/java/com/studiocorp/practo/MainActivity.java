package com.studiocorp.practo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import   android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    Button button1;

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        textView1=(TextView)findViewById(R.id.textView1);
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(MainActivity.this,Search.class);
                startActivityForResult(intent, 2);// Activity is started with requestCode 2
            }
        });
        MyListFragment fragment = new MyListFragment();
        loadFragment(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);

        transaction.commit();
    }
    private void loadFragment(MyListFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            textView1.setText(message);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                        transaction.replace(R.id.fra)
                        MyListFragment fragment = new MyListFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.list_dash:
                        DashboardFragment fragment1 = new DashboardFragment();
                        loadFragment1(fragment1);
                        return true;
                    case R.id.read:

                     ReadFragment fragment2 = new ReadFragment();
                        loadFragment2(fragment2);
                        return true;
                    case R.id.profile:
                        ProfileFragment profileFragment=new ProfileFragment();
                        loadFragment3(profileFragment);
                        return true;
                }
                return false;
            }





            private void loadFragment1(DashboardFragment fragment1) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment1);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        };
    }

    private void loadFragment3(ProfileFragment profileFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, profileFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    private void loadFragment2(ReadFragment fragment2) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment2);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
