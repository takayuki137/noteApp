
package com.example.colornotebeta;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    EditText textView;
    SharedPreferences datastore;
    String le;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView=findViewById(R.id.textView2);
        datastore = getSharedPreferences("DataStore", MODE_PRIVATE);
        le = datastore.getString("input",null);
        textView.setText(le);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp() {
        Intent intentSub = new Intent();
            String str = textView.getText().toString();
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, str);
            Log.v("backActivityresult",str);

        setResult(RESULT_OK, intentSub);

        finish();

        return super.onSupportNavigateUp();
    }

}