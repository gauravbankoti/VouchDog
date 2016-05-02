package com.example.gaurav.vouchdog;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
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

public class AddWorkExp extends AppCompatActivity {
    EditText ed33,ed34,ed38,cmpname,title,loc,base,total;
    Button save;
    CheckBox ck11;
    Spinner country, currency;
    TextView tvListItem, tvInvisibleError,tvListItem1, tvInvisibleError1;
    ImageButton img5,img6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_exp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);

        ed33=(EditText)findViewById(R.id.editText33);
        ed34=(EditText)findViewById(R.id.editText34);
        ed38=(EditText)findViewById(R.id.editText38);
        cmpname=(EditText)findViewById(R.id.editText31);
        base=(EditText)findViewById(R.id.editText36);
        total=(EditText)findViewById(R.id.editText37);
        loc=(EditText)findViewById(R.id.editText35);
        title=(EditText)findViewById(R.id.editText32);
        ck11=(CheckBox)findViewById(R.id.checkBox11);
        save=(Button)findViewById(R.id.button11);
        country=(Spinner)findViewById(R.id.spinner15);
        currency=(Spinner)findViewById(R.id.spinner16);
        img5=(ImageButton)findViewById(R.id.imageButton5);
        img6=(ImageButton)findViewById(R.id.imageButton6);

        cmpname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            cmpname.setError(null);
            }
        });
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                title.setError(null);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddWorkExp.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        ed33.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddWorkExp.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code to get date and time    */
                        selectedmonth=selectedmonth+1;
                        ed34.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        ed38.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed38.setError(null);

            }
        });
        ed33.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed33.setError(null);
            }
        });
        ed34.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed34.setError(null);
            }
        });
        loc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                loc.setError(null);

            }
        });
        currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(CheckCurrency()==true)
                {
                    tvListItem1.setError(null);
                    tvInvisibleError1.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        base.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                base.setError(null);

            }
        });
        total.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                total.setError(null);

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               CheckDates();
                String CompanyName=cmpname.getText().toString();
                String Title=title.getText().toString();
                String Country=country.getSelectedItem().toString();
                String empfrom=ed33.getText().toString();
                String empto=ed34.getText().toString();
                String Location=loc.getText().toString();
                String curr=currency.getSelectedItem().toString();
                String BasePay=base.getText().toString();
                String TotalCmp=total.getText().toString();
                if(CompanyName.isEmpty()==true)
                {
                    cmpname.setError("Enter company name");
                    cmpname.requestFocus();
                }
                else if(Title.isEmpty()==true)
                {
                    title.setError("Enter Title");
                    title.requestFocus();
                }
                else if(Country=="Country")
                {
                    SetCountryError();
                }
                else if(empfrom.isEmpty()==true)
                {
                    ed33.setError("Enter date of Employment");
                    ed33.requestFocus();
                }
                else if(empto.isEmpty()==true && ck11.isChecked()==false)
                {
                    ed34.setError("Enter date of Employment");
                    ed34.requestFocus();
                }
                else if(Location.isEmpty()==true)
                {
                    loc.setError("Enter Location");
                    loc.requestFocus();
                }
                else if(curr == "Currency")
                {
                    CheckCurrency();
                }
                else if(BasePay.isEmpty()==true)
                {
                    base.setError("Enter base pay");
                    base.requestFocus();
                }
                else if(TotalCmp.isEmpty()==true)
                {
                    total.setError("enter total compensation");
                    total.requestFocus();
                }
            }
        });

        String str2[]={"Country","Australia","Canada","India","New Zealand","Singapore","United Kingdom","United States","Others"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddWorkExp.this, android.R.layout.simple_spinner_item, str2);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        country.setAdapter(spinnerArrayAdapter);

        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 if(position==0)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==1)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==2)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==3)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==4)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==5)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==6)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==7)
                {
                    ed38.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
               else if(position==8) {
                    ed38.setVisibility(View.VISIBLE);
                     CheckCountry();
//                    if(SetCountryError()==true)
//                    {
//                        tvListItem.setError(null);
//                        tvInvisibleError.setError(null);
//                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ed38.setVisibility(View.GONE);

            }
        });

        String str3[]={"Currency","USD","GBP","SGD","CAD","AUD","NZD","INR"};
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(AddWorkExp.this, android.R.layout.simple_spinner_item, str3);
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        currency.setAdapter(spinnerArrayAdapter1);

        ck11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {

                    ed34.setText("N/A");
                    ed34.setEnabled(false);

                }
                else
                {
                    ed34.setEnabled(true);
                    ed34.setText("");
                }
            }
        });


    }
    public void CheckDates()
    {
        String from=ed33.getText().toString();
        String to=ed34.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = formatter.parse(from);
            Date date2 = formatter.parse(to);
            if (date2.compareTo(date1)<0)
            {
                Toast.makeText(getApplicationContext(),"Employement dates are invalid",Toast.LENGTH_LONG).show();
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void  CheckCountry()
    {
        String cmpname=ed38.getText().toString();
        if(cmpname.isEmpty()==true)
        {
            ed38.setError("Enter name of Country");
            ed38.requestFocus();
        }
    }
    public boolean SetCountryError()
    {
        tvInvisibleError=null;
        View view = country.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError = (TextView)findViewById(R.id.tvInvisibleError);

        // Shake and set error if in error state, otherwise clear error

        tvListItem.setError("");
        tvListItem.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError.requestFocus();
        tvInvisibleError.setError("Please select a country");

        return true;
    }
    public boolean CheckCurrency()
    {
        tvInvisibleError1=null;
        View view = currency.getSelectedView();

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
        tvInvisibleError1.setError("Please select currency");

        return true;
    }
}
