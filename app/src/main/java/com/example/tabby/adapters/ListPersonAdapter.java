package com.example.tabby.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabby.R;
import com.example.tabby.models.Person;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class ListPersonAdapter extends RecyclerView.Adapter<ListPersonAdapter.ViewHolder> {

    private List<Person> person;

    public ListPersonAdapter(List<Person> person){
        this.person = person;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_country_person, parent,false);
        ViewHolder vh = new ViewHolder(viewInflated);
        return vh;
    }

    @Override
    public void onBindViewHolder(ListPersonAdapter.ViewHolder holder, int position) {
        holder.bind(person.get(position));
    }

    @Override
    public int getItemCount() {

        if(person != null){
            return person.size();
        }else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewCountryName;
        private ImageView imageViewFlag;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.namePerson);
            textViewCountryName = itemView.findViewById(R.id.nameCountry);
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag);
        }

        public void bind(Person person){
            textViewName.setText(person.getNamePerson());
            textViewCountryName.setText(person.getCountry().getNameCountry());
            String url = person.getCountry().getFlagUrl(person.getCountry().getCodeCountry());
            Picasso.get().load(url).into(imageViewFlag);
        }
    }
}
