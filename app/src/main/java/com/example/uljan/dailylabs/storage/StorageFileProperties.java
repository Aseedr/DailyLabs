package com.example.uljan.dailylabs.storage;

import android.content.Context;

import java.io.IOException;

public interface StorageFileProperties {
    void putProperty(String value, Context context) throws IOException;

    String getProperty(Context context) throws IOException;
}
