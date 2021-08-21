package com.example.himanshu.sps.TPO;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.ADMIN.NewsFeed;
import com.example.himanshu.sps.ADMIN.ViewStudents;
import com.example.himanshu.sps.ADMIN.ViewTpo;
import com.example.himanshu.sps.DataBase.AdminStudentData;
import com.example.himanshu.sps.DataBase.CompaniesData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;
import com.example.himanshu.sps.STUDENT.AdminStudent;
import com.example.himanshu.sps.STUDENT.Edit_Profile;

import java.util.ArrayList;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.FeedView> {
    String criteria,companychoosed;
     ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<NewsFeed> arrayList;
    ArrayList<String> company_list;
    public WorkAdapter(ArrayList<NewsFeed> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public FeedView onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newsfeed,viewGroup,false);
        return new FeedView(view);

    }
    @Override
    public void onBindViewHolder(@NonNull FeedView feedView, final int i) {
        NewsFeed newsFeed = arrayList.get(i);
        feedView.imageView.setImageResource(newsFeed.getImageSrc());
        feedView.textView.setText(newsFeed.getHeading());
        feedView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (i)
                {
                    case 0:
                        Intent addstudent = new Intent(v.getContext(), AddCompany.class);
                        v.getContext().startActivity(addstudent);
                        break;
                    case 1:
                        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.short_list,null);
                        final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setView(view);

                        Spinner spinner = view.findViewById(R.id.cgpa_criteria);
                        Spinner company = view.findViewById(R.id.company);

                        company_list = new ArrayList<>();
                        company_list.add("Select Company");
                        CompaniesData companiesData = new CompaniesData(v.getContext());
                        Cursor cursor = companiesData.getCompanies();
                        while (cursor.moveToNext())
                        {
                            company_list.add(cursor.getString(1));
                        }

                        arrayAdapter = new ArrayAdapter<>(v.getContext(),android.R.layout.simple_list_item_1,company_list);
                        company.setAdapter(arrayAdapter);

                        company.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                companychoosed = company_list.get(position);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });


                        list =new ArrayList<>();
                        list.add("select eligiblity criteria !");
                        list.add("5.0");
                        list.add("6.0");
                        list.add("7.0");
                        list.add("8.0");
                        list.add("9.0");

                        arrayAdapter = new ArrayAdapter<>(v.getContext(),android.R.layout.simple_dropdown_item_1line,list);
                        spinner.setAdapter(arrayAdapter);

                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                            {
                                criteria = list.get(position);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                            builder.setPositiveButton("shortlist", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    AdminStudentData data = new AdminStudentData( v.getContext());
                                    Cursor cursor = data.getShortlist(criteria);
                                    while (cursor.moveToNext())
                                    {
                                        My_Utility.shortlisted.add(cursor.getString(2));
                                    }
                                    My_Utility.company_shorlisted.add(companychoosed);
                                    Toast.makeText(v.getContext(), "successfuly shortlisted !", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            });

                            builder.setNegativeButton("cancel",null);
                            builder.show();

                        break;
                    case 2:
                        Intent viewstudent = new Intent(v.getContext(), ViewStudents.class);
                        v.getContext().startActivity(viewstudent);
                        break;
                    case 3:
                        Intent viewtpo = new Intent(v.getContext(), com.example.himanshu.sps.TPO.ViewTpo.class);
                        v.getContext().startActivity(viewtpo);
                        break;
                    case 4 :
                        Intent profile = new Intent(v.getContext(), Edit_Profile.class);
                        v.getContext().startActivity(profile);
                        break;
                    case 5:
                        Intent web = new Intent(Intent.ACTION_VIEW);
                        v.getContext().startActivity(web);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public class FeedView extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView textView;
        public FeedView(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.news);
            textView = itemView.findViewById(R.id.heading);

        }
    }
}

