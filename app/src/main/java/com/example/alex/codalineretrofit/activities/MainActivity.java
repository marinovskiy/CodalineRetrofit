package com.example.alex.codalineretrofit.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.alex.codalineretrofit.R;
import com.example.alex.codalineretrofit.adapters.UsersRecyclerViewAdapter;
import com.example.alex.codalineretrofit.api.ApiClient;
import com.example.alex.codalineretrofit.api.UsersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUsers;
    private UsersRecyclerViewAdapter usersRecyclerViewAdapter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUsers = (RecyclerView) findViewById(R.id.rv_users);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiClient.getInstance().users().enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                progressDialog.dismiss();

                if (response.isSuccessful()) {
                    usersRecyclerViewAdapter = new UsersRecyclerViewAdapter(response.body().getUsers());
                    rvUsers.setAdapter(usersRecyclerViewAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}