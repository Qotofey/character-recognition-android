package ru.qotofey.android.characterrecognition.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.model.Sample;
import ru.qotofey.android.characterrecognition.presenter.SamplePresenter;
import ru.qotofey.android.characterrecognition.view.SampleView;
import ru.qotofey.android.characterrecognition.view.component.DrawingView;

public class SampleFragment extends Fragment implements SampleView {

    private SamplePresenter mPresenter;

    private DrawingView mDrawingView;
    private Button mResetButton;
    private Button mCancelButton;
    private Button mSaveButton;
    private Spinner mCharactorSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        mPresenter = new SamplePresenter();
        mPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sample, container, false);
        mDrawingView = v.findViewById(R.id.drawingView);
        mResetButton = v.findViewById(R.id.resetButton);
        mCancelButton = v.findViewById(R.id.cancelButton);
        mSaveButton = v.findViewById(R.id.saveButton);
        mCharactorSpinner = v.findViewById(R.id.characterSpinner);

        mResetButton.setOnClickListener(value -> mDrawingView.clear());
        mCancelButton.setOnClickListener(value -> getActivity().finish());
        mSaveButton.setOnClickListener(value -> {
            Sample sample = new Sample(
                    mDrawingView.getCompressBitmap(),
                    mCharactorSpinner.getSelectedItemPosition()
            );
            mPresenter.getModel().addSample(sample);
            mDrawingView.clear();
            Log.e("TAG", String.valueOf(mPresenter.getModel().getSampleList().size()));
            getActivity().finish();
        });
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.init();
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }
}
