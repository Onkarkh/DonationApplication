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

    private Spinner itemSpinner;
    private TextView donationTitle;
    private EditText edtFirstName, edtLastName, edtEmail, edtMobile, edtAddress, edtOther, edtQuantity;
    private String firstName, lastName, email, mobile, address, qyt, other, type;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donation, container, false);

        donationTitle = view.findViewById(R.id.donationTitle);

        edtFirstName = view.findViewById(R.id.firstName);
        edtLastName = view.findViewById(R.id.lastName);
        edtEmail = view.findViewById(R.id.email);
        edtMobile = view.findViewById(R.id.mobileNumber);
        edtAddress = view.findViewById(R.id.address);
        edtOther = view.findViewById(R.id.otherItem);
        edtQuantity = view.findViewById(R.id.quantity);

        Bundle bundle = getArguments();
        String getTitle = bundle.getString("title");
        int n = bundle.getInt("array");
        donationTitle.setText(getTitle);
        itemSpinner = view.findViewById(R.id.itemSpinner);
        switch (n) {
            case 0:
                ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.food_item, android.R.layout.simple_spinner_item);
                foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                itemSpinner.setAdapter(foodAdapter);
                break;
            case 1:
                ArrayAdapter<CharSequence> clothAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.cloth_item, android.R.layout.simple_spinner_item);
                clothAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                itemSpinner.setAdapter(clothAdapter);
                break;
            case 2:
                ArrayAdapter<CharSequence> medicineAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.medicine_item, android.R.layout.simple_spinner_item);
                medicineAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                itemSpinner.setAdapter(medicineAdapter);
                break;
            case 3:
                ArrayAdapter<CharSequence> bookAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.book_item, android.R.layout.simple_spinner_item);
                bookAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                itemSpinner.setAdapter(bookAdapter);
                break;

        }


        return view;
    }
}
