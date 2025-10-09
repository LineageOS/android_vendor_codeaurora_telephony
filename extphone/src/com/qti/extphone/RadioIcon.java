/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class RadioIcon implements Parcelable {

    private RadioIconType mType;
    private RxCountType mRxCount;

    public RadioIcon(RadioIconType type, RxCountType rxCount) {
        if (type == null) {
            throw new IllegalArgumentException("RadioIconType cannot be null");
        }

        if (rxCount == null) {
            throw new IllegalArgumentException("RxCountType cannot be null");
        }

        mType = type;
        mRxCount = rxCount;
    }

    public RadioIcon(Parcel in) {
        mType = new RadioIconType(in.readInt());
        mRxCount = new RxCountType(in.readInt());
    }

    public RadioIconType getType() {
        return mType;
    }

    public RxCountType getRxCount() {
        return mRxCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mType.get());
        dest.writeInt(mRxCount.get());
    }

    public static final Parcelable.Creator<RadioIcon> CREATOR =
            new Parcelable.Creator<RadioIcon>() {
        @Override
        public RadioIcon createFromParcel(Parcel in) {
            return new RadioIcon(in);
        }

        @Override
        public RadioIcon[] newArray(int size) {
            return new RadioIcon[size];
        }
    };

    @Override
    public String toString() {
        return "RadioIcon: type=" + mType + ", rxCount=" + mRxCount;
    }
}
