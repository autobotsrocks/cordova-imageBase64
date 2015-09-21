package com.autobots;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import android.util.Base64;

public class ImageBase64 extends CordovaPlugin {
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("base64")) {
            final String imagePath = args.getString(0);
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    try {
                        File file = new File(imagePath);
                        byte[] bytes = FileUtils.readFileToByteArray(file);
                        String imageBase64 = Base64.encodeToString(bytes, 0, bytes.length, Base64.NO_WRAP);
                        callbackContext.success(imageBase64);
                    } catch (IOException exception) {
                        callbackContext.error(exception.getMessage());
                    }
                }
            });
        }
        return true;
    }
}