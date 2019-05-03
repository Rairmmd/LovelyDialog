package com.rair.dialog;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rairmmd.lovelydialog.Animation;
import com.rairmmd.lovelydialog.Icon;
import com.rairmmd.lovelydialog.LovelyDialog;
import com.rairmmd.lovelydialog.LovelyDialogCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new LovelyDialog.Builder(this).setTitle("LoveLy Dialog").setContent("一个好看的Dialog")
                .setAnimation(Animation.POP).setIcon(R.mipmap.ic_launcher_round, Icon.VISIBLE)
                .setBarColor(R.color.colorPrimaryDark).setPositiveColor(R.color.colorAccent)
                .setNegativeColor(R.color.colorPrimary).onPositive(new LovelyDialogCallback() {
            @Override
            public void onClick(@NonNull Dialog dialog) {
                showToast("你点击了Positive按钮");
            }
        }).onNegative(new LovelyDialogCallback() {
            @Override
            public void onClick(@NonNull Dialog dialog) {
                showToast("你点击了Negative按钮");
            }
        }).build().show();
    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
