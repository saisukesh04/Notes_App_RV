package com.example.notesapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import static com.example.notesapp.MainActivity.recyclerView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {


    private List<ModelClass> modelClassList;
    Context context;
    AppDatabase db;

    public RecyclerViewAdapter(List<ModelClass> modelClassList, Context context) {
        this.modelClassList = modelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        db = Room.databaseBuilder(context,
                AppDatabase.class, "modelclass")
                .allowMainThreadQueries()
                .build();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.Viewholder holder, int position) {

        String title = modelClassList.get(position).getTitleRow();
        String body = modelClassList.get(position).getDescriptionRow();

        holder.titleRow.setText(title);
        holder.bodyRow.setText(body);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeItem(position);

                Intent intent = new Intent(context, NoteActivity.class);
                intent.putExtra("Title", title);
                intent.putExtra("Body", body);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView titleRow;
        private TextView bodyRow ;
        CardView cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            titleRow = itemView.findViewById(R.id.titleRow);
            bodyRow = itemView.findViewById(R.id.descriptionRow);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public void removeItem(int position) {
        modelClassList.remove(position);
        db.noteDao().delete(modelClassList.get(position));
        notifyItemRemoved(position);
    }
}
