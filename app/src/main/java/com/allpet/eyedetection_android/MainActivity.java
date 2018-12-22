package com.allpet.eyedetection_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private EditText mNameView;
    private EditText mThresholdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up the login form.

        mNameView = findViewById(R.id.dog_name);
        mThresholdView = findViewById(R.id.threshold);
    }

    public void onStartClick(View view){

        String name = mNameView.getText().toString();
        String threshold = mThresholdView.getText().toString();

        if (name.isEmpty())
        {
            mNameView.setError(getString(R.string.error_field_required));
            mNameView.requestFocus();
            return;
        }
        if (threshold.isEmpty())
        {
            mThresholdView.setError(getString(R.string.error_field_required));
            mThresholdView.requestFocus();
            return;
        }

        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
