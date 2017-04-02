package com.example.uljan.dailylabs.storage.impl;

import android.content.Context;

import com.example.uljan.dailylabs.storage.StorageFileProperties;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;


import java.io.IOException;

public final class StorageFilePropertiesImpl implements StorageFileProperties {

    final String FILENAME = "daily";

    @Override
    public void putProperty(String key, String value, Context context) {

        try {
            // delete file
            File file = new File(FILENAME);
            file.delete();

            // open write thread
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    context.openFileOutput(FILENAME, context.MODE_PRIVATE)));
            // writing data
            bw.write(key);
            bw.write('=');
            bw.write(value);
            bw.flush();
            // close thread
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProperty(Context context) {

        String temp = "";

        try {
            // open read thread
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    context.openFileInput(FILENAME)));

            // read
            temp = br.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }


}
