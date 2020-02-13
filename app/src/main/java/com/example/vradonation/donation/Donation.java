package com.example.vradonation.donation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vradonation.R;

public class Donation extends Fragment {

    private String firstName, lastName, email, mobile, address, qyt, other, type;
    private EditText edtFirstName, edtLastName, edtEmail, edtMobile, edtAddress, edtOther, edtQuantity;
    private Bundle bundle;
    private Spinner itemSpinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donation, container, false);

        TextView donationTitle = view.findViewById(R.id.donationTitle);

        edtFirstName = view.findViewById(R.id.firstName);
        edtLastName = view.findViewById(R.id.lastName);
        edtEmail = view.findViewById(R.id.email);
        edtMobile = view.findViewById(R.id.mobileNumber);
        edtAddress = view.findViewById(R.id.address);
        edtOther = view.findViewById(R.id.otherItem);
        edtQuantity = view.findViewById(R.id.quantity);

        Button btnRegister = view.findViewById(R.id.register);

        Bundle getbundle = getArguments();
        final String getTitle = getbundle.getString("title");
        int array = getbundle.getInt("array");

        donationTitle.setText(getTitle);

        itemSpinner = view.findViewById(R.id.itemSpinner);
        ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(getActivity(), array, android.R.layout.simple_spinner_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(foodAdapter);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                Boolean status = checkValidation();
                SendData sendData = new SendData(getActivity());
                sendData.execute(firstName, lastName, email, mobile, address, qyt, type, other);
            }
        });

        return view;
    }

    private void sendData() {

    }

    private Boolean checkValidation() {
        if (firstName.matches("") || lastName.matches("") || email.matches("") || mobile.matches("") || address.matches("") || qyt.matches("")) {
            toastMessage("Please Check all the fields are Entered!");
            return false;
        } else {
            return true;
        }
    }

    private void toastMessage(String s) {
        Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
    }

    private void getData() {
        firstName = edtFirstName.getText().toString().trim();
        lastName = edtLastName.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        mobile = edtMobile.getText().toString().trim();
        address = edtAddress.getText().toString().trim();
        qyt = edtQuantity.getText().toString().trim();
        type = itemSpinner.getSelectedItem().toString().trim();
        other = edtOther.getText().toString().trim();
        if (other.matches("")) {
            other = "none";
        }
    }
}
