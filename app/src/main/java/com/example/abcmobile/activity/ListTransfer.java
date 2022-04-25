package com.example.abcmobile.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abcmobile.R;
import com.example.abcmobile.adapter.TransferAdapter;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.TransferModel;
import com.example.abcmobile.model.TransferResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTransfer extends Fragment {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<TransferModel> listTransfer = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.list_transaksi, container, false);
        super.onCreate(savedInstanceState);

        rvData = (RecyclerView) root.findViewById(R.id.rvTransfer);
        lmData = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        retrieveData();
        return root;
    }

    public void retrieveData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.14:8080/listTransfer", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for(int i = 0; i < jsonArray.length(); i++){
                        TransferModel tm = new TransferModel();
                        JSONObject obj = jsonArray.getJSONObject(i);
                        tm.setJumlah(obj.getInt("jumlah"));
                        tm.setBerita(obj.getString("berita"));
                        tm.setRekeningPenerima(obj.getString("rekening_penerima"));
                        tm.setRekeningPengirim(obj.getString("rekening_pengirim"));
                        tm.setWaktu(obj.getString("waktu"));
                        listTransfer.add(tm);
                    }
                    adData = new TransferAdapter(getContext(), listTransfer);
                    rvData.setAdapter(adData);
                    adData.notifyDataSetChanged();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Failed Catch Data! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
