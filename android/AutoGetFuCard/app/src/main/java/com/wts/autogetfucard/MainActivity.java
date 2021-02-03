package com.wts.autogetfucard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wts.autogetfucard.receiver.SMSBroadcastReceiver;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mehdi.sakout.fancybuttons.FancyButton;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {
    private TextView msgText;
    private SMSBroadcastReceiver mSMSBroadcastReceiver;
    private EditText ipEdit;

    int permissioncamera;
    int permissionaudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] perms = {Manifest.permission.RECEIVE_SMS, Manifest.permission.INTERNET,
                Manifest.permission.READ_SMS};
        if (EasyPermissions.hasPermissions(MainActivity.this, perms)) {
            //有权限
        } else {
            //无权限
            EasyPermissions.requestPermissions(MainActivity.this, null, 100, perms);
        }


        msgText = findViewById(R.id.subTitle);
        ipEdit = findViewById(R.id.ip_edit);
        init();
    }

    private void init() {
        mSMSBroadcastReceiver = new SMSBroadcastReceiver();
        mSMSBroadcastReceiver.setOnReceivedMessageListener(new SMSBroadcastReceiver.MessageListener() {
            public void OnReceived(String message) {
                // TODO 正则判断，post请求
                msgText.setText(message);
                writeCode(message);
            }
        });
    }

    @SuppressLint({"WrongConstant", "ShowToast"})
    private void writeCode(String msg) {
        String ip = ipEdit.getText().toString();
        if (ip.equals("")) {
            Log.i("error", "填写IP");
            return;
        }

        String url = "http://" + ip + ":8080/msg";
        RequestBody requestBody = new FormBody.Builder()
                .add("msg", msg)
                .build();

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response);
            }
        });
    }

}