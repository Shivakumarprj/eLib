package com.example.career;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NotesListActivity extends AppCompatActivity implements NotesAdapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private DatabaseReference database;
    private String branch;
    List<Notes> notesList;
    SearchView searchView;
    private DatabaseReference branchReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        searchView=findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        Intent intent=getIntent();
        branch=intent.getStringExtra("branch");
        database=FirebaseDatabase.getInstance().getReference();
        branchReference= FirebaseDatabase.getInstance().getReference("notes/"+branch);
         getNotesList();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notesAdapter = new NotesAdapter(notesList, this);
        recyclerView.setAdapter(notesAdapter);
    }
    private void filterList(String text) {
        List<Notes> filteredList=new ArrayList<>();
        for (Notes notes:notesList) {
            if(notes.getTopicName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(notes);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(NotesListActivity.this,"No Topics Found",Toast.LENGTH_LONG).show();
        }else {
            notesAdapter.setFilteredList(filteredList);

        }
    }

    private void getNotesList() {
        notesList = new ArrayList<>();
        branchReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String notesId = dataSnapshot.getKey();
                    fetchNotes(notesId);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        // Add more courses as needed
    }
    private void fetchNotes(String notesId) {
        DatabaseReference notesDatabase=database.child("notes/"+branch).child(notesId);
        notesDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Notes notes =snapshot.getValue(Notes.class);
                    Log.i("notesName", notes.getTopicName());
                    notesList.add(notes);

                }

                notesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onItemClick(Notes notes) {
        // Handle the "View" button click for the selected course
        Intent intent=new Intent(NotesListActivity.this, NotesViewActivity.class);
        intent.putExtra("link",notes.getLink());
        intent.putExtra("name",notes.getTopicName());
        startActivity(intent);
    }


}