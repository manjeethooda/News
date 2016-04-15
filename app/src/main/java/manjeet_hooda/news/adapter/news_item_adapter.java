package manjeet_hooda.news.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import manjeet_hooda.news.R;
import manjeet_hooda.news.activity.MainActivity;
import manjeet_hooda.news.model.news_item;

/**
 * Created by manjeet on 15/4/16.
 */
public class news_item_adapter extends RecyclerView.Adapter<news_item_adapter.news_item_holder> {

    private ArrayList<news_item> mList;

    public news_item_adapter(ArrayList<news_item> list){
        this.mList  = list;
    }

    @Override
    public news_item_adapter.news_item_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.news_item_layout, parent, false);
        return new news_item_holder(view);
    }

    @Override
    public void onBindViewHolder(news_item_adapter.news_item_holder holder, int position) {
        news_item news = mList.get(position);
        holder.bindNews(news);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class news_item_holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mHead;
        private TextView mCapt;

        public news_item_holder(View view) {
            super(view);
            view.setOnClickListener(this);
            mHead = (TextView) view.findViewById(R.id.headline);
            mCapt = (TextView) view.findViewById(R.id.caption);
        }

        @Override
        public void onClick(View v) {
        }

        public void bindNews(news_item item) {
            mHead.setText(item.getHeadline());
            mCapt.setText(item.getCaption());
        }
    }
}
