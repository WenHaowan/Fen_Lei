package wenhao.bawie.com.lian.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.lian.bean.RightBean;
import wenhao.bawie.com.lian.mvp.model.HttpUtils;
import wenhao.bawie.com.lian.mvp.view.RightView;

/**
 * 原创：温浩
 * 2018/11/21
 */

public class RightPresenter {
    private RightView rightView;

    public RightPresenter(RightView rightView) {
        this.rightView = rightView;
    }

    public void getRight(String cid){
        Observable<RightBean> getright = HttpUtils.getUtilsInstance().api.getright(cid);
        getright.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RightBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull RightBean rightBean) {
                        rightView.rightsuccess(rightBean.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
