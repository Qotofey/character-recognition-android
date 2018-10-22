package ru.qotofey.android.characterrecognition.model;

import java.util.UUID;

public class Sample {

    private UUID mId;
    private Double[][] mSet = new Double[1][];
    private Double[][] mExpected;

    public Sample(Double[][] set, Double[][] expected) {
        mId = UUID.randomUUID();
        mSet = set;
        mExpected = expected;
    }

    public Sample(Double[] set, Integer expected) {
        mId = UUID.randomUUID();
        mSet[0] = set;

        switch (expected) {
            case 0:
                mExpected = new Double[][] {{ 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, }};
                break;
            case 1:
                mExpected = new Double[][] {{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, }};
                break;
            case 2:
                mExpected = new Double[][] {{ 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, }};
                break;
            case 3:
                mExpected = new Double[][] {{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, }};
                break;
            case 4:
                mExpected = new Double[][] {{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, }};
                break;
            case 5:
                mExpected = new Double[][] {{ 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, }};
                break;
            case 6:
                mExpected = new Double[][] {{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, }};
                break;
            case 7:
                mExpected = new Double[][] {{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, }};
                break;
            case 8:
                mExpected = new Double[][] {{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, }};
                break;
            case 9:
                mExpected = new Double[][] {{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, }};
                break;
            default:
                throw new ArithmeticException();
        }
    }

    public Double[][] getSet() {
        return mSet;
    }

    public Double[][] getExpected() {
        return mExpected;
    }

    public UUID getId() {
        return mId;
    }

    public int getCharacter() {
        Double result = 0.0;
        int big = 0;
        for (int i = 0; i < mExpected[0].length; i++) {
            if (mExpected[0][i] > result) {
                result = mExpected[0][i];
                big = i;
            }
        }
        return big;
    }

}
