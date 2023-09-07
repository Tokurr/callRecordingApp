package com.ft.callrecording;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyPhoneStateListener extends PhoneStateListener {

    private Context context;

    private CallRecordingManager callRecordingManager;


    public MyPhoneStateListener(Context context ) {
        this.context = context;
        callRecordingManager = new CallRecordingManager(context);
    }

    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);


        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                callRecordingManager.stopRecording();
                showToast("Cagri Yok");
                break;
            case TelephonyManager.CALL_STATE_RINGING:

                showToast("Telefon Caliyor");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                showToast("Konuşma Halinde");

                callRecordingManager.startRecording();
                break;
        }
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


}