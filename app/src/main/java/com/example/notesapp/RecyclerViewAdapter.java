package com.example.notesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {

    private List<ModelClass> modelClassList;

    public RecyclerViewAdapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.Viewholder holder, int position) {

        String title = modelClassList.get(position).getTitleRow();
        String body = modelClassList.get(position).getDescriptionRow();

        holder.titleRow.setText(title);
        holder.bodyRow.setText(body);

//        holder.setData(title, body);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView titleRow;
        private TextView bodyRow ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            titleRow = itemView.findViewById(R.id.titleRow);
            bodyRow = itemView.findViewById(R.id.descriptionRow);

        }

//        private void setData(String title, String body){
//
//            titleNote.setText(title);
//            bodyNote.setText(body);
//        }
    }
}
