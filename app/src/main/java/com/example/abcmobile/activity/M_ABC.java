package com.example.abcmobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.abcmobile.R;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.AccountModel;
import com.example.abcmobile.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M_ABC extends Fragment {

    private ImageView m_transfer;
    private ImageView m_info;
    private ImageView m_payment;
    private ImageView exit;
    //private TextView tv_user_main;
    //AccountModel am;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.m_abc, container, false);
        super.onCreate(savedInstanceState);

        //tv_user_main = (TextView) root.findViewById(R.id.tv_user_main);
        //tv_user_main.setText(am.getNomorKartu());

        m_transfer = (ImageView) root.findViewById(R.id.iv_mtransfer);
        m_info = (ImageView) root.findViewById(R.id.iv_minfo);
        m_payment = (ImageView) root.findViewById(R.id.iv_mpayment);
        exit = (ImageView) root.findViewById(R.id.iv_exit);

        m_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InsertTransfer.class));
            }
        });

        m_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), M_Info.class));
            }
        });

        m_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InsertVirtualAccount.class));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieveData();
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        return root;
    }

    public void retrieveData() {
        ApiRequestData ardData = RetroFitClient.connectDB().create(ApiRequestData.class);
        Call<UserResponse> tampilData = ardData.logout();

        tampilData.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                String message = response.body().getMessage();
                Toast.makeText(getActivity(), "Message : " + message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Server Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
