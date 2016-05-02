package com.example.gaurav.vouchdog;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SecurityQuesActivity extends AppCompatActivity {
    Spinner ques1,ques2;
    Button save;
    EditText Ans1,Ans2,ed57;

    TextView tvListItem1, tvInvisibleError1, tvListItem2, tvInvisibleError2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_ques);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);
        ques1=(Spinner)findViewById(R.id.spinner23);
        ques2=(Spinner)findViewById(R.id.spinner24);
        save=(Button)findViewById(R.id.button5);

        Ans1=(EditText)findViewById(R.id.editText54);
        Ans2=(EditText)findViewById(R.id.editText56);


        ques1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(CheckQues()==true)
                {
                    tvListItem1.setError(null);
                    tvInvisibleError1.setError(null);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ques2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(CheckQues1()==true)
                {
                    tvListItem2.setError(null);
                    tvInvisibleError2.setError(null);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Ans1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               Ans1.setError(null);

            }
        });
        Ans2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Ans2.setError(null);

            }
        });



        String str10[]={"Select","What is your Childhood Nickname?","What is the name of your favorite friend?","What was your favorite food?","What is your favorite animal?","In what city was your first job?"};
        ArrayAdapter<String> spinnerArrayAdapter10 = new ArrayAdapter<String>(SecurityQuesActivity.this, android.R.layout.simple_spinner_item, str10);
        spinnerArrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        ques1.setAdapter(spinnerArrayAdapter10);

        String str11[]={"Select"};
        ArrayAdapter<String> spinnerArrayAdapter11 = new ArrayAdapter<String>(SecurityQuesActivity.this, android.R.layout.simple_spinner_item, str11);
        spinnerArrayAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        ques2.setAdapter(spinnerArrayAdapter11);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String q1=ques1.getSelectedItem().toString();
                String a1=Ans1.getText().toString();
                String q2=ques2.getSelectedItem().toString();
                String a2=Ans2.getText().toString();
                if(q1 == "Select")
                {
                  CheckQues();
                }
                else if(a1.isEmpty()==true)
                {
                    Ans1.setError("Enter Answer");
                    Ans1.requestFocus();
                }
                else if(q2 == "Select")
                {
                    CheckQues1();
                }
                else if(a2.isEmpty()==true)
                {
                    Ans2.setError("Enter Answer");
                    Ans2.requestFocus();
                }
                else {
                    Intent intent=new Intent(getApplicationContext(),SignUp.class);
                    startActivity(intent);
                }

            }
        });


        ques1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    String str10[]={"Select","What is the name of your favorite friend?","What was your favorite food?","What is your favorite animal?","In what city was your first job?"};
                    ArrayAdapter<String> spinnerArrayAdapter10 = new ArrayAdapter<String>(SecurityQuesActivity.this, android.R.layout.simple_spinner_item, str10);
                    spinnerArrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    ques2.setAdapter(spinnerArrayAdapter10);
                }
                else if(position==2)
                {
                    String str10[]={"Select","What is your Childhood Nickname?","What was your favorite food?","What is your favorite animal?","In what city was your first job?"};
                    ArrayAdapter<String> spinnerArrayAdapter10 = new ArrayAdapter<String>(SecurityQuesActivity.this, android.R.layout.simple_spinner_item, str10);
                    spinnerArrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    ques2.setAdapter(spinnerArrayAdapter10);
                }
                else if(position==3)
                {
                    String str10[]={"Select","What is your Childhood Nickname?","What is the name of your favorite friend?","What is your favorite animal?","In what city was your first job?"};
                    ArrayAdapter<String> spinnerArrayAdapter10 = new ArrayAdapter<String>(SecurityQuesActivity.this, android.R.layout.simple_spinner_item, str10);
                    spinnerArrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    ques2.setAdapter(spinnerArrayAdapter10);
                }
                else if(position==4)
                {
                    String str10[]={"Select","What is your Childhood Nickname?","What is the name of your favorite friend?","What was your favorite food?","In what city was your first job?"};
                    ArrayAdapter<String> spinnerArrayAdapter10 = new ArrayAdapter<String>(SecurityQuesActivity.this, android.R.layout.simple_spinner_item, str10);
                    spinnerArrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    ques2.setAdapter(spinnerArrayAdapter10);
                }
                else if(position==5)
                {
                    String str10[]={"Select","What is your Childhood Nickname?","What is the name of your favorite friend?","What was your favorite food?","What is your favorite animal?"};
                    ArrayAdapter<String> spinnerArrayAdapter10 = new ArrayAdapter<String>(SecurityQuesActivity.this, android.R.layout.simple_spinner_item, str10);
                    spinnerArrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    ques2.setAdapter(spinnerArrayAdapter10);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public boolean CheckQues()
    {

        tvInvisibleError1=null;
        View view = ques1.getSelectedView();

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
        tvInvisibleError1.setError("Please select a question");
        return true;
    }
    public boolean CheckQues1()
    {

        tvInvisibleError2=null;
        View view = ques2.getSelectedView();

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
        tvInvisibleError2.setError("Please select a question");
        return true;
    }
}
