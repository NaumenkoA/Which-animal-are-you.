package com.alexapps.whichanimalareyou.model;

import java.util.Map;

public class Statement {
    private String mFeature;
    private String mStatement;
    private boolean mIsFinal;

    public Statement (String feature,
                      String statement) {
        mFeature = feature;
        mStatement = statement;
        mIsFinal = false;

    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean aFinal) {
        mIsFinal = aFinal;
    }

    public String getFeature() {
        return mFeature;
    }

    public void setFeature(String feature) {
        mFeature = feature;
    }

    public String getStatement() {
        return mStatement;
    }

    public void setStatement(String statement) {
        mStatement = statement;
    }

    }





