package ru.qotofey.android.characterrecognition.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SampleLab {

    private List<Sample> mSampleList;

    public SampleLab() {
        mSampleList = new ArrayList<>();

//        Sample sample = new Sample(
//                new Double[][] {
//                        {
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                        },
//                },
//                new Double[][] {
//                        {
//                            0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                        }
//                }
//        );
//        mSampleList.add(sample);
//        sample = new Sample(
//                new Double[][] {
//                        {
//                                1.0, 1.0, 1.0,
//                                1.0, 0.0, 1.0,
//                                1.0, 0.0, 1.0,
//                                1.0, 0.0, 1.0,
//                                1.0, 1.0, 1.0,
//                        }
//                },
//                new Double[][]{
//                        {
//                                1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                        }
//                }
//        );
//        mSampleList.add(sample);

    }

    public List<Sample> getSampleList() {
        return mSampleList;
    }

    public void addSample(Sample sample) {
        mSampleList.add(sample);
    }

    public Sample getSample(UUID id) {
        for (Sample sample : mSampleList) {
            if (sample.getId().equals(id)) {
                return sample;
            }
        }
        return null;
    }
}
