package com.cpr.controlled;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import dmax.dialog.SpotsDialog;

public class GetResultFromURL extends AsyncTask<String, Void, String> {
    private TextView txt;
    private Context context;
    private SpotsDialog spotsDialog;


    public GetResultFromURL(TextView txt, Context context) {
        this.txt = txt;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        spotsDialog = new SpotsDialog(context, R.style.Custom);
        spotsDialog.getWindow().setBackgroundDrawable(new
                ColorDrawable(Color.TRANSPARENT));
        spotsDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String s = strings[0];
        String content = "";
        try {
            URL url = new URL(s);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            content = reader.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.e("TAG","S " + s);
        spotsDialog.cancel();
        txt.setText(s);

    }
}
