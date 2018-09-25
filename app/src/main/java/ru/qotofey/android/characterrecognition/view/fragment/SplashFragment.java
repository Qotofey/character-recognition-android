package ru.qotofey.android.characterrecognition.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.app.navigation.Navigation;
import ru.qotofey.android.characterrecognition.presenter.SplashPresenter;
import ru.qotofey.android.characterrecognition.view.SplashView;
import ru.qotofey.android.characterrecognition.view.activity.MainActivity;

public class SplashFragment extends Fragment implements SplashView {

    private SplashPresenter mPresenter;
    @Inject
    Context mContext;
    @Inject
    Navigation mNavigation;

    private ProgressBar mProgressBar;

    private ImageView mIconImageView;
    private Animation mAnimation;
    private ConstraintLayout mLayout;

    private static final int SPLASH_DURATION = 2500;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        mPresenter = new SplashPresenter();
        mPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_splash, container, false);
        mProgressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        mLayout = (ConstraintLayout) v.findViewById(R.id.splashLayout);
        mIconImageView = (ImageView) v.findViewById(R.id.iconImageView);
        mAnimation = AnimationUtils.loadAnimation(mContext, R.anim.rotate);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.init();
    }

    @Override
    public void rotateLogo() {
        mLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
                mIconImageView.startAnimation(mAnimation);
                mAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mNavigation.invokeNewActivity(getActivity(), MainActivity.class, true); //invoke MainActivity
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }, SPLASH_DURATION);
    }

    @Override
    public void hideLoading() {
//        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
//        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.rotateLogo();
    }
}
