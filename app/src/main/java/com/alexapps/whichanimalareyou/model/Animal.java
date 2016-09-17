package com.alexapps.whichanimalareyou.model;

public class Animal {
    private String mAmimalName;
    private int mPictureId;
    private int[] mFeatures;

    public Animal (String amimalName,
                   int pictureId,
                   int[] features) {
        mAmimalName = amimalName;
        mPictureId = pictureId;
        mFeatures = features;
    }

    public String getAmimalName() {
        return mAmimalName;
    }

    public void setAmimalName(String amimalName) {
        mAmimalName = amimalName;
    }

    public int getPictureId() {
        return mPictureId;
    }

    public void setPictureId(int pictureId) {
        this.mPictureId = pictureId;
    }

    public int[] getFeatures() {
        return mFeatures;
    }

    public void setFeatures(int[] features) {
        mFeatures = features;
    }
}
