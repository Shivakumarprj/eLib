package com.example.career;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;



public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button button1 = view.findViewById(R.id.cse_branch);
        Button button2 = view.findViewById(R.id.ece_branch);
        Button button3 = view.findViewById(R.id.hns_branch);
        Button button4 = view.findViewById(R.id.civil_branch);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButton1Click();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButton2Click();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButton3Click();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButton4Click();
            }
        });


        return view;
    }

    private void onButton1Click() {
        Intent intent = new Intent(getContext(), NotesListActivity.class);
        intent.putExtra("branch","CSE");
        getActivity().startActivity(intent);

    }

    private void onButton2Click() {

        Intent intent = new Intent(getContext(), NotesListActivity.class);
        intent.putExtra("branch","ECE");
        getActivity().startActivity(intent);


    }

    private void onButton3Click() {
        Intent intent = new Intent(getContext(), NotesListActivity.class);
        intent.putExtra("branch","H&S");
        getActivity().startActivity(intent);

    }
    private void onButton4Click(){
        Intent intent = new Intent(getContext(), NotesListActivity.class);
        intent.putExtra("branch","CIVIL");
        getActivity().startActivity(intent);

    }
}
