package com.example.widoki;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ThirdActivity extends AppCompatActivity {
    private ArrayAdapter<String> lifecycleAdapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ListView listViewLifecycle = findViewById(R.id.listViewLifecycle);
        lifecycleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listViewLifecycle.setAdapter(lifecycleAdapter);

        logLifecycleState("➕ onCreate()");
    }
    @Override protected void onStart() {
        super.onStart();
        logLifecycleState("🚀 onStart()");
    }
    @Override protected void onResume() {
        super.onResume();
        logLifecycleState("▶️ onResume()");
    }
    @Override protected void onPause() {
        super.onPause();
        logLifecycleState("⏸️ onPause()");
    }
    @Override protected void onStop() {
        super.onStop();
        logLifecycleState("🛑 onStop()");
    }
    @Override protected void onRestart() {
        super.onRestart();
        logLifecycleState("🔄️ onRestart()");
    }
    // 💣 @Override onDestroy() nie jest potrzebny, bo i tak nie zobaczymy tego stanu na liście

    private void logLifecycleState(String state) {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());

        String timestamp = time.format(new Date());
        String lifecycleItem = "[" + timestamp + "] " + state;

        lifecycleAdapter.add(lifecycleItem);
    }
}
