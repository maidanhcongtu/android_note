package com.mhdanh.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mhdanh.helloworld.fragment.HomeFragment;
import com.mhdanh.helloworld.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, new HomeFragment()).commit();

        initBottomNavigation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);

        Drawable setting = menu.findItem(R.id.setting).getIcon();
        setting.mutate();
        setting.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        Drawable about = menu.findItem(R.id.about).getIcon();
        about.mutate();
        about.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        Drawable more = menu.findItem(R.id.more).getIcon();
        more.mutate();
        more.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);


        return true;
    }

    private void initBottomNavigation() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationMenuView menu = (BottomNavigationMenuView) navigation.getChildAt(0);
        BottomNavigationItemView item = (BottomNavigationItemView) menu.findViewById(R.id.menu_bottom_navigation_email);
        View badge = LayoutInflater.from(this)
                .inflate(R.layout.badge_message, menu, false);

        item.addView(badge);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_bottom_navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, new HomeFragment()).commit();
                        return true;
                    case R.id.menu_bottom_navigation_setting:
                        Intent setting = new Intent(getApplicationContext(), SettingActivity.class);
                        startActivity(setting);
                        return true;
                    case R.id.menu_bottom_navigation_email:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.mainFragment, new MessageFragment())
                                .commit();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.setting:
                Intent setting = new Intent(this, SettingActivity.class);
                this.startActivity(setting);
                return true;
            case R.id.about:
                Toast.makeText(getApplicationContext(), "about action", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return true;
        }
    }
}
