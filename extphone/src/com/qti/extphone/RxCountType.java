/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class RxCountType implements Parcelable {

    public static final int TYPE_NONE = 0;
    public static final int TYPE_5G_6RX = 1;

    private int mType;

    public RxCountType(int type) {
        if (type < TYPE_NONE || type > TYPE_5G_6RX) {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
        mType = type;
    }

    public RxCountType(Parcel in) {
        mType = in.readInt();
    }

    public int get() {
        return mType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mType);
    }

    public static final Parcelable.Creator<RxCountType> CREATOR =
            new Parcelable.Creator<RxCountType>() {
        @Override
        public RxCountType createFromParcel(Parcel in) {
            return new RxCountType(in);
        }

        @Override
        public RxCountType[] newArray(int size) {
            return new RxCountType[size];
        }
    };

    @Override
    public String toString() {
        return "RxCountType: " + mType;
    }
}
