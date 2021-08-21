package com.example.himanshu.sps.TPO;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class TpoAdapter extends RecyclerView.Adapter<TpoAdapter.TpoViewClass> {
    ArrayList<TpoClass> arrayList;

    public TpoAdapter(ArrayList<TpoClass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TpoViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.company_list,viewGroup,false);
        return new TpoViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TpoViewClass tpoViewClass, int i) {

        TpoClass tpoClass = arrayList.get(i);
        tpoViewClass.name.setText(tpoClass.getName());
        tpoViewClass.date.setText(tpoClass.getDate());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TpoViewClass extends RecyclerView.ViewHolder {
        TextView name,date;
        public TpoViewClass(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cname);
            date = itemView.findViewById(R.id.date);
        }
    }
}
