package com.example.gaurav.vouchdog;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyVouching extends AppCompatActivity {
   Spinner thisIs,Relationship,code;
    CheckBox chk14;
    EditText ed48,ed49,email,PersonName,org,phone;
    ImageButton dates,to;
    Button Send;
    TextView tvListItem1, tvInvisibleError1,tvListItem2, tvInvisibleError2;
    TextInputLayout inputLayoutEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vouching);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);

        thisIs=(Spinner)findViewById(R.id.spinner20);
        Relationship=(Spinner)findViewById(R.id.spinner21);
        code=(Spinner)findViewById(R.id.spinner22);

        chk14=(CheckBox)findViewById(R.id.checkBox14);

        ed48=(EditText)findViewById(R.id.editText48);
        ed49=(EditText)findViewById(R.id.editText49);
        email=(EditText)findViewById(R.id.editText44);
        PersonName=(EditText)findViewById(R.id.editText45);
        org=(EditText)findViewById(R.id.editText46);
        phone=(EditText)findViewById(R.id.editText47);

        dates=(ImageButton)findViewById(R.id.imageButton11);
        to=(ImageButton)findViewById(R.id.imageButton12);

        Send=(Button)findViewById(R.id.button18);
        inputLayoutEmail = (TextInputLayout)findViewById(R.id.input_layout_email);


        String str1[]={"This is a *","Professional Vouching","Academic Vouching"};
       ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(MyVouching.this,android.R.layout.simple_spinner_item, str1);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        thisIs.setAdapter(spinnerArrayAdapter);

        String str4[]={"Relationship *","Supervisor","Peer","Direct Report","Teacher","Professor","Dean","Principal","No Working Relationship","Other"};
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(MyVouching.this,android.R.layout.simple_spinner_item, str4);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        Relationship.setAdapter(spinnerArrayAdapter2);

        String str2[]={"Select","AU+61","CA+1","IN+91","NZ+63","SG+65","US+1","UK+44","Other"};
        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(MyVouching.this, android.R.layout.simple_spinner_item, str2);
        spinnerArrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        code.setAdapter(spinnerArrayAdapter3);

        thisIs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(SetError()==true)
                {
                    tvListItem1.setError(null);
                    tvInvisibleError1.setError(null);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Relationship.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(SetRelError()==true) {
                    tvListItem2.setError(null);
                    tvInvisibleError2.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
                   // inputLayoutEmail.setErrorEnabled(false);
                }



            }
        });
        PersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                PersonName.setError(null);

            }
        });
        org.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                org.setError(null);

            }
        });
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                phone.setError(null);

            }
        });
        ed48.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed48.setError(null);

            }
        });

        ed49.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed49.setError(null);

            }
        });


        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckDates();
                Validation();
            }
        });

        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(MyVouching.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        ed48.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(MyVouching.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        ed49.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        chk14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {

                    ed49.setText("N/A");
                    ed49.setEnabled(false);

                }
                else
                {
                    ed49.setEnabled(true);
                    ed49.setText("");
                }
            }
        });
    }
    public void CheckDates()
    {
        String from=ed48.getText().toString();
        String to=ed49.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = formatter.parse(from);
            Date date2 = formatter.parse(to);
            if (date2.compareTo(date1)<0)
            {
                Toast.makeText(getApplicationContext()," Please check the selected dates!",Toast.LENGTH_LONG).show();
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void Validation()
    {
        String This=thisIs.getSelectedItem().toString();
        String Rel=Relationship.getSelectedItem().toString();
        String Email=email.getText().toString();
        String name=PersonName.getText().toString();
        String Organization=org.getText().toString();
        String PhoneNo=phone.getText().toString();
        String MobileCode=code.getSelectedItem().toString();
        String Association=ed48.getText().toString();
        String to=ed49.getText().toString();

        if(This == "This is a *")
        {
            SetError();
        }
        else if(Rel == "Relationship *")
        {
            SetRelError();
        }
        else if(Email.isEmpty()==true)
        {
            validateEmail();
        }
        else if(name.isEmpty()==true)
        {
            PersonName.setError("Enter name of Person");
            PersonName.requestFocus();
        }
        else if(Organization.isEmpty()==true)
        {
            org.setError("Enter Organization Name");
            org.requestFocus();
        }
        else if(PhoneNo.isEmpty()==true)
        {
            phone.setError("Please enter valid Phone Number ");
            phone.requestFocus();
        }
        else if(MobileCode == "Select")
            {
               Toast.makeText(getApplicationContext(),"Please select Country code before Mobile Number",Toast.LENGTH_LONG).show();
            }
        else if(Association.isEmpty()==true)
        {
            ed48.setError("Enter date of association ");
            ed48.requestFocus();
        }
        else if(to.isEmpty()==true && chk14.isChecked()!=true)
        {
            ed49.setError("Enter expiry date of association");
            ed49.requestFocus();
        }

    }
    public boolean SetError()

    {
        tvInvisibleError1=null;
        View view = thisIs.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem1 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError1 = (TextView)findViewById(R.id.tvInvisibleError1);

        // Shake and set error if in error state, otherwise clear error

        tvListItem1.setError("");
        tvListItem1.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError1.requestFocus();
        tvInvisibleError1.setError("Please select type of Vouching ");
        return true;
    }
    public boolean SetRelError()
    {
        tvInvisibleError2=null;
        View view = thisIs.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem2 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError2 = (TextView)findViewById(R.id.tvInvisibleError2);

        // Shake and set error if in error state, otherwise clear error

        tvListItem2.setError("");
        tvListItem2.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError2.requestFocus();
        tvInvisibleError2.setError("Please select type of Relationship ");
        return true;
    }
    private boolean validateEmail() {
        String Email =email.getText().toString().trim();

        if (Email.isEmpty() || !isValidEmail(Email)) {
           // inputLayoutEmail.setError(getString(R.string.err_msg_email));
            email.setError("Enter valid email address");
            email.requestFocus();
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }
}
