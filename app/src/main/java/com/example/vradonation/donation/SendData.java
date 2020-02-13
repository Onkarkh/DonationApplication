package com.example.vradonation.donation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vradonation.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SendData extends Fragment {

    private static final String DB_URL = "jdbc:mysql://localhost/testdb";
    private static final String username = "root@localhost";
    private static final String password = "";

    private String firstName, lastName, email, mobile, address, qyt, other, type;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_data, container, false);

        Bundle bundle;
        bundle = getArguments();

        firstName = bundle.getString("firstname");
        lastName = bundle.getString("lastname");
        email = bundle.getString("email");
        mobile = bundle.getString("mobile");
        address = bundle.getString("address");
        type = bundle.getString("type");
        other = bundle.getString("other");
        qyt = bundle.getString("quantity");

        Send send = new Send();
        send.execute("");
        return view;
    }

    private class Send extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, username, password);
                if (conn == null) {
                    Toast.makeText(getActivity(), "Connection goes Wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    PreparedStatement preparedStatement = conn.prepareStatement("insert into donation_database values (?,?,?,?,?,?,?,?)");
                    preparedStatement.setString(1,firstName);
                    preparedStatement.setString(2,lastName);
                    preparedStatement.setString(3,email);
                    preparedStatement.setString(4,mobile);
                    preparedStatement.setString(5,address);
                    preparedStatement.setString(6,type);
                    preparedStatement.setString(7,other);
                    preparedStatement.setString(8,qyt);
                    preparedStatement.executeUpdate();

                    Toast.makeText(getActivity(), "Insert Success!", Toast.LENGTH_SHORT).show();
                }
                conn.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
