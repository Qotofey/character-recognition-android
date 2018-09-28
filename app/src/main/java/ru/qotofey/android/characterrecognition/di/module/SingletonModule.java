package ru.qotofey.android.characterrecognition.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.qotofey.android.characterrecognition.app.navigation.Navigation;
import ru.qotofey.android.characterrecognition.model.Perceptron;

@Module
public class SingletonModule {

    @Singleton
    @Provides
    public Navigation provideNavigation() {
        return new Navigation();
    }

    @Singleton
    @Provides
    public Perceptron providePerceptron() {
        return new Perceptron(2);
    }

}
