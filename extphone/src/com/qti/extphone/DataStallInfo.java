/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Data stall information to be sent to RIL
 */
public class DataStallInfo implements Parcelable {
    private static final String TAG = "DataStallInfo";

    /**
     * Indicates data stall status:
     * true - data stall detected
     * false - data stall recovered or no data stall
     */
    private boolean mIsDataStalled;

    public DataStallInfo(boolean isDataStalled) {
        mIsDataStalled = isDataStalled;
    }

    public DataStallInfo(Parcel in) {
        mIsDataStalled = in.readBoolean();
    }

    public boolean isDataStalled() {
        return mIsDataStalled;
    }

    public void setDataStalled(boolean isDataStalled) {
        mIsDataStalled = isDataStalled;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBoolean(mIsDataStalled);
    }

    public static final Parcelable.Creator<DataStallInfo> CREATOR =
            new Parcelable.Creator<DataStallInfo>() {
                @Override
                public DataStallInfo createFromParcel(Parcel in) {
                    return new DataStallInfo(in);
                }

                @Override
                public DataStallInfo[] newArray(int size) {
                    return new DataStallInfo[size];
                }
            };

    @Override
    public String toString() {
        return "DataStallInfo{" +
                "isDataStalled=" + mIsDataStalled +
                '}';
    }
}
