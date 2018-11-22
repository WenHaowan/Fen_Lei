package wenhao.bawie.com.lian.mvp.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wenhao.bawie.com.lian.bean.LeftBean;
import wenhao.bawie.com.lian.bean.RightBean;
import wenhao.bawie.com.lian.bean.ShowBean;

/**
 * 原创：温浩
 * 2018/11/21
 */

public interface Api {
    @GET("product/getCatagory")
    Observable<LeftBean> getleft();
    @GET("product/getProductCatagory")
    Observable<RightBean> getright(@Query("cid") String cid);
    @GET("product/getProducts")//右侧接口下的商品展示列表
    Observable<ShowBean> getshow(@Query("pscid") String pscid);
}
