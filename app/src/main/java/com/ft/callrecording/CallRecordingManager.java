package com.ft.callrecording;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CallRecordingManager {


    private MediaRecorder mediaRecorder;
    private boolean isRecording = false;



    public CallRecordingManager(Context context) {

    }


    public void startRecording() {
        if (!isRecording) {


            String kayitDizini = String.valueOf(Environment.getExternalStorageDirectory());
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            kayitDizini = kayitDizini + File.separator + "seskaydi" + timeStamp + ".mp3";

            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(kayitDizini);
            System.out.println(kayitDizini);
            try {

                mediaRecorder.prepare();
                mediaRecorder.start();
                isRecording = true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopRecording() {
        if (isRecording && mediaRecorder != null) {
            System.out.println("kayıt bitti");
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
            isRecording = false;
        }





    }
}