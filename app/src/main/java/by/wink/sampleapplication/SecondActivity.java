package by.wink.sampleapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView nameTV;
    Intent intent;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameTV = (TextView)findViewById(R.id.name_tv);
        intent = getIntent();
        username = intent.getStringExtra(MainActivity.USERNAME_KEY);
        nameTV.setText(username);

    }
}
