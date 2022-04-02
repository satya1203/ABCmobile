package com.example.abcmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abcmobile.R;
import com.example.abcmobile.model.AccountModel;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.HolderData> {
    private Context ctx;
    private List<AccountModel> listAccount;

    public AccountAdapter(Context ctx, List<AccountModel> listAccount) {
        this.ctx = ctx;
        this.listAccount = listAccount;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_saldo, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        AccountModel am = listAccount.get(position);

        holder.tv_username.setText(am.getUser());
        holder.tv_norek.setText(am.getNomorRekening());
        holder.tv_saldo.setText(String.valueOf(am.getSaldo()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tv_id, tv_username, tv_norek, tv_saldo;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tv_username = itemView.findViewById(R.id.tv_username);
            tv_norek = itemView.findViewById(R.id.tv_norek);
            tv_saldo = itemView.findViewById(R.id.tv_saldo);
        }
    }
}
