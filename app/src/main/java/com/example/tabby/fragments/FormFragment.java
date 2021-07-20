package com.example.tabby.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tabby.R;
import com.example.tabby.interfaces.CreatePerson;
import com.example.tabby.models.Country;
import com.example.tabby.models.Person;
import com.example.tabby.util.Util;

import java.util.List;

public class FormFragment extends Fragment {

    private EditText editTextName;
    private Spinner spinner;
    private Button btnCreatePerson;
    private List<Country> countries;
    private CreatePerson mCreatePerson;

    public FormFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        editTextName = view.findViewById(R.id.editTextName);
        spinner = view.findViewById(R.id.spinner_country);
        btnCreatePerson = view.findViewById(R.id.btnCreatePerson);
        countries = Util.getCountries();
        spinner.setAdapter(new ArrayAdapter<Country>(getContext(), android.R.layout.simple_spinner_item, countries));

        btnCreatePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePerson = editTextName.getText().toString();
                Country country = (Country) spinner.getSelectedItem();
                Person person = new Person(namePerson, country);
                mCreatePerson.createPerson(person);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof CreatePerson ){
            mCreatePerson = (CreatePerson) context;
        }else {
            throw new RuntimeException(context.toString() + ", you should implement CreatePerson");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCreatePerson = null;
    }
}