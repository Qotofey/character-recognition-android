package ru.qotofey.android.characterrecognition.presenter;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.view.SplashView;

public class SplashPresenter {

    private SplashView mView;

    public SplashPresenter() {
        App.getComponent().inject(this);
    }

    public void setView(SplashView view) {
        mView = view;
    }

    public void init() {
//        this.showLoading();
//        this.hideLoading();
//        this.rotateLogo();
    }

    private void showLoading() {
        mView.showLoading();
    }

    private void hideLoading() {
        mView.hideLoading();
//        mObservable
//                .delay(2500, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(v -> mView.hideLoading());
    }

    private void rotateLogo() {
        mView.rotateLogo();
//        mObservable
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(v -> mView.rotateLogo());

    }
}
