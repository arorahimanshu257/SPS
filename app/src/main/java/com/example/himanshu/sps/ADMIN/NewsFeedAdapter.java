package com.example.himanshu.sps.ADMIN;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.R;
import com.example.himanshu.sps.STUDENT.Edit_Profile;
import com.example.himanshu.sps.STUDENT.TpoInfo;
import com.example.himanshu.sps.STUDENT.ViewAdminInfo;
import com.example.himanshu.sps.STUDENT.View_companies;

import java.util.ArrayList;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.FeedView> {
    ArrayList<NewsFeed> arrayList;

    public NewsFeedAdapter(ArrayList<NewsFeed> arrayList) {
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
                        Intent edit_profile = new Intent(v.getContext(), Edit_Profile.class);
                        v.getContext().startActivity(edit_profile);
                        break;
                    case 1:
                        Intent admin = new Intent(v.getContext(), ViewAdminInfo.class);
                        v.getContext().startActivity(admin);
                        break;
                    case 2:
                        Intent tpo = new Intent(v.getContext(), TpoInfo.class);
                        v.getContext().startActivity(tpo);
                        break;
                    case 3:
                        Intent intent = new Intent(v.getContext(), View_companies.class);
                        v.getContext().startActivity(intent);
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
