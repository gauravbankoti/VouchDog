package com.example.gaurav.vouchdog;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignActivity extends AppCompatActivity {
    Button btn3;
    Spinner code;
    EditText first,last,email,pass,confirm,mobile,invisible;
    CheckBox chk1;
    //temp
   Pattern pattern;
    Matcher matcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);

        first=(EditText)findViewById(R.id.editText);
        last=(EditText)findViewById(R.id.editText2);
        email=(EditText)findViewById(R.id.editText3);
        pass=(EditText)findViewById(R.id.editText4);
        confirm=(EditText)findViewById(R.id.editText5);
        mobile=(EditText)findViewById(R.id.editText6);
        invisible=(EditText)findViewById(R.id.editText55);

        chk1=(CheckBox)findViewById(R.id.checkBox1);


        btn3 =(Button)findViewById(R.id.button3);


        code=(Spinner)findViewById(R.id.spinner2);



        first.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                first.setError(null);

            }
        });
        last.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                last.setError(null);

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
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pass.setError("Enter password of more than 8 characters which contain at least 1 capital letter,1 numeric and 1 special ");

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(PasswordValidator()==true)
                {
                    pass.setError(null);
                }

            }
        });

        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mobile.setError(null);

            }
        });



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MobileNo=mobile.getText().toString();
                validation();
                if(chk1.isChecked()==true && MobileNo.isEmpty()==false)
                {
                    Intent intent=new Intent(getApplicationContext(),SecurityQuesActivity.class);
                    startActivity(intent);
                }


            }
        });


        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {

                    invisible.setError(null);
                    invisible.setVisibility(View.INVISIBLE);
                }
//                else
//                {
//                    ExpiryDate.setEnabled(true);
//                    ExpiryDate.setText("");
//                }
            }
        });

        String str10[]={"Select","AU+61","CA+1","IN+91","NZ+63","SG+65","US+1","UK+44","Other"};
        ArrayAdapter<String> spinnerArrayAdapter10 = new ArrayAdapter<String>(SignActivity.this, android.R.layout.simple_spinner_item, str10);
        spinnerArrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        code.setAdapter(spinnerArrayAdapter10);
    }
    public boolean validation() {
        String FirstName = first.getText().toString();
        int len1 = first.length();
        String LastName = last.getText().toString();
        int len2 = last.length();
        String Email = email.getText().toString();
        String password = pass.getText().toString();
        String ConfirmPass = confirm.getText().toString();


        if (FirstName.isEmpty() == true)
        {
            first.setError("Enter your first name");
            first.requestFocus();
        }


        else if (len1 < 3) {
            first.setError("Please match the format requested");
            first.requestFocus();
        }

        else if (LastName.isEmpty() == true) {
            last.setError("Enter your last name");
            last.requestFocus();
        }

        else if (len2 < 3) {
            last.setError("Please match the format requested");
            last.requestFocus();
        }

        else if (Email.isEmpty() == true) {
            validateEmail();
        }

        else if (password.isEmpty() == true) {
            pass.setError("Enter password of more than 8 characters which contain at least 1 capital letter,1 numeric and 1 special ");
            pass.requestFocus();
        }
        else if (ConfirmPass.isEmpty() == true)
        {
            confirm.setError("Enter password again");
            confirm.requestFocus();
        }
        else if(ConfirmPass.isEmpty()==false)
        {
            if(password.equals(ConfirmPass))
            {
               // Toast.makeText(getApplicationContext(),"Password match",Toast.LENGTH_LONG).show();
                NewValidation();
            }
            else
            {
                confirm.setError("Incorrect password");
                confirm.requestFocus();
            }
        }


        else if (password.isEmpty() == false)
        {
           PasswordValidator();
        }


        return true;
    }
    public void NewValidation()

    {
        String MobileNo=mobile.getText().toString();
        String Code=code.getSelectedItem().toString();
        if(MobileNo.isEmpty()==true)
        {
        mobile.setError("Enter valid Mobile Number");
        mobile.requestFocus();
        }

        else if(Code == "Select")
        {
            Toast.makeText(getApplicationContext(),"Please select country code before Mobile Number",Toast.LENGTH_LONG).show();
        }
        else if(chk1.isChecked()==false)
        {
            invisible.setVisibility(View.VISIBLE);
            invisible.setError("Please accept Terms and Condition to continue");
            invisible.requestFocus();
        }

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
    public boolean PasswordValidator(){

        String password = pass.getText().toString().trim();
          String PASSWORD_PATTERN =
                "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

        /**
         * Validate password with regular expression
         * @param password password for validation
         * @return true valid password, false invalid password
         */
        pattern = Pattern.compile(PASSWORD_PATTERN);

        if(!validate(password))
        {
            pass.setError("Enter password of more than 8 characters which contain at least 1 capital letter,1 numeric and 1 special ");
            pass.requestFocus();
            return false;
        }
        return true;

    }

    public boolean validate(String password){

        matcher = pattern.matcher(password);
        return matcher.matches();

    }

}
