package ru.qotofey.android.characterrecognition.presenter;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.model.Perceptron;
import ru.qotofey.android.characterrecognition.model.SampleLab;
import ru.qotofey.android.characterrecognition.view.SampleView;

public class SamplePresenter {

    private SampleView mView;

    @Inject
    Perceptron mPerceptron;
    @Inject
    SampleLab mSampleLab;

    public SamplePresenter() {
        App.getComponent().inject(this);
    }

    public void setView(SampleView view) {
        mView = view;
    }

    public void init() {

    }

    public SampleLab getSampleLab() {
        return mSampleLab;
    }

    public Perceptron getPerceptron() {
        return mPerceptron;
    }
}
