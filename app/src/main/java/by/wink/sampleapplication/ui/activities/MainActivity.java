package by.wink.sampleapplication.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import by.wink.sampleapplication.R;

/**
 * Created by amine on 25/01/17.
 */

public class MainActivity extends Activity {


    public static final String USERNAME_KEY = "username";

    TextView welcomeTv;
    Button changeTextBtn;
    EditText changeTextEdit;
    MainActivity activity = this;
    String username;

    View.OnClickListener changeTxtBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            username = changeTextEdit.getText().toString();
            Intent intent = new Intent(activity,SecondActivity.class);
            intent.putExtra(USERNAME_KEY,username);
            intent.putExtra("age",18);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeTv = (TextView) findViewById(R.id.welcome_tv);
        changeTextBtn = (Button) findViewById(R.id.change_text_btn);
        changeTextEdit = (EditText)findViewById(R.id.change_text_edit);
        changeTextBtn.setOnClickListener(changeTxtBtnListener);

    }



}
