package wenhao.bawie.com.lian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import wenhao.bawie.com.lian.adapter.ShowAdapter;
import wenhao.bawie.com.lian.bean.ShowBean;
import wenhao.bawie.com.lian.mvp.presenter.ShowPresenter;
import wenhao.bawie.com.lian.mvp.view.ShowView;

public class ShowActivity extends AppCompatActivity implements ShowView{

    private RecyclerView shou_recy_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        shou_recy_view = (RecyclerView) findViewById(R.id.shou_recy_view);
        //设置布局
        shou_recy_view.setLayoutManager(new LinearLayoutManager(ShowActivity.this,LinearLayoutManager.VERTICAL,false));
        //获取传过来的值
        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        //获取p层
        ShowPresenter showPresenter = new ShowPresenter(this);
        showPresenter.getShowList(pscid);
    }

    @Override
    public void successshow(List<ShowBean.DataBean> data) {
        ShowAdapter adapter = new ShowAdapter(ShowActivity.this, data);
        shou_recy_view.setAdapter(adapter);
    }
}
