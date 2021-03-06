package ru.qotofey.android.characterrecognition.presenter;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.model.Perceptron;
import ru.qotofey.android.characterrecognition.model.SampleLab;
import ru.qotofey.android.characterrecognition.view.SampleListView;

public class SampleListPresenter {

    private SampleListView mView;

    @Inject
    Perceptron mPerceptron;
    @Inject
    SampleLab mSampleLab;

    public SampleListPresenter() {
        App.getComponent().inject(this);
    }

    public void setView(SampleListView view) {
        mView = view;
    }

    public void init() {
        mView.hideLoading();
    }

    public SampleLab getSampleLab() {
        return mSampleLab;
    }

    public Perceptron getPerceptron() {
        return mPerceptron;
    }

}
