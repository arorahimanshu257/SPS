package com.example.himanshu.sps.ADMIN;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.DataBase.CompaniesData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;
import com.example.himanshu.sps.STUDENT.AdminStudent;
import com.example.himanshu.sps.STUDENT.TpoInfo;
import com.example.himanshu.sps.STUDENT.ViewAdminInfo;
import com.example.himanshu.sps.TPO.AdminLogin;
import com.example.himanshu.sps.TPO.AdminTpo;

import java.util.ArrayList;

public class NewAdminAdapter extends RecyclerView.Adapter<NewAdminAdapter.FeedView> {
    ArrayList<NewsFeed> arrayList;
    EditText editText;
    String announcement;
    public NewAdminAdapter(ArrayList<NewsFeed> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public FeedView onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newsfeed,viewGroup,false);
        return new FeedView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FeedView feedView,final int i) {
        NewsFeed newsFeed = arrayList.get(i);
        feedView.imageView.setImageResource(newsFeed.getImageSrc());
        feedView.textView.setText(newsFeed.getHeading());
        feedView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i)
                {
                    case 0:
                        Intent addstudent = new Intent(v.getContext(), AdminStudent.class);
                        v.getContext().startActivity(addstudent);
                        break;
                    case 1:
                        Intent tpo = new Intent(v.getContext(), AdminTpo.class);
                        v.getContext().startActivity(tpo);
                        break;
                    case 2:
                        Intent viewstudent = new Intent(v.getContext(), ViewStudents.class);
                        v.getContext().startActivity(viewstudent);
                        break;
                    case 3:
                        Intent viewtpo = new Intent(v.getContext(), ViewTpo.class);
                        v.getContext().startActivity(viewtpo);
                        break;
                    case 4:
                        Intent companies = new Intent(v.getContext(), com.example.himanshu.sps.TPO.ViewTpo.class);
                        v.getContext().startActivity(companies);
                        break;
                    case 5:

                        final View view = LayoutInflater.from(v.getContext()).inflate(R.layout.announcement,null);

                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setView(view);

                        editText= view.findViewById(R.id.announce);

                        announcement = editText.getText().toString();



                        builder.setPositiveButton("Push", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(!TextUtils.isEmpty(editText.getText().toString()))
                                {
                                    CompaniesData companiesData = new CompaniesData(view.getContext());
                                    boolean b = companiesData.pushAnnouncement(announcement);
                                    if(b)
                                    {
                                        Toast.makeText(view.getContext(), "Done !", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(view.getContext(), "nothing !", Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else
                                {
                                    editText.setError("enter text");
                                }


                            }
                        });

                        builder.setNegativeButton("no",null);
                        builder.show();

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
