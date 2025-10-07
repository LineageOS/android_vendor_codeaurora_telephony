/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */


package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class DataPriorityPreference implements Parcelable {

    private static final String TAG = "DataPriorityPreference";

    public static final int DATA_PRIORITY_SUB_DEFAULT = 0;
    public static final int DATA_PRIORITY_SUB_MAX_TPUT = 1 << 0;
    public static final int DATA_PRIORITY_SUB_MASK =
            DATA_PRIORITY_SUB_DEFAULT | DATA_PRIORITY_SUB_MAX_TPUT;

    private int mDataPriorityPreference;

    public DataPriorityPreference(int mode) {
        if (!isValid(mode)) {
            throw new IllegalArgumentException("Invalid data priority preference mode: " + mode);
        }
        mDataPriorityPreference = mode;
    }

    public DataPriorityPreference() {
        this(DATA_PRIORITY_SUB_DEFAULT);
    }

    public DataPriorityPreference(Parcel in) {
        mDataPriorityPreference = in.readInt();
    }

    public int get() {
        return mDataPriorityPreference;
    }

    private boolean isValid(int mode) {
       // Check if mode has any bits outside the mask
       if ((mode & ~DATA_PRIORITY_SUB_MASK) != 0) {
           return false;
       }
       // Check if mode is one of the valid values
       return mode == DATA_PRIORITY_SUB_DEFAULT || mode == DATA_PRIORITY_SUB_MAX_TPUT;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mDataPriorityPreference);
    }

    public static final Parcelable.Creator<DataPriorityPreference> CREATOR =
            new Parcelable.Creator<DataPriorityPreference>() {
        public DataPriorityPreference createFromParcel(Parcel in) {
            return new DataPriorityPreference(in);
        }

        public DataPriorityPreference[] newArray(int size) {
            return new DataPriorityPreference[size];
        }
    };

    @Override
    public String toString() {
        return TAG + ": " + get();
    }
}
