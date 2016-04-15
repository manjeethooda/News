package manjeet_hooda.news.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import manjeet_hooda.news.R;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mPagerAdapter;
    private PagerSlidingTabStrip tabsStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupPager();
        setupReceiveIntent();

    }

    private void setupReceiveIntent(){
        final Intent intent = getIntent();
        if(intent.hasExtra("Chat")){
            int Tab = intent.getExtras().getInt("Chat");
            switchtotab(Tab);
        }
    }

    private void switchtotab(int Tab){
        mViewPager.setCurrentItem(Tab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    private void setupPager() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new manjeet_hooda.news.adapter.PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tab_layout);
        tabsStrip.setViewPager(mViewPager);
        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
