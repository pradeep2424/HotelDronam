package com.miracle.dronam.main;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.miracle.dronam.R;
import com.miracle.dronam.bottomMenu.CartFragment;
import com.miracle.dronam.bottomMenu.HomeFragment;
import com.miracle.dronam.bottomMenu.ProfileFragment;
import com.miracle.dronam.bottomMenu.SearchFragment;
import com.miracle.dronam.fragments.PastOrdersFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.BaseTheme_Blue);
        setContentView(R.layout.activity_main);

        init();
        componentEvents();
    }

    private void init() {
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        bottomBar = (BottomBar) findViewById(R.id.bottombar);

        for (int i = 0; i < bottomBar.getTabCount(); i++) {
            bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL);
        }
    }

    private void componentEvents() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        replaceFragment(new HomeFragment());
                        break;

                    case R.id.tab_search:
                        replaceFragment(new SearchFragment());
                        break;

                    case R.id.tab_cart:
                        replaceFragment(new CartFragment());
                        break;

                    case R.id.tab_orders:
                        replaceFragment(new PastOrdersFragment());
//                        replaceFragment(new OrdersFragment());
                        break;

                    case R.id.tab_profile:
                        replaceFragment(new ProfileFragment());
                        break;
                }
            }
        });
    }


    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }
}