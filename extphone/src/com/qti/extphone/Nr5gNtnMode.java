/*
 * Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class Nr5gNtnMode implements Parcelable {

    private static final String TAG = "Nr5gNtnMode";

    /**
     * Disable NR5G NTN (Non-Terrestrial Network)
     */
    public static final int DISABLE = 0;

    /**
     * Enable NR5G NTN along with other existing RATs (Radio Access Technologies).
     * In this mode, NR5G NTN is enabled in addition to terrestrial networks,
     * allowing the device to connect to both satellite and terrestrial networks.
     */
    public static final int ENABLE = 1;

    /**
     * Enable NR5G NTN in test mode: NR5G NTN only mode.
     * In this mode, only NR5G NTN is enabled and all other RATs are disabled,
     * forcing the device to connect exclusively to satellite networks.
     */
    public static final int TEST = 2;

    private int mMode;

    /**
     * Check if the given mode value is valid.
     *
     * @param mode The mode value to validate
     * @return true if the mode is valid (DISABLE, ENABLE, or TEST), false otherwise
     */
    public static boolean isValidMode(int mode) {
        return mode == DISABLE || mode == ENABLE || mode == TEST;
    }

    public Nr5gNtnMode(int mode) {
        if (!isValidMode(mode)) {
            throw new IllegalArgumentException("Invalid Nr5gNtnMode: " + mode +
                    ". Valid values are DISABLE(0), ENABLE(1), or TEST(2)");
        }
        mMode = mode;
    }

    public Nr5gNtnMode(Parcel in) {
        mMode = in.readInt();
    }

    public int get() {
        return mMode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mMode);
    }

    public static final Parcelable.Creator<Nr5gNtnMode> CREATOR =
            new Parcelable.Creator<Nr5gNtnMode>() {
        @Override
        public Nr5gNtnMode createFromParcel(Parcel in) {
            return new Nr5gNtnMode(in);
        }

        @Override
        public Nr5gNtnMode[] newArray(int size) {
            return new Nr5gNtnMode[size];
        }
    };

    @Override
    public String toString() {
        return "Nr5gNtnMode: " + mMode;
    }
}
