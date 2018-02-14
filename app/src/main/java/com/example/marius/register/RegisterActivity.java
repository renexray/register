package com.example.marius.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnLogin = (Button) findViewById(R.id.Registerbtn2);
        final EditText etName = (EditText) findViewById(R.id.Nametxt);
        final EditText etEmail = (EditText) findViewById(R.id.Emailtxt);
        final EditText etPass = (EditText) findViewById(R.id.Passwordtxt);

        etName.setError(null);
        etEmail.setError(null);
        etPass.setError(null);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean cancel = false;
                if (!Validation.isValidCredentials(etName.getText().toString())) {
                    cancel = true;
                    etName.requestFocus();
                    etName.setError(getResources().getString(R.string.register_invalid_name));
                } else if (!Validation.isValidEmail(etEmail.getText().toString())) {
                    cancel = true;
                    etEmail.requestFocus();
                    etEmail.setError(getResources().getString(R.string.register_invalid_email));
                }else if (!Validation.isValidCredentials(etPass.getText().toString())) {
                    cancel = true;
                    etPass.requestFocus();
                    etPass.setError(getResources().getString(R.string.register_invalid_pass));
                }
                if (!cancel){
                    Toast.makeText(RegisterActivity.this,
                            "Prisijungimo vardas: " + etName.getText().toString() + "\n" +
                                    "Email: " + etEmail.getText().toString() + "\n" +
                                    "Slaptažodis: " + etPass.getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
