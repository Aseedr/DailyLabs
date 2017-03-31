package com.example.uljan.dailylabs.storage.impl;

import com.example.uljan.dailylabs.storage.StorageFileProperties;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

import java.io.IOException;

public final class StorageFilePropertiesImpl implements StorageFileProperties {

    public static final String FILE_NAME = "app.properties";

    final String LOG_TAG = "myLogs";
    final String DIR_SD = "DailyLabs";
    final String FILENAME_SD_KEY = "key_file";
    final String FILENAME_SD_VALUE = "value_file";

    @Override
    public void putProperty(String key, String value) throws IOException {
        //TODO

        // check SD-card status
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-card not found: " + Environment.getExternalStorageState());
            return;
        }
        // get path to SD-card
        File sdPath = Environment.getExternalStorageDirectory();
        // adding my directory to path
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // make new directory
        sdPath.mkdirs();
        // make object File which contains path to file
        File sdFile_key = new File(sdPath, FILENAME_SD_KEY);
        try {
            // make write thread
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile_key));
            // write data
            bw.write(key);
            // close thread
            bw.close();
            Log.d(LOG_TAG, "File is recorded on SD-card: " + sdFile_key.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // make object File which contains path to file
        File sdFile_value = new File(sdPath, FILENAME_SD_VALUE);
        try {
            // make write thread
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile_value));
            // write data
            bw.write(value);
            // close thread
            bw.close();
            Log.d(LOG_TAG, "File is recorded on SD-card: " + sdFile_value.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProperty(String key) throws IOException {
        //TODO

        // check SD-card status
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-card not found: " + Environment.getExternalStorageState());
            return null;
        }
        // get path to SD-card
        File sdPath = Environment.getExternalStorageDirectory();
        // adding my directory to path
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // make object File which contains path to file
        File sdFile = new File(sdPath, FILENAME_SD_KEY);
        try {
            // open read thread
            BufferedReader br = new BufferedReader(new FileReader(sdFile));
            // read key
            while ((key = br.readLine()) != null) {
                Log.d(LOG_TAG, key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return key;
    }


}
