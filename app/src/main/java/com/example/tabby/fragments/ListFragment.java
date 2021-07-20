package com.example.tabby.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabby.R;
import com.example.tabby.adapters.ListPersonAdapter;
import com.example.tabby.models.Person;
import com.example.tabby.util.Util;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListPersonAdapter adapter;
    private List<Person> people;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        people = new ArrayList<Person>();
        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new ListPersonAdapter(people);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


    public void addPerson(Person person){
        this.people.add(person);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}