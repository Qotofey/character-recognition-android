package ru.qotofey.android.characterrecognition.view.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import ru.qotofey.android.characterrecognition.R;

public class SplashActivity extends BaseActivity {

    private ImageView mIconImageView;
    private Animation mAnimation;
    private ProgressBar mProgressBar;
    private ConstraintLayout mLayout;

    private static final int SPLASH_DURATION = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mLayout = (ConstraintLayout) findViewById(R.id.splashLayout);
        mIconImageView = (ImageView) findViewById(R.id.iconImageView);
        mAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);

    }

    private void initFunctionality() {
//        Flowable
//                .just(this)
//                .subscribe(v -> {
//
//                });
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
                        mNavigation.invokeNewActivity(SplashActivity.this, MainActivity.class, true); //invoke MainActivity
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }, SPLASH_DURATION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initFunctionality();
    }
}
