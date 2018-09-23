package ru.qotofey.android.characterrecognition.view.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.app.navigation.Navigation;

public class SplashActivity extends AppCompatActivity {

    private ImageView mIconImageView;
    private Animation mAnimation;
    private ProgressBar mProgressBar;
    private ConstraintLayout mLayout;

    private static final int SPLASH_DURATION = 2500;

    @Inject
    Navigation mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mLayout = (ConstraintLayout) findViewById(R.id.splashLayout);
        mIconImageView = (ImageView) findViewById(R.id.iconImageView);
        mAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);

    }

    private void initFunctionality() {
//        Flowable
//                .just(0)
//                .subscribe();
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
