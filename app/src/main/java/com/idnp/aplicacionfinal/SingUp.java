package com.idnp.aplicacionfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SingUp extends AppCompatActivity {

    EditText username, email, password, confirmPassword;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        username = (EditText) findViewById(R.id.input_username);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        confirmPassword = (EditText) findViewById(R.id.input_confirmPassword);

        registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUsername() | !validateEmail() | !validatePassword() | validateConfirmPassword())
                    return;
            }
        });
    }

    public Boolean validateUsername(){
        String value = username.getText().toString();
        String noWhiteSpaces = "(?=\\s+$)";

        if(value.isEmpty()){
            username.setError("Rellene el campo vacio");
            return false;
        }else if(value.length() >= 15){
            username.setError("Nombre de usuario muy largo");
            return false;
        }else if(!value.matches(noWhiteSpaces)) {
            username.setError("No estan permitidos los espacio en blanco");
            return false;
        }else{
            username.setError(null);
            return true;
        }
    }

    public Boolean validateEmail(){
        String value = email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(value.isEmpty()){
            email.setError("Rellene el campo vacio");
            return false;
        }else if(!value.matches(emailPattern)) {
            email.setError("Correo electronico invalido");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String value = password.getText().toString();
        String passwordPattern = "^"+
                "(?=.*[a-zA-Z0-9])" +   //cualquier caracter
                "(?=\\s+$)" +           //sin espacios en blanco
                ".{4,}" +               //mas de 4 caracteres
                "$";

        if(value.isEmpty()){
            email.setError("Rellene el campo vacio");
            return false;
        }else if(!value.matches(passwordPattern)) {
            email.setError("contraseña invalido");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    public Boolean validateConfirmPassword(){
        String pass = password.getText().toString();
        String confPass = confirmPassword.getEditableText().toString();

        return pass.equals(confPass) ? true : false;
    }
}