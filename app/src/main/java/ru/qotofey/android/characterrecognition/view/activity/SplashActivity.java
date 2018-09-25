package ru.qotofey.android.characterrecognition.view.activity;

import android.support.v4.app.Fragment;

import ru.qotofey.android.characterrecognition.view.fragment.SplashFragment;

public class SplashActivity extends BaseActivity {

//    private ImageView mIconImageView;
//    private Animation mAnimation;
//    private ProgressBar mProgressBar;
//    private ConstraintLayout mLayout;
//
//    private static final int SPLASH_DURATION = 2500;

    @Override
    protected Fragment createFragment() {
        return new SplashFragment();
    }

}
