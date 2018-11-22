package wenhao.bawie.com.lian.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.lian.bean.ShowBean;
import wenhao.bawie.com.lian.mvp.model.HttpUtils;
import wenhao.bawie.com.lian.mvp.view.ShowView;

/**
 * 原创：温浩
 * 2018/11/21
 */

public class ShowPresenter {
    private ShowView showView;

    public ShowPresenter(ShowView showView) {
        this.showView = showView;
    }

    public void getShowList(String pscid){
        Observable<ShowBean> show = HttpUtils.getUtilsInstance().api.getshow(pscid);
        show.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ShowBean showBean) {
                        showView.successshow(showBean.getData());
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
