/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class AuxiliaryRadioIconInfo implements Parcelable {

    private static final String TAG = "AuxiliaryRadioIconInfo";

    // DSDA categories
    public static final int DSDA_CATEGORY_NONE = 0;
    public static final int DSDA_CATEGORY_GENERAL = 1 << 0;
    public static final int DSDA_CATEGORY_TURBO = 1 << 1;

    private int mDsdaCategory;

    public AuxiliaryRadioIconInfo(int dsdaCategory) {
        mDsdaCategory = dsdaCategory;
    }

    public AuxiliaryRadioIconInfo(Parcel in) {
        mDsdaCategory = in.readInt();
    }

    public int getDsdaCategory() {
        return mDsdaCategory;
    }

    public String getDsdaCategoryString() {
        String base = "DSDA category = ";
        switch (mDsdaCategory) {
            case DSDA_CATEGORY_NONE:
                return base + "NONE";
            case DSDA_CATEGORY_GENERAL:
                return base + "GENERAL";
            case DSDA_CATEGORY_TURBO:
                return base + "TURBO";
            default:
                return base + "UNKNOWN";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mDsdaCategory);
    }

    public static final Parcelable.Creator<AuxiliaryRadioIconInfo> CREATOR
            = new Parcelable.Creator<AuxiliaryRadioIconInfo>() {
        public AuxiliaryRadioIconInfo createFromParcel(Parcel in) {
            return new AuxiliaryRadioIconInfo(in);
        }

        public AuxiliaryRadioIconInfo[] newArray(int size) {
            return new AuxiliaryRadioIconInfo[size];
        }
    };

    @Override
    public String toString() {
        return TAG + ": " + getDsdaCategoryString();
    }
}
