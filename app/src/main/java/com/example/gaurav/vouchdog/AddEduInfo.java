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

public class AddEduInfo extends AppCompatActivity {
    Spinner s17;
    EditText ed33,ed34,board,college,grade,activity;
    CheckBox ck12;
    Button b14,upload;
    ImageButton img7,img8;
    TextView tvListItem1, tvInvisibleError1,tv37;
    int REQUEST_CAMERA = 0, SELECT_FILE = 1,REQUEST_CODE_DOC=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edu_info);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);
        tv37=(TextView)findViewById(R.id.textView37);
        b14=(Button)findViewById(R.id.button14);
        upload=(Button)findViewById(R.id.button13);
        ck12=(CheckBox)findViewById(R.id.checkBox12);
        ed33=(EditText)findViewById(R.id.editText33);
        ed34=(EditText)findViewById(R.id.editText34);
        board=(EditText)findViewById(R.id.editText31);
        college=(EditText)findViewById(R.id.editText32);
        grade=(EditText)findViewById(R.id.editText35);
        activity=(EditText)findViewById(R.id.editText36);
        s17=(Spinner)findViewById(R.id.spinner17);
        img7=(ImageButton)findViewById(R.id.imageButton7);
        img8=(ImageButton)findViewById(R.id.imageButton8);
        String str2[]={"Degree/Doploma/Certificate*","High School","Associate's Degree","Bachelor's Degree","Master's Degree","Singapore","Doctor of Philosophy"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddEduInfo.this, android.R.layout.simple_spinner_item, str2);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s17.setAdapter(spinnerArrayAdapter);

        s17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(CheckDegree()==true)
                {
                    tvListItem1.setError(null);
                    tvInvisibleError1.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddEduInfo.this, new DatePickerDialog.OnDateSetListener() {
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
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddEduInfo.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth=selectedmonth+1;
                        ed34.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });
        ck12.setOnClickListener(new View.OnClickListener() {
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
        board.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            board.setError(null);
            }
        });
        college.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                college.setError(null);

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
        grade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                grade.setError(null);

            }
        });
        activity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                activity.setError(null);

            }
        });


        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               CheckDate();
                Validation();
            }
        });
    }
    public void CheckDate()
    {
        String from=ed33.getText().toString();
        String to=ed34.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = formatter.parse(from);
            Date date2 = formatter.parse(to);
            if (date2.compareTo(date1)<0)
            {
                Toast.makeText(getApplicationContext(),"Education dates are invalid",Toast.LENGTH_LONG).show();
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public boolean Validation()
    {

        String degree= s17.getSelectedItem().toString();
        String Board=board.getText().toString();
        String College=college.getText().toString();
        String from=ed33.getText().toString();
        String to=ed34.getText().toString();
        String Grade=grade.getText().toString();
        String Act=activity.getText().toString();

        if(degree == "Degree/Doploma/Certificate*")
        {
            CheckDegree();
        }
        else if(Board.isEmpty()==true)
        {
            board.setError("Enter University/Board");
            board.requestFocus();
        }
        else if(College.isEmpty()==true)
        {
            college.setError("Enter College/School/Institute");
            college.requestFocus();
        }
        else if(from.isEmpty()==true)
        {
           ed33.setError("Enter Date");
            ed33.requestFocus();
        }
        else if(to.isEmpty()==true && ck12.isChecked()==false)
        {
            ed34.setError("Enter Date");
            ed34.requestFocus();
        }
        else if(Grade.isEmpty()==true)
        {
            grade.setError("Enter Grade");
            grade.requestFocus();
        }
        else if(Act.isEmpty()==true)
        {
            activity.setError("Enter Extra-Curricular Activities");
            activity.requestFocus();
        }



        return true;
    }
    public boolean CheckDegree()
    {

        tvInvisibleError1=null;
        View view = s17.getSelectedView();

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
        tvInvisibleError1.setError("Please select a Degree/Diploma/Certificate");
        return true;
    }


    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose Photo from Library","Choose File from Directory",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(AddEduInfo.this);
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
            Cursor cursor = AddEduInfo.this.getContentResolver().query(uri, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA, MediaStore.Images.Media.ORIENTATION }, null, null, null);
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
                tv37.setText(sub);
               // ivImage.setImageURI(fileuri);
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

       // ivImage.setImageBitmap(thumbnail);
        String name=data.getDataString();
        tv37.setText(name);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri= data.getData();
        String[] projection = { MediaStore.MediaColumns.DATA};
        Cursor cursor = AddEduInfo.this.getContentResolver().query(selectedImageUri, projection, null, null, null);
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

       // ivImage.setImageBitmap(bm);
        String name=data.getDataString();
        tv37.setText(name);
    }
}
