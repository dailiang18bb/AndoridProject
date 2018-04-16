package com.pace.cs639spring.hw5;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Make this class implement Parcelable. Making an object implement Parcelable allows objects to be stored in a Bundle.
 * This makes it fairly easy to pass objects between Activities and Fragments. This is not the only way to do this,
 * but it is probably the easiest.
 *
 * https://developer.android.com/reference/android/os/Parcelable.html
 */
public class TabInformation implements Parcelable {

    String mName;
    String mBiography;

    TabInformation(String name, String biography) {
        mName = name;
        mBiography = biography;
    }

    protected TabInformation(Parcel in) {
        mName = in.readString();
        mBiography = in.readString();
    }

    public static final Creator<TabInformation> CREATOR = new Creator<TabInformation>() {
        @Override
        public TabInformation createFromParcel(Parcel in) {
            return new TabInformation(in);
        }

        @Override
        public TabInformation[] newArray(int size) {
            return new TabInformation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mBiography);
    }
}


