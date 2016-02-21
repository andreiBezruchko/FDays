package com.webacademy.fdays;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DSharov on 18.02.16.
 */
public class CustomPagerAdapter extends AppCompatActivity {
    public static final String GOOD_BAD_DAY = "My Day";
    public static final String TARGETS = "Targets";
    public static final String CALENDAR = "Calendar";

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return TargetsFragment.newInstance(0, "Targets");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return ButtonsFragment.newInstance(1, "Good/Bad Day");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return CalendarFragment.newInstance(2, "Calendar");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator


        public CharSequence getPageTitle(int position) {
            String headerTitle = null;
            switch (position) {
                case 0:
                    headerTitle = TARGETS;
                    break;
                case 1:
                    headerTitle = GOOD_BAD_DAY;
                    break;
                case 2:
                    headerTitle = CALENDAR;
                    break;
            }
            return headerTitle;
        }

    }
}