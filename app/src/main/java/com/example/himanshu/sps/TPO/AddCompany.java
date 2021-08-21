package com.example.himanshu.sps.TPO;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.DataBase.CompaniesData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AddCompany extends AppCompatActivity {

    EditText cname,code,locate;
    Spinner ecriteria;
    String criteria;
    TextView datep;
    Calendar calendar;
    int year,month,day;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        cname = findViewById(R.id.cname);
        code = findViewById(R.id.code);
        ecriteria = findViewById(R.id.criteria);
        locate = findViewById(R.id.locate);
        datep = findViewById(R.id.date);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        month=month+1;


        arrayList =new ArrayList<>();
        arrayList.add("select eligiblity criteria !");
        arrayList.add("5.0");
        arrayList.add("6.0");
        arrayList.add("7.0");
        arrayList.add("8.0");
        arrayList.add("9.0");

        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,arrayList);
        ecriteria.setAdapter(arrayAdapter);

        ecriteria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                criteria=arrayList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        datep.setText("Select Date");
        datep.setTextColor(Color.RED);

        datep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog( AddCompany.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        datep.setText(dayOfMonth+"/"+month+"/"+year);
                        datep.setTextColor(Color.GREEN);
                    }
                },year,month,day);
                dialog.show();
            }
        });
    }

    public void onAddCompany(View view)
    {
        if(!TextUtils.isEmpty(cname.getText().toString()))
        {
            if(!TextUtils.isEmpty(code.getText().toString()))
            {
                    if(!TextUtils.isEmpty(locate.getText().toString()))
                    {
                        if(TextUtils.equals(datep.getText().toString(),"Date"))
                        {
                            datep.setError("please select date !");
                        }
                        else
                        {
                            My_Utility.company_code = code.getText().toString();
                            CompaniesData companiesData = new CompaniesData(this);
                            boolean b = companiesData.addCompany(cname.getText().toString(), code.getText().toString(), criteria, locate.getText().toString(), datep.getText().toString());
                            if (b)
                            {
                                My_Utility.company_code = code.getText().toString();
                                Toast.makeText(this, "Company Registered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this, FinalCompany.class);
                                startActivity(intent);
                            }
                            else
                                {
                                Toast.makeText(this, "Not Registered", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                    else
                    locate.setError("Enter Location");
            }
            else
            code.setError("Enter Code");
        }
        else
        cname.setError("Enter Name");

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
