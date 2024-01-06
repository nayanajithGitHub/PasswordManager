package com.example.password_manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private ArrayList listid,addtitle,adduname,addpassword;
    private int position;



    public MyAdapter(Context context, ArrayList listid, ArrayList  addtitle, ArrayList adduname, ArrayList addpassword) {
        this.context = context;
        this.listid = listid;
        this.addtitle = addtitle;
        this.adduname= adduname;
        this.addpassword = addpassword;
        int position;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.position = position;
        holder.id.setText(String.valueOf(listid.get(position)));
        holder.title.setText(String.valueOf(addtitle.get(position)));
        holder.uname.setText(String.valueOf(adduname.get(position)));
        holder.password.setText(String.valueOf(addpassword.get(position)));
        holder.editLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateDetails.class);
                intent.putExtra("id",String.valueOf(listid.get(position)));
                intent.putExtra("title",String.valueOf(addtitle.get(position)));
                intent.putExtra("uname",String.valueOf(adduname.get(position)));
                intent.putExtra("password",String.valueOf(addpassword.get(position)));

                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listid.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,uname,title,password;
        LinearLayout editLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.idview);
            uname = itemView.findViewById(R.id.unameview);
            title = itemView.findViewById(R.id.titleview);
            password = itemView.findViewById(R.id.passwordview);

            editLayout = itemView.findViewById(R.id.setview_layout);


        }
    }


}
