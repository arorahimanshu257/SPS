package com.example.himanshu.sps.ADMIN;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class TpoAdapter extends RecyclerView.Adapter<TpoAdapter.TpoView> {
    ArrayList<TpoViewClass> arrayList;

    public TpoAdapter(ArrayList<TpoViewClass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TpoAdapter.TpoView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tpo_list,viewGroup,false);
        return new TpoView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TpoAdapter.TpoView tpoView, int i) {
        TpoViewClass tpoViewClass = arrayList.get(i);
        tpoView.name.setText(tpoViewClass.getName());
        tpoView.id.setText(tpoViewClass.getId());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TpoView extends RecyclerView.ViewHolder {
        TextView name ,id;
        public TpoView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tname);
            id = itemView.findViewById(R.id.tid);
        }
    }
}
