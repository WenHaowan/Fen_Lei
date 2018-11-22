package wenhao.bawie.com.lian.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.lian.R;
import wenhao.bawie.com.lian.ShowActivity;
import wenhao.bawie.com.lian.bean.RightBean;

/**
 * 原创：温浩
 * 2018/11/21
 */

public class RightListAdapter extends RecyclerView.Adapter<RightListAdapter.ListViewHolder>{
    private Context context;
    private List<RightBean.DataBean.ListBean> list;

    public RightListAdapter(Context context, List<RightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RightListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.right_list_adapter_layout, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(inflate);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(RightListAdapter.ListViewHolder holder, final int position) {
        holder.right_title.setText(list.get(position).getName());
        String[] split = list.get(position).getIcon().split("\\|");
        Glide.with(context).load(split[0]).into(holder.right_image);
        holder.right_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("pscid",list.get(position).getPscid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private ImageView right_image;
        private TextView right_title;

        public ListViewHolder(View itemView) {
            super(itemView);
            right_image = (ImageView) itemView.findViewById(R.id.right_image);
            right_title = (TextView) itemView.findViewById(R.id.right_title);
        }
    }
}
