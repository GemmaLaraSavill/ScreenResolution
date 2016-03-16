package com.naturalapps.screenresolution;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text1);
        textView.setText(getSizeName(this));

        DisplayMetrics metrics = getResources().getDisplayMetrics();

        TextView textView2 = (TextView) findViewById(R.id.text2);
        textView2.setText("Dpi"+metrics);

        int densityDpi = (int)(metrics.density * 160f);
        TextView textView3 = (TextView) findViewById(R.id.text3);
        textView3.setText("densityDpi "+densityDpi +" (density * 160)");


        TextView textView4 = (TextView) findViewById(R.id.text4);
        textView4.setText("density name "+getDenstityName(this));

    }

    private static String getDenstityName(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return "xxxhpdi";
        }
        if (density >= 3.0) {
            return "xxhpdi";
        }
        if (density >= 2.0) {
            return "xhpdi";
        }
        if (density >= 1.5) {
            return "hpdi";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";
    }


    private static String getSizeName(Context context) {
        int screenLayout = context.getResources().getConfiguration().screenLayout;
        screenLayout &= Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenLayout) {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "small";
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "normal";
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "large";
            case 4: // Configuration.SCREENLAYOUT_SIZE_XLARGE is API >= 9
                return "xlarge";
            default:
                return "undefined";
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
