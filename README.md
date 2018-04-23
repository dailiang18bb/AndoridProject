# AndoridProject
This repo contain my android project



# Deal with the input block the View

### If has List View
`android:scrollbars="none"` 会导致屏幕上移，删掉屏幕不上移


http://www.360doc.com/content/17/0518/13/41302481_654978536.shtml

In the Manifest.xml use`adjustResize` or `adjestPan`

    <activity
            android:name=".MainActivity"
            android:windowSoftInputMode="adjustResize">

# Providing Up Navigation

https://developer.android.com/training/implementing-navigation/ancestral.html

# Android Drawing Separator/Divider Line in Layout?

    <View
    android:layout_width="match_parent"
    android:layout_height="1dp"
    android:background="@android:color/darker_gray"/>
