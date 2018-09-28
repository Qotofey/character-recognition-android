package ru.qotofey.android.characterrecognition.presenter;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.model.Perceptron;
import ru.qotofey.android.characterrecognition.view.MainView;

public class MainPresenter {

    private MainView mView;

    @Inject Perceptron mPerceptron;

    public MainPresenter() {
        App.getComponent().inject(this);
    }

    public void setView(MainView view) {
        mView = view;
    }

    public void init() {
        Float[] set = new Float[] {
                1.0F, 1.0F, 0.0F,
                1.0F, 1.0F, 0.0F,
                1.0F, 1.0F, 0.0F,
                1.0F, 1.0F, 0.0F,
                1.0F, 1.0F, 0.0F,
        };
        Float[] result = new Float[] {
                -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F,
        };
        mPerceptron.train(set, result);
//        mPerceptron.train(set, result);
    }
}
