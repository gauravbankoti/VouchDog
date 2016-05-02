package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaurav.vouchdog.AddAddress;
import com.example.gaurav.vouchdog.R;


public class Fragment2 extends Fragment{
    Spinner s3,s4,s5,s6,s7,s8,s9;
    View v;
    EditText ed18,ed19,ed20,ed23,ed24,ed8,ed36,ed25,ed26,ed27,ed28,ed37,ed38,ed29,ed30,inputEmail,alternateemail;
    CheckBox Mobile,work,home,primary,alternate, chk9;
    Button save;
    TextView AddAddr;
    ViewPager viewPager;
    private TextInputLayout inputLayoutEmail,input_layout_AlternateEmail,input_layout_mobileno;
   TextView tvListItem,tvInvisibleError,tvListItem1,tvInvisibleError1,tvListItem2,tvInvisibleError2,tvListItem3,tvInvisibleError3;


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment2, container, false);

        s3=(Spinner)v.findViewById(R.id.spinner3);
        s4=(Spinner)v.findViewById(R.id.spinner4);
        s5=(Spinner)v.findViewById(R.id.spinner5);
        s6=(Spinner)v.findViewById(R.id.spinner6);
        s7=(Spinner)v.findViewById(R.id.spinner7);
        s8=(Spinner)v.findViewById(R.id.spinner8);
        s9=(Spinner)v.findViewById(R.id.spinner9);


        ed8=(EditText)v.findViewById(R.id.editText8);
        ed18=(EditText)v.findViewById(R.id.editText18);
        ed19=(EditText)v.findViewById(R.id.editText19);
        ed20=(EditText)v.findViewById(R.id.editText20);
        ed36=(EditText)v.findViewById(R.id.editText36);
        ed23=(EditText)v.findViewById(R.id.editText23);
        ed24=(EditText)v.findViewById(R.id.editText24);
        ed25=(EditText)v.findViewById(R.id.editText25);
        ed26=(EditText)v.findViewById(R.id.editText26);
        ed27=(EditText)v.findViewById(R.id.editText27);
        ed28=(EditText)v.findViewById(R.id.editText28);
        ed37=(EditText)v.findViewById(R.id.editText37);
        ed38=(EditText)v.findViewById(R.id.editText38);
        ed29=(EditText)v.findViewById(R.id.editText29);
        ed30=(EditText)v.findViewById(R.id.editText30);
        inputEmail=(EditText)v.findViewById(R.id.input_email);
        alternateemail=(EditText)v.findViewById(R.id.editText22);

        tvInvisibleError1 = (TextView)v.findViewById(R.id.tvInvisibleError2);
        tvInvisibleError3 = (TextView)v.findViewById(R.id.tvInvisibleError4);


        alternate=(CheckBox)v.findViewById(R.id.checkBox8);

        alternateemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateAltEmail();
                if(validateAltEmail()==true)
                {
                    alternateemail.setError(null);
                }

            }
        });
        inputEmail.addTextChangedListener(new TextWatcher() {
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
                    inputEmail.setError(null);
                }

            }
        });


        AddAddr=(TextView)v.findViewById(R.id.textView14);
        AddAddr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddAddress.class);
                startActivity(intent);
            }
        });


        ed24.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (chk9.isChecked()) {
                    ed27.setText(s);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed24.setError(null);
            }
        });


        ed23.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (chk9.isChecked()) {
                    ed28.setText(s);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed25.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (chk9.isChecked()) {
                    ed29.setText(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                ed25.setError(null);
            }
        });
        ed26.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (chk9.isChecked()) {
                    ed30.setText(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            ed26.setError(null);
            }
        });
        ed18.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            ed18.setError(null);
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
        ed27.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            ed27.setError(null);
            }
        });
        ed29.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            ed29.setError(null);
            }
        });
        ed30.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            ed30.setError(null);
            }
        });
        ed8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            ed8.setError(null);
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


        Mobile=(CheckBox)v.findViewById(R.id.checkBox4);
        work=(CheckBox)v.findViewById(R.id.checkBox5);
        home=(CheckBox)v.findViewById(R.id.checkBox6);
        primary=(CheckBox)v.findViewById(R.id.checkBox7);
        alternate=(CheckBox)v.findViewById(R.id.checkBox8);
        chk9=(CheckBox)v.findViewById(R.id.checkBox9);

        save=(Button)v.findViewById(R.id.button500);
        inputLayoutEmail = (TextInputLayout)v.findViewById(R.id.input_layout_email);
        inputEmail = (EditText)v.findViewById(R.id.input_email);
       // inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zip_code=ed26.getText().toString();
                String city_name=ed25.getText().toString();
                String state_name=s7.getSelectedItem().toString();
                String country_name=s6.getSelectedItem().toString();
                String Add1=ed24.getText().toString();
                String mob=ed18.getText().toString();
                String pAdd1=ed27.getText().toString();
                String pCity=ed29.getText().toString();
                String Pzip=ed30.getText().toString();
                String Pcountry_name=s8.getSelectedItem().toString();
                String pState_name=s9.getSelectedItem().toString();
                String code=s3.getSelectedItem().toString();
                String code1=s4.getSelectedItem().toString();
                String work=ed19.getText().toString();
                String code3=s5.getSelectedItem().toString();
                String home=ed19.getText().toString();
                String emailId=inputEmail.getText().toString();
                if(mob.isEmpty()==true)
                {
                    ed18.setError("Enter your Mobile Number");
                    ed18.requestFocus();
                }
                else if(code=="Select" && mob.isEmpty()==false) {
                    Toast toast = Toast.makeText(getActivity(), "Please enter country code before mobile number", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

               else if(code1=="Select" && work.isEmpty()==false) {
                    Toast toast = Toast.makeText(getActivity(), "Please select country code before work number", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

               else if(code3=="Select" && home.isEmpty()==false) {
                    Toast toast = Toast.makeText(getActivity(), "Please select country code before home number", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                //temp code

                else if(emailId.isEmpty()==true)
                {
                    //submitForm();
                    validateEmail();
                }


                else if(Add1.isEmpty()==true)
                {
                    ed24.setError("Enter your Address");
                    ed24.requestFocus();
                }
                else if(country_name=="Country") {
                    SetCountryError();
                }

                else if(state_name=="State"&& country_name!="Others")
                {
                    SetStateError();
                }

                else if(city_name.isEmpty()==true)
                {
                    ed25.setError("Enter name of City");
                    ed25.requestFocus();
                }

               else if(zip_code.isEmpty()==true)
                {
                    ed26.setError("Enter Zip/Pin code");
                    ed26.requestFocus();

                }
                else if(pAdd1.isEmpty()==true)
                {
                    ed27.setError("Please enter your Address");
                    ed27.requestFocus();
                }
                else if(Pcountry_name=="Country" && chk9.isChecked()==false)
                {
                    SetPCountryError();
                }
                else if(pState_name=="State" && chk9.isChecked()==false)
                {
                    if( Pcountry_name!="Others") {
                        PSetStateError();
                    }
                }

                else if(pCity.isEmpty()==true)
                {
                    ed29.setError("Pleas enter your city");
                    ed29.requestFocus();
                }
                else if(Pzip.isEmpty()==true)
                {
                    ed30.setError("Please enter your zip code");
                    ed30.requestFocus();
                }



            }
        });


//        alternateemail=(EditText)v.findViewById(R.id.editText22);
//        input_layout_AlternateEmail = (TextInputLayout)v.findViewById(R.id.input_layout_AlternateEmail);
//        alternateemail.addTextChangedListener(new MyTextWatcher(alternateemail));
//
//        input_layout_mobileno=(TextInputLayout)v.findViewById(R.id.input_layout_mobileno);
//        ed18.addTextChangedListener(new MyTextWatcher(ed18));



        String str1[]={"Select","AU+61","CA+1","IN+91","NZ+63","SG+65","US+1","UK+44","Other"};
        String str2[]={"Country","Australia","Canada","India","New Zealand","Singapore","United Kingdom","United States","Others"};

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, str1);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s3.setAdapter(spinnerArrayAdapter);

        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==8)
                {
                    Toast.makeText(getActivity(),"Please enter country code along with the phone number !",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==8)
                {
                    Toast.makeText(getActivity(),"Please enter country code along with the phone number !",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==8)
                {
                    Toast.makeText(getActivity(),"Please enter country code along with the phone number !",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, str1);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s4.setAdapter(spinnerArrayAdapter2);

        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, str1);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s5.setAdapter(spinnerArrayAdapter3);


        ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, str2);
        spinnerArrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s6.setAdapter(spinnerArrayAdapter4);

        String str10[]={"State"};
        ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str10);
        spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s7.setAdapter(spinnerArrayAdapter5);


        ArrayAdapter<String> spinnerArrayAdapter6 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str2);
        spinnerArrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s8.setAdapter(spinnerArrayAdapter6);

        ArrayAdapter<String> spinnerArrayAdapter7 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str10);
        spinnerArrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s9.setAdapter(spinnerArrayAdapter7);

        s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str4[]={"State","Australian Capital Terrotory","New South Wales","Northern Territory","Queensland","South Australia","Tasmania","Victoria","Western Australia"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str4);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);

                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }
                    if(SetCountryError()==true) {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }

                }
               else if(position==2)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str5[]={"State","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland and Labrador","Northwest Territories","Nova Scotia","Nunavut","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str5);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);
                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }

                    if(SetCountryError()==true) {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }

                }

               else if(position==3)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str3[]={"State","Andhara Pradesh","Arunanchal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujrat","Haryana","Himanchal Pradesh","Jammu and Kashmir",
                            "Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha(Orissa)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
                            "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str3);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);
                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }

                    if(SetCountryError()==true) {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }

                }
               else if(position==4)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str6[]={"State","Auckland","Canterbur","Wellington","Waikato","Bay of Plenty","Manawatu-Wanganui","Otago","Hawke's Bay","Northland","Taranaki","Southland","Nelson","Gisborne","Marlborough","Tasman","West Coast"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str6);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);
                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }

                    if(SetCountryError()==true) {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }

                }

               else if(position==5)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str7[]={"State","Singapore"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str7);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);
                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }

                    if(SetCountryError()==true) {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }


                }
               else if(position==6)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str8[]={"State","London", "West Midlands", "Lancashire", "Nottinghamshire", "Cheshire", "Staffordshire", "Derbyshire", "Norfolk", "West Sussex", "Northamptonshire", "Oxfordshire", "Devon", "Suffolk",
                            "Lincolnshire", "Gloucestershire", "Leicestershire", "Cambridgeshire", "East Sussex", "Durham", "Bristol", "Warwickshire", "Buckinghamshire", "North Yorkshire", "Bedfordshire", "Cumbria",
                            "Somerset", "Cornwall", "Wiltshire", "Shropshire", "Leicester", "Worcestershire", "Kingston upon Hull", "Plymouth", "Stoke-on-Trent", "Derby", "Dorset", "Nottingham", "Southampton", "Brighton and Hove",
                            "Herefordshire", "Northumberland", "Portsmouth", "East Riding of Yorkshire", "Luton", "Blackpool", "North East Lincolnshire", "Middlesbrough", "Stockton-on-Tees", "Blackburn with Darwen", "Torbay",
                            "Poole", "Windsor and Maidenhead", "North Lincolnshire", "Bath and North East Somerset", "Slough", "Halton", "Isle of Wight", "Bracknell Forest", "Hartlepool", "Darlington", "West Berkshire",
                            "Redcar and Cleveland", "Wokingham", "Rutland"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str8);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);
                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }

                    if(SetCountryError()==true) {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
               else if(position==7)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str9[]={"State","Alabama", "Alaska", "Arizona", "Arkansas", "Armed Forces America", "Armed Forces Pacific", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia",
                            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                            "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str9);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);
                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }

                    if(SetCountryError()==true) {
                        tvListItem.setError(null);
                        tvInvisibleError.setError(null);
                    }
                }
                else if(position==8)
                {

                    ed8.setVisibility(View.VISIBLE);
                    ed36.setVisibility(View.VISIBLE);
                    checkState();
                    s7.setVisibility(View.GONE);
                    ed8.setFocusable(true);
                    if (chk9.isChecked()==true)
                    {
                        chk9.toggle();
                        aftercheckbox();
                    }

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String str10[]={"State"};
                ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str10);
                spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                s7.setAdapter(spinnerArrayAdapter5);
            }
        });


        s7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (chk9.isChecked()==true)
                {
                    chk9.toggle();
                }
                aftercheckbox();
                if(SetStateError()==true) {
//                    tvListItem1.setError(null);
                    tvInvisibleError1.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        s8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    ed38.setVisibility(View.GONE);
                    s9.setVisibility(View.VISIBLE);
                    String str4[]={"State","Australian Capital Terrotory","New South Wales","Northern Territory","Queensland","South Australia","Tasmania","Victoria","Western Australia"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str4);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s9.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);
                    if(SetPCountryError()==true) {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }
                }
                else if(position==2)
                {
                    ed38.setVisibility(View.GONE);
                    s9.setVisibility(View.VISIBLE);
                    String str5[]={"State","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland and Labrador","Northwest Territories","Nova Scotia","Nunavut","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str5);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s9.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);

                    if(SetPCountryError()==true) {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }
                }

                else if(position==3)
                {
                    ed38.setVisibility(View.GONE);
                    s9.setVisibility(View.VISIBLE);
                    String str3[]={"State","Andhara Pradesh","Arunanchal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujrat","Haryana","Himanchal Pradesh","Jammu and Kashmir",
                            "Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha(Orissa)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
                            "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str3);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s9.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);

                    if(SetPCountryError()==true) {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }
                }
                else if(position==4)
                {
                    ed38.setVisibility(View.GONE);
                    s9.setVisibility(View.VISIBLE);
                    String str6[]={"State","Auckland","Canterbur","Wellington","Waikato","Bay of Plenty","Manawatu-Wanganui","Otago","Hawke's Bay","Northland","Taranaki","Southland","Nelson","Gisborne","Marlborough","Tasman","West Coast"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str6);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s9.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);

                    if(SetPCountryError()==true) {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }
                }

                else if(position==5)
                {
                    ed38.setVisibility(View.GONE);
                    s9.setVisibility(View.VISIBLE);
                    String str7[]={"State","Singapore"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str7);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s9.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);

                    if(SetPCountryError()==true) {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }

                }
                else if(position==6)
                {
                    ed38.setVisibility(View.GONE);
                    s9.setVisibility(View.VISIBLE);
                    String str8[]={"State","London", "West Midlands", "Lancashire", "Nottinghamshire", "Cheshire", "Staffordshire", "Derbyshire", "Norfolk", "West Sussex", "Northamptonshire", "Oxfordshire", "Devon", "Suffolk",
                            "Lincolnshire", "Gloucestershire", "Leicestershire", "Cambridgeshire", "East Sussex", "Durham", "Bristol", "Warwickshire", "Buckinghamshire", "North Yorkshire", "Bedfordshire", "Cumbria",
                            "Somerset", "Cornwall", "Wiltshire", "Shropshire", "Leicester", "Worcestershire", "Kingston upon Hull", "Plymouth", "Stoke-on-Trent", "Derby", "Dorset", "Nottingham", "Southampton", "Brighton and Hove",
                            "Herefordshire", "Northumberland", "Portsmouth", "East Riding of Yorkshire", "Luton", "Blackpool", "North East Lincolnshire", "Middlesbrough", "Stockton-on-Tees", "Blackburn with Darwen", "Torbay",
                            "Poole", "Windsor and Maidenhead", "North Lincolnshire", "Bath and North East Somerset", "Slough", "Halton", "Isle of Wight", "Bracknell Forest", "Hartlepool", "Darlington", "West Berkshire",
                            "Redcar and Cleveland", "Wokingham", "Rutland"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str8);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s9.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);

                    if(SetPCountryError()==true) {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }
                }
                else if(position==7)
                {
                    ed38.setVisibility(View.GONE);
                    s9.setVisibility(View.VISIBLE);
                    String str9[]={"State","Alabama", "Alaska", "Arizona", "Arkansas", "Armed Forces America", "Armed Forces Pacific", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia",
                            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                            "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str9);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s9.setAdapter(spinnerArrayAdapter5);
                    ed37.setVisibility(View.GONE);

                    if(SetPCountryError()==true) {
                        tvListItem2.setError(null);
                        tvInvisibleError2.setError(null);
                    }
                }
                else if(position==8)
                {

                    ed37.setVisibility(View.VISIBLE);
                    ed38.setVisibility(View.VISIBLE);
                    PcheckState();
                    s9.setVisibility(View.GONE);
                    ed37.setFocusable(true);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String str10[]={"State"};
                ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, str10);
                spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                s7.setAdapter(spinnerArrayAdapter5);
            }
        });
        s9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(PSetStateError()==true)
                {
                   // tvListItem3.setError(null);
                    tvInvisibleError3.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    Mobile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String mob=ed18.getText().toString();
            if (((CheckBox) v).isChecked()==true && mob.isEmpty()==true) {
                ed18.setError("Mobile Number can not be blank");
                ed18.requestFocus();

                 //   Toast.makeText(getActivity(), "Mobile Number can not be blank !", Toast.LENGTH_LONG).show();
            }
        }
    });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String work=ed19.getText().toString();
                if (((CheckBox) v).isChecked()==true && work.isEmpty()==true){
                    ed19.setError("Work Number can not be blank");
                    ed19.requestFocus();
                   // Toast.makeText(getActivity(),"Work Number can not be blank !",Toast.LENGTH_LONG).show();

                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String home=ed20.getText().toString();
                if (((CheckBox) v).isChecked()==true && home.isEmpty()==true){
                    ed20.setError("Home Number can not be blank");
                    ed20.requestFocus();
                    //Toast.makeText(getActivity(),"Home Number can not be blank !",Toast.LENGTH_LONG).show();

                }
            }
        });
        primary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=inputEmail.getText().toString();
                if (((CheckBox) v).isChecked()==true && email.isEmpty()==true){
                    inputEmail.setError("Primary Email can not be blank");
                    inputEmail.requestFocus();
                   // Toast.makeText(getActivity(),"Primary Email can not be blank !",Toast.LENGTH_LONG).show();

                }
            }
        });
        alternate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=alternateemail.getText().toString();
                if (((CheckBox) v).isChecked()==true && check.isEmpty()==true){
                    alternateemail.setError("This field can not be blank");
                    alternateemail.requestFocus();

                }
            }
        });
        chk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()){
                  String add1=ed24.getText().toString();
                    String add2= ed23.getText().toString();
                    String coun1=s6.getSelectedItem().toString();
                    String coun2=ed8.getText().toString();
                    String stat1=s7.getSelectedItem().toString();
                    String stat2=ed36.getText().toString();
                    String city=ed25.getText().toString();
                    String pin=ed26.getText().toString();

                    ed27.setText(add1);
                    ed27.setEnabled(false);

                    ed28.setText(add2);
                    ed28.setEnabled(false);

                    s8.setVisibility(View.GONE);
                    s9.setVisibility(View.GONE);

                    if(coun1=="Others")
                    {
                        ed37.setText(coun2);
                    }
                    else
                    {
                        ed37.setText(coun1);
                    }

                   // ed37.append(coun1);
                   // ed37.append(coun2);
                    ed37.setVisibility(View.VISIBLE);
                    ed37.setEnabled(false);

                    if(stat1=="State")
                    {
                        ed38.setText(stat2);
                    }
                    else
                    {
                        ed38.setText(stat1);
                    }

                   // ed38.append(stat1);
                   // ed38.append(stat2);
                    ed38.setVisibility(View.VISIBLE);
                    ed38.setEnabled(false);

                    ed29.setText(city);
                    ed29.setEnabled(false);
                    ed30.setText(pin);
                    ed30.setEnabled(false);


                }
                else{
                   aftercheckbox();
                }
            }
        });

        return v;
    }
    public void aftercheckbox()
    {
        ed37.setText("");
        ed38.setText("");
        ed27.setText("");
        ed28.setText("");
        ed29.setText("");
        ed30.setText("");
        ed37.setVisibility(View.GONE);
        ed38.setVisibility(View.GONE);
        s8.setVisibility(View.VISIBLE);
        s9.setVisibility(View.VISIBLE);
        s8.setSelection(0);
        s9.setSelection(0);
        ed27.setEnabled(true);
        ed28.setEnabled(true);
        ed29.setEnabled(true);
        ed37.setEnabled(true);
        ed38.setEnabled(true);
        ed30.setEnabled(true);
    }


    private void submitForm() {

        if (!validateEmail()) {
            return;
        }
        if (!validateAltEmail()) {
            return;
        }

    }
    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
           // inputLayoutEmail.setError(getString(R.string.err_msg_email));
            inputEmail.setError("Enter valid email address");
            inputEmail.requestFocus();
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAltEmail() {
        String email = alternateemail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
           // input_layout_AlternateEmail.setError(getString(R.string.err_msg_email));
            alternateemail.setError("Enter valid email address");
            alternateemail.requestFocus();
            return false;
        } else {
//            input_layout_AlternateEmail.setErrorEnabled(false);
        }

        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public void checkState()
    {
        String state=ed36.getText().toString();
        String country=ed8.getText().toString();
        if(country.isEmpty()==true ||state.isEmpty()==true)
        {
            ed8.setError("Enter name of country");
            ed8.requestFocus();

            ed36.setError("Enter name of state");
        }
    }

    public void PcheckState()
    {
        String state=ed38.getText().toString();
        String country=ed37.getText().toString();
        if(country.isEmpty()==true)
        {
            ed37.setError("Enter name of country");
            ed37.requestFocus();

        }
        if(state.isEmpty()==true && chk9.isChecked()==false)
        {
            ed38.setError("Enter name of state");

        }
    }

    public boolean SetCountryError()
    {
        View view = s6.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError = (TextView)v.findViewById(R.id.tvInvisibleError);

        // Shake and set error if in error state, otherwise clear error

            tvListItem.setError("");
            tvListItem.requestFocus();

            // Shake the spinner to highlight that current selection
            // is invalid -- SEE COMMENT BELOW

            tvInvisibleError.requestFocus();
            tvInvisibleError.setError("Please select a country");

//        s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                tvListItem.setError(null);
//                tvInvisibleError.setError(null);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        return true;

    }
   public boolean SetStateError()
   {
       View view = s7.getSelectedView();

       // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
       // appears, and then shake control if in error
       tvListItem1 = (TextView)view;

       // Set fake TextView to be in error so that the error message appears
      // tvInvisibleError1 = (TextView)v.findViewById(R.id.tvInvisibleError2);

       // Shake and set error if in error state, otherwise clear error

//           tvListItem1.setError("");


           // Shake the spinner to highlight that current selection
           // is invalid -- SEE COMMENT BELOW


           tvInvisibleError1.setError("Please select a State");
       tvInvisibleError1.requestFocus();

//       s7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//           @Override
//           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               tvListItem1.setError(null);
//               tvInvisibleError1.setError(null);
//           }
//
//           @Override
//           public void onNothingSelected(AdapterView<?> parent) {
//
//           }
//       });
       return true;
   }


    public boolean SetPCountryError()
    {
        View view = s8.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
        tvListItem2 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
        tvInvisibleError2 = (TextView)v.findViewById(R.id.tvInvisibleError3);

        // Shake and set error if in error state, otherwise clear error

        tvListItem2.setError("");
        tvListItem2.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW

        tvInvisibleError2.requestFocus();
        tvInvisibleError2.setError("Please select a country");

//        s8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                tvListItem2.setError(null);
//                tvInvisibleError2.setError(null);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        return true;

    }
    public boolean PSetStateError()
    {
        View view = s9.getSelectedView();

        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
        // appears, and then shake control if in error
       tvListItem3 = (TextView)view;

        // Set fake TextView to be in error so that the error message appears
//       tvInvisibleError3 = (TextView)v.findViewById(R.id.tvInvisibleError4);

        // Shake and set error if in error state, otherwise clear error

       // tvListItem3.setError(null);
       // tvListItem3.requestFocus();

        // Shake the spinner to highlight that current selection
        // is invalid -- SEE COMMENT BELOW


        tvInvisibleError3.setError("Please select a State");
        tvInvisibleError3.requestFocus();

//        s9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                tvListItem3.setError(null);
//                tvInvisibleError3.setError(null);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        return true;
    }




//    private class MyTextWatcher implements TextWatcher {
//
//        private View view;
//
//        private MyTextWatcher(View view) {
//            this.view = view;
//        }
//
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        }
//
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        }
//
//        public void afterTextChanged(Editable editable) {
//            switch (view.getId()) {
//                case R.id.editText22:
//                    validateAltEmail();
//                    break;
//                case R.id.input_email:
//                    validateEmail();
//                    break;
//
//            }
//        }
//    }

}
