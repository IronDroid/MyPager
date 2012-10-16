package org.ajcm.pager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.viewpagerindicator.UnderlinePageIndicator;

public class MainActivity extends Activity {

    private static final String[] CONTENT = new String[]{"Recent", "Artists", "Albums"};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MyPagerAdapter adapter = new MyPagerAdapter();
        ViewPager pager = (ViewPager) findViewById(R.id.my_pager);
        pager.setAdapter(adapter);
        pager.setCurrentItem(1);
        UnderlinePageIndicator indicator = (UnderlinePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        indicator.setFades(false);
        indicator.setCurrentItem(1);
    }

    private class MyPagerAdapter extends PagerAdapter {

        public MyPagerAdapter() {
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int res = 0;
            switch (position) {
                case 0:
                    res = R.layout.main_1;
                    break;
                case 1:
                    res = R.layout.main_2;
                    break;
                case 2:
                    res = R.layout.main_3;
                    break;
            }
            View view = inflater.inflate(res, null);
            ((ViewPager) container).addView(view, 0);
            return view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == (View) o;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }
}
