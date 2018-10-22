package ru.qotofey.android.characterrecognition.presenter;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.view.MainView;

public class MainPresenter {

    private MainView mView;

//    @Inject Perceptron mPerceptron;

    public MainPresenter() {
        App.getComponent().inject(this);
    }

    public void setView(MainView view) {
        mView = view;
    }

    public void init() {
        Double[] set = new Double[] {
                1.0, 1.0, 0.0,

        };
        Double[] result = new Double[] {
                -1.0, 1.0, -1.0
        };

//        mPerceptron.train(set, result);
    }
}
