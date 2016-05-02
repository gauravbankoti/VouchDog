package com.example.gaurav.vouchdog;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShareDocActivity extends AppCompatActivity {
    EditText email,Recname,subject;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_doc);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);

        email=(EditText)findViewById(R.id.editText50);
        Recname=(EditText)findViewById(R.id.editText51);
        subject=(EditText)findViewById(R.id.editText52);

        save=(Button)findViewById(R.id.button19);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validation();
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(validateEmail()==true)
                {
                    email.setError(null);

                }
            }
        });
        Recname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Recname.setError(null);

            }
        });
        subject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                subject.setError(null);

            }
        });

    }
    public boolean Validation()
    {
        String EmailId=email.getText().toString();
        String rec=Recname.getText().toString();
        //int len=Recname.length();
        String Sub=subject.getText().toString();
        if(EmailId.isEmpty()==true)
        {
            validateEmail();
        }
        else if(rec.isEmpty()==true )
        {

            Recname.setError("Please enter Recipient Name");
            Recname.requestFocus();
        }
        else if(Sub.isEmpty()==true)
        {
            subject.setError("Enter Subject");
            subject.requestFocus();
        }

        return true;
    }
    private boolean validateEmail() {
        String Email =email.getText().toString().trim();

        if (Email.isEmpty() || !isValidEmail(Email)) {
            email.setError("Enter valid email address");
            email.requestFocus();
            return false;
        }

        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }
}
