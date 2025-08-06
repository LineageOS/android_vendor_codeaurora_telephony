/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class TurboDsdaPreference implements Parcelable {

    private static final String TAG = "TurboDsdaPreference";

    public static final int TURBO_DSDA_DISABLE = 0;
    public static final int TURBO_DSDA_ENABLE = 1 << 0;
    public static final int TURBO_DSDA_MASK =
            TURBO_DSDA_DISABLE | TURBO_DSDA_ENABLE;

    private int mTurboDsdaPreference;

    public TurboDsdaPreference(int mode) {
        if (!isValid(mode)) {
            throw new IllegalArgumentException("Invalid turbo DSDA mode preference: " + mode);
        }
        mTurboDsdaPreference = mode;
    }

    public TurboDsdaPreference() {
        this(TURBO_DSDA_ENABLE);
    }

    public TurboDsdaPreference(Parcel in) {
        mTurboDsdaPreference = in.readInt();
    }

    public int get() {
        return mTurboDsdaPreference;
    }

    private boolean isValid(int mode) {
       // Check if mode has any bits outside the mask
       if ((mode & ~TURBO_DSDA_MASK) != 0) {
           return false;
       }
       // Check if mode is one of the valid values
       return mode == TURBO_DSDA_DISABLE || mode == TURBO_DSDA_ENABLE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mTurboDsdaPreference);
    }

    public static final Parcelable.Creator<TurboDsdaPreference> CREATOR =
            new Parcelable.Creator<TurboDsdaPreference>() {
        public TurboDsdaPreference createFromParcel(Parcel in) {
            return new TurboDsdaPreference(in);
        }

        public TurboDsdaPreference[] newArray(int size) {
            return new TurboDsdaPreference[size];
        }
    };

    @Override
    public String toString() {
        return "TurboDsdaPreference{Preference='" + mTurboDsdaPreference + "'}";
    }
}
