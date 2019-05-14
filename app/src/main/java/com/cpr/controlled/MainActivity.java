package com.cpr.controlled;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnOnLed1;
    private Button btnOffLed1;
    private Button btnOnLed2;
    private Button btnOffLed2;
    private Button btnOnLed3;
    private Button btnOffLed3;
    private Button btnOnQuat;
    private Button btnOffQuat;
    private TextView txtStateLed1;
    private TextView txtStateLed2;
    private TextView txtStateLed3;
    private TextView txtStateQuat;
    private TextView txtNhietDo;
    private TextView txtDoAm;
    private TextView txtCanhBao;
    private String state1;
    private String state2;
    private String state3;
    private String stateQuat;
    private String nhietDo;
    private String doAm;
    private String canhCao;

    private Handler updateState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        updateState = new Handler();
    }


    private void init() {
        btnOnLed1 = findViewById(R.id.btnOnLed1);
        btnOffLed1 = findViewById(R.id.btnOffLed1);
        btnOnLed2 = findViewById(R.id.btnOnLed2);
        btnOffLed2 = findViewById(R.id.btnOffLed2);
        btnOnLed3 = findViewById(R.id.btnOnLed3);
        btnOffLed3 = findViewById(R.id.btnOffLed3);
        btnOffQuat = findViewById(R.id.btnOffQuat);
        btnOnQuat = findViewById(R.id.btnOnQuat);
        txtStateLed1 = findViewById(R.id.textViewResultLed1);
        txtStateLed2 = findViewById(R.id.textViewResultLed2);
        txtStateLed3 = findViewById(R.id.textViewResultLed3);
        txtStateQuat = findViewById(R.id.textViewResultQuat);
        txtNhietDo = findViewById(R.id.textViewNhietDo);
        txtDoAm = findViewById(R.id.textViewDoAm);
        txtCanhBao = findViewById(R.id.textViewDoAT);

        btnOnLed1.setOnClickListener(this);
        btnOnLed2.setOnClickListener(this);
        btnOnLed3.setOnClickListener(this);
        btnOnQuat.setOnClickListener(this);
        btnOffLed1.setOnClickListener(this);
        btnOffLed2.setOnClickListener(this);
        btnOffLed3.setOnClickListener(this);
        btnOffQuat.setOnClickListener(this);

        updateState();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOnLed1: {
                new ControlLed(txtStateLed1, this).execute(Server.DEN_1_ON, Server.DEN_1);
            }
            break;
            case R.id.btnOffLed1: {
                new ControlLed(txtStateLed1, this).execute(Server.DEN_1_OFF, Server.DEN_1);

            }
            break;
            case R.id.btnOnLed2: {
                new ControlLed(txtStateLed2, this).execute(Server.DEN_2_ON, Server.DEN_2);
            }
            break;
            case R.id.btnOnLed3: {
                new ControlLed(txtStateLed3, this).execute(Server.DEN_3_ON, Server.DEN_3);
            }
            break;
            case R.id.btnOffLed3: {
                new ControlLed(txtStateLed3, this).execute(Server.DEN_3_OFF, Server.DEN_3);
            }
            break;
            case R.id.btnOffLed2: {
                new ControlLed(txtStateLed2, this).execute(Server.DEN_2_OFF, Server.DEN_2);
            }
            break;
            case R.id.btnOnQuat: {
                new ControlLed(txtStateQuat, this).execute(Server.DONG_CO_ON, Server.DONG_CO);
            }
            break;
            case R.id.btnOffQuat: {
                new ControlLed(txtStateQuat, this).execute(Server.DONG_CO_OFF, Server.DONG_CO);
            }
            break;
        }
    }

    private void updateState() {
        new GetResultFromURL(txtStateLed1, this).execute(Server.DEN_1);
        new GetResultFromURL(txtStateLed2, this).execute(Server.DEN_2);
        new GetResultFromURL(txtStateLed3, this).execute(Server.DEN_3);
        new GetResultFromURL(txtStateQuat, this).execute(Server.DONG_CO);
        new GetResultFromURL(txtNhietDo, this).execute(Server.NHIET_DO);
        new GetResultFromURL(txtDoAm, this).execute(Server.DO_AM);
        new GetResultFromURL(txtCanhBao, this).execute(Server.AN_TOAN);
    }


}
