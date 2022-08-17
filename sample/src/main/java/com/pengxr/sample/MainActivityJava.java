package com.pengxr.sample;

import android.os.Bundle;

import com.pengxr.modular.eventbus.generated.events.EventDefineOfLoginEvents;
import com.pengxr.sampleloginlib.events.UserInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

/**
 * <p>
 * Created by pengxr on 15/8/2022
 */
class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventDefineOfLoginEvents.login().observeForever(new Observer<UserInfo>() {
            @Override
            public void onChanged(@NonNull UserInfo userInfo) {

            }
        });

        EventDefineOfLoginEvents.logout().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(Void unused) {

            }
        });
    }
}
