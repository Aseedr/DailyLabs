package com.example.uljan.dailylabs.storage;

import java.io.IOException;

public interface StorageFileProperties {
    void putProperty(String key, String value) throws IOException;

    String getProperty(String key) throws IOException;
}
