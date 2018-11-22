package wenhao.bawie.com.lian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import wenhao.bawie.com.lian.adapter.LeftAdapter;
import wenhao.bawie.com.lian.adapter.RightAdapter;
import wenhao.bawie.com.lian.bean.LeftBean;
import wenhao.bawie.com.lian.bean.RightBean;
import wenhao.bawie.com.lian.mvp.presenter.LeftPresenter;
import wenhao.bawie.com.lian.mvp.presenter.RightPresenter;
import wenhao.bawie.com.lian.mvp.view.LeftView;
import wenhao.bawie.com.lian.mvp.view.RightView;

public class MainActivity extends AppCompatActivity implements LeftView,RightView{

    private RecyclerView left_recy_view;
    private RecyclerView right_recy_view;
    private String cid = "1";
    private RightPresenter rightPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left_recy_view = (RecyclerView) findViewById(R.id.left_recy_view);
        right_recy_view = (RecyclerView) findViewById(R.id.right_recy_view);
        //右侧布局
        right_recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        rightPresenter = new RightPresenter(this);
        rightPresenter.getRight(cid);
        //左侧布局
        left_recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        //获取p层
        LeftPresenter leftPresenter = new LeftPresenter(this);
        leftPresenter.getLeft();

    }
    //左侧展示
    @Override
    public void leftsuccess(List<LeftBean.DataBean> data) {
        LeftAdapter leftAdapter = new LeftAdapter(MainActivity.this, data);
        left_recy_view.setAdapter(leftAdapter);
        leftAdapter.SuccessListener(new LeftAdapter.ShowListener() {
            @Override
            public void ShowCid(String cid) {
                rightPresenter.getRight(cid);
            }
        });
    }

    @Override
    public void rightsuccess(List<RightBean.DataBean> data) {
        RightAdapter rightAdapter = new RightAdapter(MainActivity.this, data);
        right_recy_view.setAdapter(rightAdapter);
    }
}
