package com.example.notesapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ModelClass> modelClassList;
    Context context;

    public RecyclerViewAdapter(List<ModelClass> modelClassList, Context context) {
        this.modelClassList = modelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        String title = modelClassList.get(position).getTitleRow();
        String body = modelClassList.get(position).getDescriptionRow();

        holder.titleRow.setText(title);
        holder.bodyRow.setText(body);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, NoteActivity.class);
                intent.putExtra("Title", title);
                intent.putExtra("Body", body);
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnLongClickListener(view -> {
            removeItem(position);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleRow;
        private TextView bodyRow ;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleRow = itemView.findViewById(R.id.titleRow);
            bodyRow = itemView.findViewById(R.id.descriptionRow);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public void removeItem(int position) {
        modelClassList.remove(position);
        AppDatabase.getInstance(context).noteDao().deleteNote(modelClassList.get(position));
        notifyItemRemoved(position);
    }
}
