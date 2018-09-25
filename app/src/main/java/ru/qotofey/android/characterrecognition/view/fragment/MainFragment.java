package ru.qotofey.android.characterrecognition.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.presenter.MainPresenter;
import ru.qotofey.android.characterrecognition.view.MainView;
import ru.qotofey.android.characterrecognition.view.component.DrawingView;

public class MainFragment extends Fragment implements MainView {

    private MainPresenter mPresenter;

    @Inject
    Context mContext;

    private DrawingView mDrawingView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        mPresenter = new MainPresenter();
        mPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mDrawingView = v.findViewById(R.id.drawingView);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
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
