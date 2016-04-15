package manjeet_hooda.news.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import manjeet_hooda.news.fragment.Business;
import manjeet_hooda.news.fragment.Cricket;
import manjeet_hooda.news.fragment.Entertainment;
import manjeet_hooda.news.fragment.Sports;
import manjeet_hooda.news.fragment.Tech;
import manjeet_hooda.news.fragment.top_news;
import manjeet_hooda.news.fragment.world;


public class PagerAdapter extends FragmentPagerAdapter {

    private top_news m_top_news = null;
    private world m_world = null;
    private Tech m_tech = null;
    private Sports m_sports = null;
    private Entertainment m_ent = null;
    private Cricket m_cric = null;
    private Business m_bus = null;

    final int PAGE_COUNT = 7;
    private String tabTitles[] = new String[] {"Top News", "World", "Tech", "Sports", "Entertainment",
                                                "Cricket", "Business"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                if (m_top_news == null) {
                    m_top_news = new top_news();
                }
                return m_top_news;
            case 1:
                if (m_world == null) {
                    m_world = new world();
                }
                return m_world;
            case 2:
                if (m_tech == null) {
                    m_tech = new Tech();
                }
                return m_tech;
            case 3:
                if (m_sports == null) {
                    m_sports = new Sports();
                }
                return m_sports;
            case 4:
                if (m_ent == null) {
                    m_ent = new Entertainment();
                }
                return m_ent;
            case 5:
                if (m_cric == null) {
                    m_cric = new Cricket();
                }
                return m_cric;
            case 6:
                if (m_bus == null) {
                    m_bus = new Business();
                }
                return m_bus;
            default:
                return null;
        }
    }
}