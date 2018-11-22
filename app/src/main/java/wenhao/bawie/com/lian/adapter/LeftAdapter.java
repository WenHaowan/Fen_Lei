package wenhao.bawie.com.lian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wenhao.bawie.com.lian.R;
import wenhao.bawie.com.lian.bean.LeftBean;

/**
 * 原创：温浩
 * 2018/11/21
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder>{
    private Context context;
    private List<LeftBean.DataBean> list;

    public LeftAdapter(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public LeftAdapter.LeftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.left_adapter_layout, parent, false);
        LeftViewHolder leftViewHolder = new LeftViewHolder(inflate);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(LeftAdapter.LeftViewHolder holder, final int position) {
        holder.left_name.setText(list.get(position).getName());
        holder.left_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showListener.ShowCid(list.get(position).getCid()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder {

        private TextView left_name;

        public LeftViewHolder(View itemView) {
            super(itemView);
            left_name = (TextView) itemView.findViewById(R.id.left_name);
        }
    }

    private ShowListener showListener;

    public void SuccessListener(ShowListener showListener){
        this.showListener = showListener;
    }

    public interface ShowListener{
        void ShowCid(String cid);
    }
}
