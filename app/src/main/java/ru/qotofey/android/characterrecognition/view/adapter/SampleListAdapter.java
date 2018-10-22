package ru.qotofey.android.characterrecognition.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.qotofey.android.characterrecognition.R;
import ru.qotofey.android.characterrecognition.model.Sample;

public class SampleListAdapter extends RecyclerView.Adapter<SampleListAdapter.SampleHolder> {

    private List<Sample> mSampleList;

    private Context mContext;

    public SampleListAdapter(Context context) {
        mContext = context;
    }

    public void setSampleList(List<Sample> sampleList) {
        mSampleList = sampleList;
    }

    @Override
    public void onBindViewHolder(SampleHolder sampleHolder, int i) {
        Sample sample = mSampleList.get(i);
        sampleHolder.bind(sample);
    }

    @Override
    public SampleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new SampleHolder(layoutInflater, viewGroup);
    }

    @Override
    public int getItemCount() {
        return mSampleList.size();
    }

    class SampleHolder extends RecyclerView.ViewHolder {

        private Sample mSample;

        private TextView mCharacterTextView;

        public SampleHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_sample, parent, false));
            mCharacterTextView = itemView.findViewById(R.id.characterTextView);
        }

        public void bind(Sample sample) {
            mSample = sample;

            mCharacterTextView.setText(String.valueOf(mSample.getCharacter()));
        }
    }
}
