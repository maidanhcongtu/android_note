package com.mhdanh.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
