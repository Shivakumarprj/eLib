package com.example.career;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.UUID;

public class AddNotes extends AppCompatActivity {
    EditText  subjectName,topicName,topicDescription;
    Button addFile;
    Button addNotes;
    String topicLink="unselected";
    ProgressBar progressBar;
    private ActivityResultLauncher<String> mGetContent;
    DatabaseReference notesDatabase;
    String myBranch="CSE";
    Spinner spinner;
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        subjectName=findViewById(R.id.subject_name);
        topicName=findViewById(R.id.editTextTopicName);
        topicDescription=findViewById(R.id.editTextTopicDescription);
        addFile=findViewById(R.id.addPDFButton);
        addNotes=findViewById(R.id.add_course_btn);
        progressBar=findViewById(R.id.progressbarPDF);
        spinner=findViewById(R.id.spinnerSelectBranch);
        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();
        String [] standards={"CSE","H&S","ECE","CIVIL"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,standards);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        myBranch="CSE";
                        break;
                    case 1:
                        myBranch="H&S";
                        break;
                    case 2:
                        myBranch="ECE";
                        break;
                    case 3:
                        myBranch="CIVIL";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mGetContent=registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri ->{
                    uploadFile(uri);
                }
        );
        addFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePdfFile();

            }
        });
        notesDatabase= FirebaseDatabase.getInstance().getReference("notes");
        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(topicName.getText().toString().equals("")||
                        addFile.getText().toString().equals("")||
                topicDescription.getText().toString().equals("")||
                topicLink.equals("unselected")||topicLink.equals("")){
                    Toast.makeText(AddNotes.this, "Please Fill  all details", Toast.LENGTH_SHORT).show();

                }
                else {

                    String courseIdKey = notesDatabase.push().getKey();
                    Notes notes = new Notes(myBranch,courseIdKey,subjectName.getText().toString(),
                            topicName.getText().toString(), topicDescription.getText().toString(),
                            topicLink);
                    notesDatabase.child(myBranch).child(courseIdKey).setValue(notes);
                    finish();

                }

            }
        });
    }
    public void choosePdfFile(){
        mGetContent.launch("application/pdf");
        progressBar.setVisibility(View.VISIBLE);

    }
    public void uploadFile(Uri filePath){
        if(filePath!=null){
            StorageReference ref=storageReference.child("content/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(taskSnapshot -> {
                        ref.getDownloadUrl().addOnSuccessListener(uri -> {
                            progressBar.setVisibility(View.GONE);
                            topicLink=uri.toString();
                            Toast.makeText(AddNotes.this, "PDF added", Toast.LENGTH_SHORT).show();
                        });

                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(AddNotes.this, "Unable to upload file", Toast.LENGTH_SHORT).show();

                    });
        }
        else{
            Toast.makeText(AddNotes.this, "Please Select a Valid PDF file for upload", Toast.LENGTH_SHORT).show();
        }

    }
}