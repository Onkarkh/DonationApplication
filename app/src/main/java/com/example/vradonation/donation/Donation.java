package com.example.vradonation.donation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vradonation.R;

public class Donation extends Fragment {

    private String firstName, lastName, email, mobile, address, qyt, other, type;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donation, container, false);

        TextView donationTitle = view.findViewById(R.id.donationTitle);

        EditText edtFirstName = view.findViewById(R.id.firstName);
        EditText edtLastName = view.findViewById(R.id.lastName);
        EditText edtEmail = view.findViewById(R.id.email);
        EditText edtMobile = view.findViewById(R.id.mobileNumber);
        EditText edtAddress = view.findViewById(R.id.address);
        EditText edtOther = view.findViewById(R.id.otherItem);
        EditText edtQuantity = view.findViewById(R.id.quantity);

        Bundle bundle = getArguments();
        String getTitle = bundle.getString("title");
        int array = bundle.getInt("array");


        donationTitle.setText(getTitle);

        Spinner itemSpinner = view.findViewById(R.id.itemSpinner);
        ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(getActivity(), array, android.R.layout.simple_spinner_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(foodAdapter);

        return view;
    }
}
