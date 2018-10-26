package ru.qotofey.android.characterrecognition.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.app.navigation.Navigation;
import ru.qotofey.android.characterrecognition.model.Matrix;
import ru.qotofey.android.characterrecognition.presenter.MainPresenter;
import ru.qotofey.android.characterrecognition.view.MainView;
import ru.qotofey.android.characterrecognition.view.activity.SampleListActivity;
import ru.qotofey.android.characterrecognition.view.component.DrawingView;

public class MainFragment extends Fragment implements MainView {

    private MainPresenter mPresenter;

    @Inject
    Navigation mNavigation;

    @Inject
    Context mContext;

    private ProgressBar mProgressBar;
    private DrawingView mDrawingView;
    private Button mResetButton;
    private Button mDefineButton;

    private Snackbar mSnackbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        setHasOptionsMenu(true);
        mPresenter = new MainPresenter();
        mPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = v.findViewById(R.id.progressBar);
        mDrawingView = v.findViewById(R.id.drawingView);
        mResetButton = v.findViewById(R.id.resetButton);
        mDefineButton = v.findViewById(R.id.defineButton);


        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingView.clear();
            }

        });

        mDefineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double[][] array = new Double[1][];
                array[0] = mDrawingView.getCompressBitmap();
                Matrix matrix = mPresenter.getPerceptron().put(new Matrix(array));

                Double result = 0.0;
                int big = 0;
                for (int i = 0; i < matrix.getColumnsCount(); i++) {
                    if (matrix.get()[0][i] > result) {
                        result = matrix.get()[0][i];
                        big = i;
                    }
                }
                mSnackbar = Snackbar
                        .make(v, String.valueOf(big), Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.dismiss, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mSnackbar.dismiss();
                            }
                        });
                mSnackbar.show();
//                mDrawingView.clear();

            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.init();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.storage:
                mNavigation.invokeNewActivity(getActivity(), SampleListActivity.class, false); //invoke SampleListActivity
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }
}
