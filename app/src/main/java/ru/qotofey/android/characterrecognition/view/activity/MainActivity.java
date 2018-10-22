package ru.qotofey.android.characterrecognition.view.activity;

import android.support.v4.app.Fragment;

import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.view.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base;
    }
}

