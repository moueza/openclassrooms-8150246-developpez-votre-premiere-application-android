package com.moueza.superquiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.moueza.superquiz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "Peter";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity.onCreate() called");

        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }


    /**
     * @param resId
     */
  /*  @Override
    public void setTheme(int resId) {
        super.setTheme(resId);
    }
*/

    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity.onStart() called");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity.onResume() called");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity.onPause() called");

    }

    /**
     *
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity.onStop() called");

    }

    /**
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity.onDestroy() called");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity.onRestart() called");

    }
}