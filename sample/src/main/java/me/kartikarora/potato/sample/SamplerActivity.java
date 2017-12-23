package me.kartikarora.potato.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by kartik on 23/12/17.
 */

public class SamplerActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampler);

        String samplerFor = getIntent().getStringExtra("sampler_for");
        try {
            Object object = Class.forName(samplerFor).newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.sampler_frame, (Fragment) object).commit();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "An issue occured, please try again", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }
}
