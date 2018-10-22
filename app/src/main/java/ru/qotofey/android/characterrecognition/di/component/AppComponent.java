package ru.qotofey.android.characterrecognition.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.qotofey.android.characterrecognition.di.module.AppModule;
import ru.qotofey.android.characterrecognition.di.module.SingletonModule;
import ru.qotofey.android.characterrecognition.presenter.MainPresenter;
import ru.qotofey.android.characterrecognition.presenter.SampleListPresenter;
import ru.qotofey.android.characterrecognition.presenter.SamplePresenter;
import ru.qotofey.android.characterrecognition.presenter.SplashPresenter;
import ru.qotofey.android.characterrecognition.view.activity.BaseActivity;
import ru.qotofey.android.characterrecognition.view.activity.MainActivity;
import ru.qotofey.android.characterrecognition.view.activity.SampleActivity;
import ru.qotofey.android.characterrecognition.view.activity.SampleListActivity;
import ru.qotofey.android.characterrecognition.view.activity.SplashActivity;
import ru.qotofey.android.characterrecognition.view.fragment.MainFragment;
import ru.qotofey.android.characterrecognition.view.fragment.SampleFragment;
import ru.qotofey.android.characterrecognition.view.fragment.SampleListFragment;
import ru.qotofey.android.characterrecognition.view.fragment.SplashFragment;

@Singleton
@Component(modules = {AppModule.class, SingletonModule.class})
public interface AppComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(SplashActivity activity);
    void inject(MainActivity activity);
    void inject(SampleActivity activity);
    void inject(SampleListActivity activity);

    //fragments
    void inject(SplashFragment fragment);
    void inject(MainFragment fragment);
    void inject(SampleFragment fragment);
    void inject(SampleListFragment fragment);

    //presenters
    void inject(SplashPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(SamplePresenter presenter);
    void inject(SampleListPresenter presenter);


}
