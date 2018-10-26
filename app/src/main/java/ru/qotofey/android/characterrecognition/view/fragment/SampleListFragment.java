package ru.qotofey.android.characterrecognition.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import ru.qotofey.android.characterrecognition.App;
import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.app.navigation.Navigation;
import ru.qotofey.android.characterrecognition.model.Sample;
import ru.qotofey.android.characterrecognition.presenter.SampleListPresenter;
import ru.qotofey.android.characterrecognition.view.SampleListView;
import ru.qotofey.android.characterrecognition.view.activity.SampleActivity;
import ru.qotofey.android.characterrecognition.view.adapter.SampleListAdapter;

public class SampleListFragment extends Fragment implements SampleListView {

    private SampleListPresenter mPresenter;

    @Inject
    Navigation mNavigation;

    private RecyclerView mSampleRecyclerView;
    private SampleListAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        App.getComponent().inject(this);
        mPresenter = new SampleListPresenter();
        mPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sample_list, container, false);

        mSampleRecyclerView = v.findViewById(R.id.sampleRecyclerView);
        mSampleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mProgressBar = v.findViewById(R.id.progressBar);

        updateUI();

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
        inflater.inflate(R.menu.fragment_sample_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.learning:
                this.showLoading();
                mPresenter.getPerceptron().learn(mPresenter.getSampleLab().getSampleList(), 10);
                this.hideLoading();
                Log.i("SampleListFragment", "finished learning");
                return true;
            case R.id.newSample:
                mNavigation.invokeNewActivity(getActivity(), SampleActivity.class, false);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        List<Sample> sampleList = mPresenter.getSampleLab().getSampleList();
        if (mAdapter == null) {
            mAdapter = new SampleListAdapter(getActivity());
            mAdapter.setSampleList(sampleList);
            mSampleRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
