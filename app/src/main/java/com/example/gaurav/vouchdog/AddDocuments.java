package com.example.gaurav.vouchdog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
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

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDocuments extends AppCompatActivity {
    Spinner DocType,idType,Country,State;
    ImageButton img9,img10;
    EditText doi,validTill,ed42,ed43,fullname,issueby,city;
    ArrayAdapter<String> spinnerArrayAdapter;
    CheckBox chk13;
    Button save,upload;
    TextView tv40;
    int REQUEST_CODE_DOC=1;
    TextView tvListItem3, tvInvisibleError3, tvListItem4, tvInvisibleError4, tvListItem5, tvInvisibleError5, tvListItem6, tvInvisibleError6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_documents);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);

        DocType=(Spinner)findViewById(R.id.spinner);
        idType=(Spinner)findViewById(R.id.spinner1);
        Country=(Spinner)findViewById(R.id.spinner18);
        State=(Spinner)findViewById(R.id.spinner19);

        img9=(ImageButton)findViewById(R.id.imageButton9);
        img10=(ImageButton)findViewById(R.id.imageButton10);

        chk13=(CheckBox)findViewById(R.id.checkBox13);

        validTill=(EditText)findViewById(R.id.editText40);
        doi=(EditText)findViewById(R.id.editText39);
        ed42=(EditText)findViewById(R.id.editText42);
        ed43=(EditText)findViewById(R.id.editText43);
        fullname=(EditText)findViewById(R.id.editText10);
        issueby=(EditText)findViewById(R.id.editText21);
        city=(EditText)findViewById(R.id.editText41);

        save=(Button)findViewById(R.id.button17);
        upload=(Button)findViewById(R.id.button16);

        tv40=(TextView)findViewById(R.id.textView40);

        fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fullname.setError(null);

            }
        });
        issueby.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                issueby.setError(null);

            }
        });
        doi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                doi.setError(null);

            }
        });
        validTill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validTill.setError(null);

            }
        });
        ed42.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed42.setError(null);

            }
        });
        ed43.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed43.setError(null);

            }
        });
        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                city.setError(null);

            }
        });
        tv40.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv40.setError(null);

            }
        });



        String str1[]={"Document Type","Education Document","Work Document","Identification Document"};
        spinnerArrayAdapter = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str1);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        DocType.setAdapter(spinnerArrayAdapter);

        String str11[]={"Select"};
        ArrayAdapter<String> spinnerArrayAdapter6 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str11);
        spinnerArrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        idType.setAdapter(spinnerArrayAdapter6);

        DocType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    String str4[]={"Select","PhD/Doctoral","Masters Degree","Bachelors Degree","Diploma","Internship Certificate","Certificate Course","HSC(12th std)","SSC(10th std)"};
                    ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str4);
                    spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    idType.setAdapter(spinnerArrayAdapter2);
                    validTill.setVisibility(View.GONE);
                    img10.setVisibility(View.GONE);
                    chk13.setVisibility(View.GONE);
                    if(SetDocTypeError()==true)
                    {
                        tvListItem3.setError(null);
                        tvInvisibleError3.setError(null);
                    }
                }
                else if(position==2)
                {
                    String str4[]={"Select","Resume/CV","Appointment letter","Experience/Relieving Letter","Salary Slip"};
                    ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str4);
                    spinnerArrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    idType.setAdapter(spinnerArrayAdapter3);
                    validTill.setVisibility(View.VISIBLE);
                    img10.setVisibility(View.VISIBLE);
                    chk13.setVisibility(View.VISIBLE);
                    if(SetDocTypeError()==true)
                    {
                        tvListItem3.setError(null);
                        tvInvisibleError3.setError(null);
                    }
                }
                else if(position==3)
                {
                    String str4[]={"Select","Marriage Certificate","Passport","Driving License","PAN Card","Aadhar Card","Ration Card","Voter Id Card"};
                    ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str4);
                    spinnerArrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    idType.setAdapter(spinnerArrayAdapter4);
                    validTill.setVisibility(View.VISIBLE);
                    img10.setVisibility(View.VISIBLE);
                    chk13.setVisibility(View.VISIBLE);
                    if(SetDocTypeError()==true)
                    {
                        tvListItem3.setError(null);
                        tvInvisibleError3.setError(null);
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String str11[]={"Select"};
                ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str11);
                spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                idType.setAdapter(spinnerArrayAdapter5);
            }
        });
        idType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(SetDocError()==true)
                {
                    tvListItem4.setError(null);
                    tvInvisibleError4.setError(null);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        String str2[]={"Country","Australia","Canada","India","New Zealand","Singapore","United Kingdom","United States","Others"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddDocuments.this, android.R.layout.simple_spinner_item, str2);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        Country.setAdapter(spinnerArrayAdapter);

        String str10[]={"State"};
        ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str10);
        spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        State.setAdapter(spinnerArrayAdapter5);

        Country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    State.setVisibility(View.VISIBLE);
                    String str4[]={"State","Australian Capital Terrotory","New South Wales","Northern Territory","Queensland","South Australia","Tasmania","Victoria","Western Australia"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str4);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    State.setAdapter(spinnerArrayAdapter5);
                    ed42.setVisibility(View.GONE);
                    ed43.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem5.setError(null);
                        tvInvisibleError5.setError(null);
                    }

                }
                else if(position==2)
                {

                    State.setVisibility(View.VISIBLE);
                    String str5[]={"State","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland and Labrador","Northwest Territories","Nova Scotia","Nunavut","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str5);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    State.setAdapter(spinnerArrayAdapter5);
                    ed42.setVisibility(View.GONE);
                    ed43.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem5.setError(null);
                        tvInvisibleError5.setError(null);
                    }

                }

                else if(position==3)
                {

                    State.setVisibility(View.VISIBLE);
                    String str3[]={"State","Andhara Pradesh","Arunanchal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujrat","Haryana","Himanchal Pradesh","Jammu and Kashmir",
                            "Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha(Orissa)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
                            "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str3);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    State.setAdapter(spinnerArrayAdapter5);
                    ed42.setVisibility(View.GONE);
                    ed43.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem5.setError(null);
                        tvInvisibleError5.setError(null);
                    }

                }
                else if(position==4)
                {

                    State.setVisibility(View.VISIBLE);
                    String str6[]={"State","Auckland","Canterbur","Wellington","Waikato","Bay of Plenty","Manawatu-Wanganui","Otago","Hawke's Bay","Northland","Taranaki","Southland","Nelson","Gisborne","Marlborough","Tasman","West Coast"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str6);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    State.setAdapter(spinnerArrayAdapter5);
                    ed42.setVisibility(View.GONE);
                    ed43.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem5.setError(null);
                        tvInvisibleError5.setError(null);
                    }

                }

                else if(position==5)
                {

                    State.setVisibility(View.VISIBLE);
                    String str7[]={"State","Singapore"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str7);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    State.setAdapter(spinnerArrayAdapter5);
                    ed42.setVisibility(View.GONE);
                    ed43.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem5.setError(null);
                        tvInvisibleError5.setError(null);
                    }

                }
                else if(position==6)
                {

                    State.setVisibility(View.VISIBLE);
                    String str8[]={"State","London", "West Midlands", "Lancashire", "Nottinghamshire", "Cheshire", "Staffordshire", "Derbyshire", "Norfolk", "West Sussex", "Northamptonshire", "Oxfordshire", "Devon", "Suffolk",
                            "Lincolnshire", "Gloucestershire", "Leicestershire", "Cambridgeshire", "East Sussex", "Durham", "Bristol", "Warwickshire", "Buckinghamshire", "North Yorkshire", "Bedfordshire", "Cumbria",
                            "Somerset", "Cornwall", "Wiltshire", "Shropshire", "Leicester", "Worcestershire", "Kingston upon Hull", "Plymouth", "Stoke-on-Trent", "Derby", "Dorset", "Nottingham", "Southampton", "Brighton and Hove",
                            "Herefordshire", "Northumberland", "Portsmouth", "East Riding of Yorkshire", "Luton", "Blackpool", "North East Lincolnshire", "Middlesbrough", "Stockton-on-Tees", "Blackburn with Darwen", "Torbay",
                            "Poole", "Windsor and Maidenhead", "North Lincolnshire", "Bath and North East Somerset", "Slough", "Halton", "Isle of Wight", "Bracknell Forest", "Hartlepool", "Darlington", "West Berkshire",
                            "Redcar and Cleveland", "Wokingham", "Rutland"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str8);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    State.setAdapter(spinnerArrayAdapter5);
                    ed42.setVisibility(View.GONE);
                    ed43.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem5.setError(null);
                        tvInvisibleError5.setError(null);
                    }

                }
                else if(position==7)
                {

                    State.setVisibility(View.VISIBLE);
                    String str9[]={"State","Alabama", "Alaska", "Arizona", "Arkansas", "Armed Forces America", "Armed Forces Pacific", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia",
                            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                            "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str9);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    State.setAdapter(spinnerArrayAdapter5);
                    ed42.setVisibility(View.GONE);
                    ed43.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem5.setError(null);
                        tvInvisibleError5.setError(null);
                    }

                }
                else if(position==8)
                {
                    State.setVisibility(View.GONE);
                    ed42.setVisibility(View.VISIBLE);
                    ed43.setVisibility(View.VISIBLE);
                    checkState();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String str10[]={"State"};
                ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddDocuments.this,android.R.layout.simple_spinner_item, str10);
                spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                State.setAdapter(spinnerArrayAdapter5);
            }
        });
        State.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(SetStateError()==true)
                {
                    tvListItem6.setError(null);
                    tvInvisibleError6.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddDocuments.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        doi.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddDocuments.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        validTill.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        chk13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {

                    validTill.setText("N/A");
                    validTill.setEnabled(false);

                }
                else
                {
                    validTill.setEnabled(true);
                    validTill.setText("");
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validation();
                CheckDate();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDocument();
            }
        });

    }
    private void getDocument()
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/msword,application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
        startActivityForResult(intent, REQUEST_CODE_DOC);
    }

    private String getFileNameByUri(Context context, Uri uri)
    {
        String filepath = "";//default fileName
        //Uri filePathUri = uri;
        File file;
        if (uri.getScheme().toString().compareTo("content") == 0)
        {
            Cursor cursor = AddDocuments.this.getContentResolver().query(uri, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA, MediaStore.Images.Media.ORIENTATION }, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

            cursor.moveToFirst();

            String mImagePath = cursor.getString(column_index);
            cursor.close();
            filepath = mImagePath;

        }
        else
        if (uri.getScheme().compareTo("file") == 0)
        {
            try
            {
                file = new File(new URI(uri.toString()));
                if (file.exists())
                    filepath = file.getAbsolutePath();

            }
            catch (URISyntaxException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            filepath = uri.getPath();
        }
        return filepath;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

         if (requestCode == REQUEST_CODE_DOC)
            {
                Uri fileuri = data.getData();
                String docFilePath = getFileNameByUri(this, fileuri);
                String sub=docFilePath.substring(16);
                tv40.setText(sub);

            }
        }
    }

    public void CheckDate()
    {
        String from=doi.getText().toString();
        String to=validTill.getText().toString();
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
    public void checkState()
    {
        String country=ed42.getText().toString();
        String state1=ed43.getText().toString();
        if(country.isEmpty()==true ||state1.isEmpty()==true)
        {
            ed42.setError("Enter name of country");
            ed42.requestFocus();

            ed43.setError("Enter name of state");

        }

    }
    public void Validation()
    {
        String doc=DocType.getSelectedItem().toString();
        String doc1=idType.getSelectedItem().toString();
        String name=fullname.getText().toString();
        String issue=issueby.getText().toString();
        String DateofIssue=doi.getText().toString();
        String valid=validTill.getText().toString();
        String CountryName=Country.getSelectedItem().toString();
        String StateName=State.getSelectedItem().toString();
        String CityName=city.getText().toString();
        String file=tv40.getText().toString();

        if(doc =="Document Type")
        {
            SetDocTypeError();
        }
        else if(doc1=="Select")
        {
            SetDocError();
        }
        else if(name.isEmpty()==true)
        {
            fullname.setError("Enter full name");
            fullname.requestFocus();
        }
        else if(issue.isEmpty()==true)
        {
            issueby.setError("Enter Issuer name");
            issueby.requestFocus();
        }
        else if(DateofIssue.isEmpty()==true)
        {
           doi.setError("Enter date of Issue");
            doi.requestFocus();
        }
        else if(valid.isEmpty()==true && chk13.isChecked()==false && doc !="Education Document")
        {
            validTill.setError("Enter expiry date");
            validTill.requestFocus();
        }
        else if(CountryName == "Country")
        {
            SetCountryError();
        }
        else if(StateName == "State" && CountryName != "Others")
        {
            SetStateError();
        }
        else if(CityName.isEmpty()==true)
        {
            city.setError("Enter name of city");
            city.requestFocus();
        }
        else if(file.isEmpty()==true)
        {
            tv40.setError("Please choose a file");
            tv40.requestFocus();
        }

    }
    public boolean SetDocTypeError()
    {
        tvInvisibleError3=null;
        View view = DocType.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem3 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError3= (TextView)findViewById(R.id.tvInvisibleError3);

        // Shake and set error if in error state, otherwise clear error

        tvListItem3.setError("");
        tvListItem3.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError3.requestFocus();
        tvInvisibleError3.setError("Please select Document Type");

        return true;
    }
    public boolean SetDocError()
    {
        tvInvisibleError4=null;
        View view = idType.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem4 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError4= (TextView)findViewById(R.id.tvInvisibleError4);

        // Shake and set error if in error state, otherwise clear error

        tvListItem4.setError("");
        tvListItem4.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError4.requestFocus();
        tvInvisibleError4.setError("Please select a Document");

        return true;

    }
    public boolean SetCountryError()
    {
        tvInvisibleError5=null;
        View view = Country.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem5 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError5 = (TextView)findViewById(R.id.tvInvisibleError5);

        // Shake and set error if in error state, otherwise clear error

        tvListItem5.setError("");
        tvListItem5.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError5.requestFocus();
        tvInvisibleError5.setError("Please select a country");

        return true;
    }
    public boolean SetStateError()
    {
        View view = State.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem6 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError6 = (TextView)findViewById(R.id.tvInvisibleError6);

        // Shake and set error if in error state, otherwise clear error

        tvListItem6.setError(null);
        tvListItem6.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError6.requestFocus();
        tvInvisibleError6.setError("Please select a State");

        return true;
    }
}
