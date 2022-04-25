package com.example.abcmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abcmobile.R;
import com.example.abcmobile.model.TransferModel;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TransferAdapter extends RecyclerView.Adapter<TransferAdapter.HolderData> {
    private Context ctx;
    private List<TransferModel> listTransfer;

    public TransferAdapter(Context ctx, List<TransferModel> listTransfer) {
        this.ctx = ctx;
        this.listTransfer = listTransfer;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.transfer_post, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        TransferModel tm = listTransfer.get(position);
        holder.tvId.setText(String.valueOf(tm.getId()));
        holder.tvJumlah.setText(String.valueOf(tm.getJumlah()));
        holder.tvBerita.setText(tm.getBerita());
        holder.tvRekeningPengirim.setText(tm.getRekeningPengirim());
        holder.tvRekeningPenerima.setText(tm.getRekeningPenerima());
        holder.tvWaktu.setText(String.valueOf(tm.getWaktu()));
    }

    @Override
    public int getItemCount() {
        return listTransfer.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvId, tvJumlah, tvBerita, tvRekeningPengirim, tvRekeningPenerima, tvWaktu;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id_transfer);
            tvJumlah = itemView.findViewById(R.id.tv_jumlah);
            tvBerita = itemView.findViewById(R.id.tv_berita);
            tvRekeningPengirim = itemView.findViewById(R.id.tv_pengirim);
            tvRekeningPenerima = itemView.findViewById(R.id.tv_penerima);
            tvWaktu = itemView.findViewById(R.id.tv_waktu);
        }
    }
}
