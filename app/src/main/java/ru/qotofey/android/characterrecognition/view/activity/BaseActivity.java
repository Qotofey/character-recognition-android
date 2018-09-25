package ru.qotofey.android.characterrecognition.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.app.navigation.Navigation;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigation mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);

        setContentView(R.layout.activity_base);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    protected abstract Fragment createFragment();
}
