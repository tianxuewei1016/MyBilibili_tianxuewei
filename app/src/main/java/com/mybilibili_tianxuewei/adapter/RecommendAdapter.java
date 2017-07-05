package com.mybilibili_tianxuewei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mybilibili_tianxuewei.R;
import com.mybilibili_tianxuewei.bean.RecommendBean;
import com.mybilibili_tianxuewei.utils.TimeUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：田学伟 on 2017/7/4 18:44
 * QQ：93226539
 * 作用：
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.MyViewHolder> {


    private List<RecommendBean.DataBean> datas;
    private Context context;
    private TimeUtils timeUtils;

    public RecommendAdapter(Context context, List<RecommendBean.DataBean> data) {
        this.datas = data;
        this.context = context;
        timeUtils = new TimeUtils();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(context, R.layout.recommend_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecommendBean.DataBean dataBean = datas.get(position);
        //设置图片
        Glide.with(context).load(dataBean.getCover()).into(holder.comprehensiveItemIv);
        //设置各个文本数据
        holder.comprehensiveItemTvDec.setText(dataBean.getTname());
        holder.comprehensiveItemTvTitle.setText(dataBean.getTitle());

        int play = dataBean.getPlay();
        if (play >= 10000) {
            double number = play;
            holder.comprehensiveItemTvPaly.setText((double) (Math.round(number / 1000)) / 10 + "万");
        } else {
            holder.comprehensiveItemTvPaly.setText(play + "");
        }
        holder.comprehensiveItemTvTid.setText(dataBean.getTid() + "");
        holder.comprehensiveItemTvDuration.setText(timeUtils.stringForTime(dataBean.getDuration() * 1000));

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void refresh(List<RecommendBean.DataBean> data) {
        this.datas.clear();
        this.datas.addAll(data);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.comprehensive_item_iv)
        ImageView comprehensiveItemIv;
        @Bind(R.id.comprehensive_item_tv_paly)
        TextView comprehensiveItemTvPaly;
        @Bind(R.id.comprehensive_item_tv_tid)
        TextView comprehensiveItemTvTid;
        @Bind(R.id.comprehensive_item_tv_duration)
        TextView comprehensiveItemTvDuration;
        @Bind(R.id.comprehensive_item_tv_title)
        TextView comprehensiveItemTvTitle;
        @Bind(R.id.comprehensive_item_tv_dec)
        TextView comprehensiveItemTvDec;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
