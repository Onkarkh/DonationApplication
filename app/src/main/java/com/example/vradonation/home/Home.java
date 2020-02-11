package com.example.vradonation.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vradonation.R;

import java.util.ArrayList;

public class Home extends Fragment {

    private ArrayList<String> title;
    private ArrayList<Integer> images;

    private Button fundsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridView = view.findViewById(R.id.donationGridView);

        title = new ArrayList<>();
        title.add("Food");
        title.add("Cloths");
        title.add("Medicine");
        title.add("Books");

        images = new ArrayList<>();
        images.add(R.drawable.fruit);
        images.add(R.drawable.fashion);
        images.add(R.drawable.pill);
        images.add(R.drawable.diary);

        gridView.setAdapter(new SetData());
        return view;
    }

    private class SetData extends BaseAdapter{
        @Override
        public int getCount() {
            return title.size();
        }

        @Override
        public Object getItem(int position) {
            return title.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.item_donation_layout,null);

            imageView = view.findViewById(R.id.image);
            imageView.setImageResource(images.get(position));
            return view;
        }
    }
}
