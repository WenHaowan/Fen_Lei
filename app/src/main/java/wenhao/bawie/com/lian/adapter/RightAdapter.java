package wenhao.bawie.com.lian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wenhao.bawie.com.lian.R;
import wenhao.bawie.com.lian.bean.RightBean;

/**
 * 原创：温浩
 * 2018/11/21
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder>{
    private Context context;
    private List<RightBean.DataBean> list;

    public RightAdapter(Context context, List<RightBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RightAdapter.RightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.right_adapter_layout, parent, false);
        RightViewHolder rightViewHolder = new RightViewHolder(inflate);
        return rightViewHolder;
    }

    @Override
    public void onBindViewHolder(RightAdapter.RightViewHolder holder, int position) {
        holder.right1_recy_view.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        RightListAdapter rightListAdapter = new RightListAdapter(context, list.get(position).getList());
        holder.right1_recy_view.setAdapter(rightListAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RightViewHolder extends RecyclerView.ViewHolder {


        private RecyclerView right1_recy_view;

        public RightViewHolder(View itemView) {
            super(itemView);
            right1_recy_view = (RecyclerView) itemView.findViewById(R.id.right1_recy_view);
        }
    }
}
