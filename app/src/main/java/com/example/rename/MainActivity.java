package com.example.rename;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.opengl.ETC1.isValid;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final EditText username = (EditText) findViewById(R.id.username);
       final EditText password = (EditText) findViewById(R.id.password);

        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {

                boolean cancel = false;
                focusView = null;

                if (isValid(username.getText().toString()) {
                    username.setError(getString(R.string.login_invalid_username));
                    cancel = true;
                }


                if (isValid(password.getText().toString()) {
                        password.setError(getString(R.string.login_invalid_password));
                        cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {
                        //Perform action on click
                        Intent activityChangeIntent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(activityChangeIntent);
                }




                Toast.makeText(MainActivity.this, username.getText().toString() + "\n" + password.getText().toString(),
                        Toast.LENGTH_LONG).show();


            }
        });


    }

    private boolean isValid(String credentials) {
        final String CREDENTIALS_PATTERN ="^([a-z0-9_-]{3-20})+$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(CREDENTIALS_PATTERN);

        return matcher.matches();


    }
}