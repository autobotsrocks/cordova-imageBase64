package com.autobots;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;

import android.util.Base64;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageBase64 extends CordovaPlugin {
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("base64")) {
            final String imagePath = args.getString(0);
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                    if (bitmap == null) {
                        callbackContext.error("");
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        String imageBase64 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
                        callbackContext.success(imageBase64);
                    }
                }
            });
        }
        return true;
    }
}