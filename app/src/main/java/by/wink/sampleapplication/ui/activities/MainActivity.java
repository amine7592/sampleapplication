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
    Button showStudentsBtn;



    EditText insertText;
    TextView messageToShow;
    Button sendButton;

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

        insertText = (EditText)findViewById(R.id.insert_text);
        messageToShow = (TextView)findViewById(R.id.message_to_show);
        sendButton = (Button)findViewById(R.id.show);

        View.OnClickListener viualizza = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // textview             edittex
                messageToShow.setText(insertText.getText());

            }
        };

        sendButton.setOnClickListener(viualizza);



//        welcomeTv = (TextView) findViewById(R.id.welcome_tv);
//        changeTextBtn = (Button) findViewById(R.id.change_text_btn);
//        showStudentsBtn = (Button)findViewById(R.id.show_students_btn);
//        changeTextEdit = (EditText)findViewById(R.id.change_text_edit);
//        changeTextBtn.setOnClickListener(changeTxtBtnListener);
//        showStudentsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,StudentsListActivity.class);
//                startActivity(intent);
//            }
//        });

    }

  
}
