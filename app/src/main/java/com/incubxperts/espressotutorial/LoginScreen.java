package com.incubxperts.espressotutorial;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    EditText InputUsername, InputPassword;
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        InputUsername = (EditText) findViewById(R.id.input_username);
        InputPassword = (EditText) findViewById(R.id.input_password);
        LoginButton = (Button) findViewById(R.id.button_login);
        LoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                if (InputPassword.getText().toString().trim().equals("") || InputUsername.getText().toString().trim().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Username or Password should not be empty")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .show();
                } else if (InputPassword.getText().toString().trim().equals(InputUsername.getText().toString().trim())) {
                    startActivity(new Intent(this, Dashboard.class));
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Username or Password is incorrect.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .show();
                }
                break;
        }
    }
}