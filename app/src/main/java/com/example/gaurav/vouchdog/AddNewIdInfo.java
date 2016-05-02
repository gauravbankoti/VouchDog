package com.example.gaurav.vouchdog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewIdInfo extends AppCompatActivity {
        Spinner idtype,country,state;
        EditText ExpiryDate,ed36,ed37,Docnum,Name,IssueDate,City;
        Button b8,upload;
        CheckBox ck10;
        ImageButton SelectDate,SelectExpiryDate;
    ImageView ivImage;
    TextView tvListItem, tvInvisibleError, tvListItem2, tvInvisibleError2,tvListItem3, tvInvisibleError3;
    TextView tv39;

    int REQUEST_CAMERA = 0, SELECT_FILE = 1,REQUEST_CODE_DOC=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_id_info);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);
        ExpiryDate=(EditText)findViewById(R.id.editText35);
        ed36=(EditText)findViewById(R.id.editText36);
        ed37=(EditText)findViewById(R.id.editText37);
        Docnum=(EditText)findViewById(R.id.editText31);
        Name=(EditText)findViewById(R.id.editText32);
        IssueDate=(EditText)findViewById(R.id.editText33);
        City=(EditText)findViewById(R.id.editText34);
        tv39=(TextView)findViewById(R.id.textView39);

        idtype=(Spinner)findViewById(R.id.spinner10);
        b8=(Button)findViewById(R.id.button8);
        upload=(Button)findViewById(R.id.button12);
        ck10=(CheckBox)findViewById(R.id.checkBox10);
        country=(Spinner)findViewById(R.id.spinner11);
        state=(Spinner)findViewById(R.id.spinner12);
        SelectDate=(ImageButton)findViewById(R.id.imageButton2);
        SelectExpiryDate=(ImageButton)findViewById(R.id.imageButton3);
        ivImage=(ImageView)findViewById(R.id.imageView2);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });


        Docnum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Docnum.setError(null);

            }
        });
        Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Name.setError(null);

            }
        });
        IssueDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                IssueDate.setError(null);

            }
        });

        ExpiryDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ExpiryDate.setError(null);

            }
        });
        City.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                City.setError(null);

            }
        });
        ed36.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed36.setError(null);

            }
        });
        ed37.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed37.setError(null);

            }
        });
        tv39.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv39.setError(null);
            }
        });


        String str2[]={"ID Type*","Passport","Driving License","PAN Card","Voter Id Card","Aadhar Card","Ration Card"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddNewIdInfo.this, android.R.layout.simple_spinner_item, str2);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        idtype.setAdapter(spinnerArrayAdapter);
        SelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddNewIdInfo.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        IssueDate.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        SelectExpiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddNewIdInfo.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        ExpiryDate.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validation();
               CheckDate();
            }
        });
        ck10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {

                    ExpiryDate.setText("N/A");
                    ExpiryDate.setEnabled(false);

                }
                else
                {
                    ExpiryDate.setEnabled(true);
                    ExpiryDate.setText("");
                }
            }
        });


        String str3[]={"Country","Australia","Canada","India","New Zealand","Singapore","United Kingdom","United States","Others"};
        ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str3);
        spinnerArrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        country.setAdapter(spinnerArrayAdapter4);

        String str10[]={"State"};
        ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str10);
        spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        state.setAdapter(spinnerArrayAdapter5);

        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    ed36.setVisibility(View.GONE);
                    state.setVisibility(View.VISIBLE);
                    String str4[]={"State","Australian Capital Terrotory","New South Wales","Northern Territory","Queensland","South Australia","Tasmania","Victoria","Western Australia"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str4);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    state.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }


                }
                else if(position==2)
                {
                    ed36.setVisibility(View.GONE);
                    state.setVisibility(View.VISIBLE);
                    String str5[]={"State","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland and Labrador","Northwest Territories","Nova Scotia","Nunavut","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str5);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    state.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }


                }

                else if(position==3)
                {
                    ed36.setVisibility(View.GONE);
                    state.setVisibility(View.VISIBLE);
                    String str3[]={"State","Andhara Pradesh","Arunanchal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujrat","Haryana","Himanchal Pradesh","Jammu and Kashmir",
                            "Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha(Orissa)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
                            "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str3);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    state.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }

                }
                else if(position==4)
                {
                    ed36.setVisibility(View.GONE);
                    state.setVisibility(View.VISIBLE);
                    String str6[]={"State","Auckland","Canterbur","Wellington","Waikato","Bay of Plenty","Manawatu-Wanganui","Otago","Hawke's Bay","Northland","Taranaki","Southland","Nelson","Gisborne","Marlborough","Tasman","West Coast"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str6);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    state.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }

                }

                else if(position==5)
                {
                    ed36.setVisibility(View.GONE);
                    state.setVisibility(View.VISIBLE);
                    String str7[]={"State","Singapore"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str7);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    state.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }


                }
                else if(position==6) {
                    ed36.setVisibility(View.GONE);
                    state.setVisibility(View.VISIBLE);
                    String str8[] = {"State", "London", "West Midlands", "Lancashire", "Nottinghamshire", "Cheshire", "Staffordshire", "Derbyshire", "Norfolk", "West Sussex", "Northamptonshire", "Oxfordshire", "Devon", "Suffolk",
                            "Lincolnshire", "Gloucestershire", "Leicestershire", "Cambridgeshire", "East Sussex", "Durham", "Bristol", "Warwickshire", "Buckinghamshire", "North Yorkshire", "Bedfordshire", "Cumbria",
                            "Somerset", "Cornwall", "Wiltshire", "Shropshire", "Leicester", "Worcestershire", "Kingston upon Hull", "Plymouth", "Stoke-on-Trent", "Derby", "Dorset", "Nottingham", "Southampton", "Brighton and Hove",
                            "Herefordshire", "Northumberland", "Portsmouth", "East Riding of Yorkshire", "Luton", "Blackpool", "North East Lincolnshire", "Middlesbrough", "Stockton-on-Tees", "Blackburn with Darwen", "Torbay",
                            "Poole", "Windsor and Maidenhead", "North Lincolnshire", "Bath and North East Somerset", "Slough", "Halton", "Isle of Wight", "Bracknell Forest", "Hartlepool", "Darlington", "West Berkshire",
                            "Redcar and Cleveland", "Wokingham", "Rutland"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this, android.R.layout.simple_spinner_dropdown_item, str8);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    state.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }
                }
                else if(position==7)
                {
                    ed36.setVisibility(View.GONE);
                    state.setVisibility(View.VISIBLE);
                    String str9[]={"State","Alabama", "Alaska", "Arizona", "Arkansas", "Armed Forces America", "Armed Forces Pacific", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia",
                            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                            "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str9);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    state.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetCountryError()==true)
                    {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }

                }
                else if(position==8)
                {
                    ed37.setVisibility(View.VISIBLE);
                    ed36.setVisibility(View.VISIBLE);
                    state.setVisibility(View.GONE);
                    checkState();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String str10[]={"State"};
                ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddNewIdInfo.this,android.R.layout.simple_spinner_dropdown_item, str10);
                spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                state.setAdapter(spinnerArrayAdapter5);
            }
        });
        idtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(SelectIdType()== true) {
                    tvListItem.setError(null);
                    tvInvisibleError.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

//        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(SetCountryError()==true)
//                {
//                    tvListItem2.setError(null);
//                    tvInvisibleError2.setError(null);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(SetStateError()==true)
                {
                    tvListItem3.setError(null);
                    tvInvisibleError3.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public void CheckDate()
    {
        String from=IssueDate.getText().toString();
        String to=ExpiryDate.getText().toString();
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
        String country=ed36.getText().toString();
        String state1=ed37.getText().toString();
        if(country.isEmpty()==true ||state1.isEmpty()==true)
        {
            ed36.setError("Enter name of country");
            ed36.requestFocus();

            ed37.setError("Enter name of state");

        }

    }
    public void Validation()
    {
        String Idtype=idtype.getSelectedItem().toString();
        String docnum=Docnum.getText().toString();
        String name=Name.getText().toString();
        String issueDate=IssueDate.getText().toString();
        String expirydate=ExpiryDate.getText().toString();
        String Country=country.getSelectedItem().toString();
        String State=state.getSelectedItem().toString();
        String city=City.getText().toString();
        String file=tv39.getText().toString();
        if(Idtype == "ID Type*")
        {
            SelectIdType();
        }
        else if(docnum.isEmpty()==true)
        {
            Docnum.setError("Enter Document Number");
            Docnum.requestFocus();
        }
        else if(name.isEmpty()==true)
        {
            Name.setError("Enter your full name");
            Name.requestFocus();
        }
        else if(issueDate.isEmpty()==true)
        {
            IssueDate.setError("Please enter Date of Issue");
            IssueDate.requestFocus();
        }
        else if(expirydate.isEmpty()==true && ck10.isChecked()==false)
        {
            ExpiryDate.setError("Please enter Date of Expiry");
            ExpiryDate.requestFocus();
        }
        else if(Country == "Country")
        {
            SetCountryError();

        }
        else if(State == "State")
        {
            SetStateError();
        }
        else if(city.isEmpty()==true)
        {
            City.setError("Enter name of city");
            City.requestFocus();
        }
        else if(file.isEmpty()==true)
        {
            tv39.setError("Please choose a file");
            tv39.requestFocus();
        }

    }


    public boolean SelectIdType()
    {
        tvInvisibleError=null;
        View view = idtype.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError = (TextView)findViewById(R.id.tvInvisibleError1);

        // Shake and set error if in error state, otherwise clear error

        tvListItem.setError("");
       // tvListItem.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW
        
        tvInvisibleError.setError("Please select IDtype of Document");
        tvInvisibleError.requestFocus();
       // idtype.requestFocus();
        return true;
    }
    public boolean SetCountryError()
    {
        tvInvisibleError2=null;
        View view = country.getSelectedView();

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
        tvInvisibleError2.setError("Please select a country");

        return true;
    }
    public boolean SetStateError()
    {
        View view = state.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem3 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError3 = (TextView)findViewById(R.id.tvInvisibleError3);

        // Shake and set error if in error state, otherwise clear error

        tvListItem3.setError(null);
        tvListItem3.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError3.requestFocus();
        tvInvisibleError3.setError("Please select a State");

        return true;
    }
    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose Photo from Library","Choose File from Directory",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(AddNewIdInfo.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose Photo from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE);
                }
                else if(items[item].equals("Choose File from Directory"))
                {
                    getDocument();
                }
                else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
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
            Cursor cursor = AddNewIdInfo.this.getContentResolver().query(uri, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA, MediaStore.Images.Media.ORIENTATION }, null, null, null);
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
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
            else if (requestCode == REQUEST_CODE_DOC)
            {
                Uri fileuri = data.getData();
                String docFilePath = getFileNameByUri(this, fileuri);
                String sub=docFilePath.substring(16);
               tv39.setText(sub);
                ivImage.setImageURI(fileuri);
            }
        }
    }
    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 50, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage.setImageBitmap(thumbnail);
        String name=data.getDataString();
        tv39.setText(name);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri= data.getData();
        String[] projection = { MediaStore.MediaColumns.DATA};
        Cursor cursor = AddNewIdInfo.this.getContentResolver().query(selectedImageUri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);

        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 100;
        int scale = 1;
        while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);

        ivImage.setImageBitmap(bm);
        String name=data.getDataString();
        tv39.setText(name);
    }

}
