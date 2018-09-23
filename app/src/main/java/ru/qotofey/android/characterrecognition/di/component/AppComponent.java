package ru.qotofey.android.characterrecognition.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.qotofey.android.characterrecognition.di.module.AppModule;
import ru.qotofey.android.characterrecognition.di.module.SingletonModule;
import ru.qotofey.android.characterrecognition.view.activity.MainActivity;
import ru.qotofey.android.characterrecognition.view.activity.SplashActivity;

@Singleton
@Component(modules = {AppModule.class, SingletonModule.class})
public interface AppComponent {

    //activities
    void inject(SplashActivity activity);
    void inject(MainActivity activity);

    //fragments

    //prsenters


}
