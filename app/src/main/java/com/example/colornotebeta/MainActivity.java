package com.example.colornotebeta;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int requestCode = 1000;
    public static final String EXTRA_MESSAGE
            = "com.example.colornotebeta";
    SharedPreferences dataStore;
    String input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textView);
        textView.setOnClickListener(onClick_text);
        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);
        input = dataStore.getString("input",null);
        textView.setText(input);


    };

    private View.OnClickListener onClick_text = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, SubActivity.class);
            i.putExtra("key",input );
            startActivityForResult( i, requestCode );

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == requestCode &&
                null != data) {
            String res = data.getStringExtra(MainActivity.EXTRA_MESSAGE);
            textView.setText(res);

            SharedPreferences.Editor editor = dataStore.edit();
            editor.putString("input",res);
            editor.apply();
            Log.v("activityResult",res);
            textView.setText(res);
        }
    }
}