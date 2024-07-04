package com.example.automativesurvalliancesix;

import android.content.Context;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class ImageSender {

    private static final String IMAGE_URL = "https://automative-survalliance.onrender.com/api/images";

    public static void sendImage(Context context, String base64Image) {
        OkHttpClient client = new OkHttpClient();

        JSONObject imageData = new JSONObject();
        try {
            imageData.put("data", base64Image);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"), imageData.toString());

        Request request = new Request.Builder()
                .url(IMAGE_URL)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Handle failure
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Handle response
            }
        });
    }
}
