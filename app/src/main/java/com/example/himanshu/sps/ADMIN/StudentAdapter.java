package com.example.himanshu.sps.ADMIN;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewClass> {
    ArrayList<StudentViewClass> list;

    public StudentAdapter(ArrayList<StudentViewClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_lists,viewGroup,false);
        return new ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass viewClass, int i) {
        StudentViewClass aClass = list.get(i);
        viewClass.name.setText(aClass.getStname());
        viewClass.branch.setText(aClass.getStbranch());
        viewClass.id.setText(aClass.getStid());
        viewClass.cgpa.setText(aClass.getCgpa());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewClass extends RecyclerView.ViewHolder {
        TextView name,id,branch,cgpa;
        public ViewClass(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.sname);
            id = itemView.findViewById(R.id.sid);
            branch = itemView.findViewById(R.id.sbranch);
            cgpa = itemView.findViewById(R.id.cgpa);
        }
    }
}
