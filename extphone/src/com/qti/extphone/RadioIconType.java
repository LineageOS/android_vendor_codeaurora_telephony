/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class RadioIconType implements Parcelable {

    public static final int TYPE_NONE = 0;
    public static final int TYPE_5G_BASIC = 1;
    public static final int TYPE_5G_UWB = 2;
    public static final int TYPE_5G_PLUS_PLUS = 3;
    public static final int TYPE_LTE_NB_IOT = 4;

    private int mType;

    public RadioIconType(int type) {
        if (type < TYPE_NONE || type > TYPE_LTE_NB_IOT) {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
        mType = type;
    }

    public RadioIconType(Parcel in) {
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

    public static final Parcelable.Creator<RadioIconType> CREATOR =
            new Parcelable.Creator<RadioIconType>() {
        @Override
        public RadioIconType createFromParcel(Parcel in) {
            return new RadioIconType(in);
        }

        @Override
        public RadioIconType[] newArray(int size) {
            return new RadioIconType[size];
        }
    };

    @Override
    public String toString() {
        return "RadioIconType: " + mType;
    }
}
