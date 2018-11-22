package wenhao.bawie.com.lian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.lian.R;
import wenhao.bawie.com.lian.bean.ShowBean;

/**
 * 原创：温浩
 * 2018/11/21
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder>{
    private Context context;
    private List<ShowBean.DataBean> list;

    public ShowAdapter(Context context, List<ShowBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShowAdapter.ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.show_adapter_layout, parent, false);
        ShowViewHolder showViewHolder = new ShowViewHolder(inflate);
        return showViewHolder;
    }

    @Override
    public void onBindViewHolder(ShowAdapter.ShowViewHolder holder, int position) {
        holder.shou_list_title.setText(list.get(position).getTitle());
        holder.show_list_price.setText("价格："+list.get(position).getPrice());
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.show_list_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder {

        private TextView shou_list_title,show_list_price;
        private ImageView show_list_image;

        public ShowViewHolder(View itemView) {
            super(itemView);
            show_list_image = (ImageView) itemView.findViewById(R.id.show_list_image);
            shou_list_title = (TextView) itemView.findViewById(R.id.shou_list_title);
            show_list_price = (TextView) itemView.findViewById(R.id.show_list_price);
        }
    }
}
