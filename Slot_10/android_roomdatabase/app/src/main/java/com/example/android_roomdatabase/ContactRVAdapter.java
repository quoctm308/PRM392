package com.example.android_roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<Contact> contactModalArrayList;
    private Context context;

    // constructor
    public ContactRVAdapter(ArrayList<Contact> contactModalArrayList, Context context) {
        this.contactModalArrayList = contactModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Contact modal = contactModalArrayList.get(position);
        holder.tvEmpName.setText(modal.getEmpName());
        holder.tvEmpEmail.setText(modal.getEmpEmail());
        holder.tvEmpAddress.setText(modal.getEmpAddress());
        holder.tvNotes.setText(modal.getNotes());
        // below line is to add on click listener for our recyclerview item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Update, delete
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return contactModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private TextView tvEmpName, tvEmpEmail, tvEmpAddress, tvNotes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            tvEmpName = itemView.findViewById(R.id.tvEmpName);
            tvEmpEmail = itemView.findViewById(R.id.tvEmpEmail);
            tvEmpAddress = itemView.findViewById(R.id.tvEmpAddress);
            tvNotes = itemView.findViewById(R.id.tvNote);
        }
    }
}