package com.cpr.controlled;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import dmax.dialog.SpotsDialog;

public class ControlLed extends AsyncTask<String, Void, String> {
    private TextView txt;
    private Context context;
    private SpotsDialog dialog;

    public ControlLed(TextView txt, Context context) {
        this.txt = txt;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new SpotsDialog(context, R.style.Custom);
        dialog.getWindow().setBackgroundDrawable(new
                ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String s = strings[0]; // dieu khien den
        String s1 = strings[1]; // lay du lieu dieu khien den
        String content = "";
        try {
            URL url = new URL(s);
            URL url1 = new URL(s1);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(url1.openStream()));
            content = reader1.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    protected void onPostExecute(String s) {
        txt.setText(s);
        dialog.cancel();
    }
}
