package wenhao.bawie.com.lian.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.lian.bean.LeftBean;
import wenhao.bawie.com.lian.mvp.model.HttpUtils;
import wenhao.bawie.com.lian.mvp.view.LeftView;

/**
 * 原创：温浩
 * 2018/11/21
 */

public class LeftPresenter {
    private LeftView leftView;

    public LeftPresenter(LeftView leftView) {
        this.leftView = leftView;
    }
    public void getLeft(){
        Observable<LeftBean> getleft = HttpUtils.getUtilsInstance().api.getleft();
        getleft.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LeftBean leftBean) {
                        leftView.leftsuccess(leftBean.getData());
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
