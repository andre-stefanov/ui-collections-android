package com.jambit.advancelearningcontainers;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerFragment.OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_list:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("RecyclerView: " + getText(R.string.title_list));
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, RecyclerFragment.createInstance(1))
                        .commit();
                return true;
            case R.id.navigation_grid:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("RecyclerView: " + getText(R.string.title_grid));
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, RecyclerFragment.createInstance(4))
                        .commit();
                return true;
            default:
                return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_list);
    }

    @Override
    public void onListFragmentInteraction(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
