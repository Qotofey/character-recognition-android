package ru.qotofey.android.characterrecognition;

import android.app.Application;

import ru.qotofey.android.characterrecognition.di.component.AppComponent;
import ru.qotofey.android.characterrecognition.di.component.DaggerAppComponent;
import ru.qotofey.android.characterrecognition.di.module.AppModule;

public class App extends Application {

    private static AppComponent sAppComponent;

    public static AppComponent getComponent() {
        return sAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        sAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
