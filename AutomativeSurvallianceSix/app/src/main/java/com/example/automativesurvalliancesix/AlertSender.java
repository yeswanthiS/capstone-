package com.example.automativesurvalliancesix;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class AlertSender {

    private static final String ALERT_URL = "https://automative-survalliance.onrender.com/api/alerts";

    public static void sendAlert(Context context, String message) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JSONObject alertData = new JSONObject();
        try {
            alertData.put("message", message);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, ALERT_URL, alertData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }
}
