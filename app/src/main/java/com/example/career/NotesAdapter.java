package com.example.career;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<Notes> notesList;
    private OnItemClickListener listener;
    Context context;
    public void setFilteredList(List<Notes> filteredList){
        this.notesList=filteredList;
        notifyDataSetChanged();
    }

    public NotesAdapter(List<Notes> notesList, OnItemClickListener listener) {
        this.notesList = notesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notes, parent, false);
        context=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notes notes = notesList.get(position);
        holder.textTopicName.setText(notes.getTopicName());
        holder.textTopicDescription.setText("Description:"+notes.getDescription());
        holder.textSubjectName.setText("Subject:"+notes.getSubjectName());
        holder.btnView.setOnClickListener(v -> listener.onItemClick(notes));

    }

    public interface OnItemClickListener {
        void onItemClick(Notes notes);
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTopicName;
        public TextView textSubjectName;
        public TextView textTopicDescription;
        public Button btnView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTopicName = itemView.findViewById(R.id.textTopicName);
            textTopicDescription = itemView.findViewById(R.id.textTopicDescription);
            btnView = itemView.findViewById(R.id.btnView);
            textSubjectName=itemView.findViewById(R.id.textSubjectName);
        }
    }

}

