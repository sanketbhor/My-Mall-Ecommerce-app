package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.mymall.DeliveryActivity.SELECT_ADDRESS;

public class MyaddressesActivity extends AppCompatActivity {

    private RecyclerView myAddressRecyclerView;
    private Button deliverHereBtn;
    private static AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaddresses);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myAddressRecyclerView =findViewById(R.id.addresses_recyclerView);
        deliverHereBtn = findViewById(R.id.deliver_hereBtn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddressRecyclerView.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Sanket Bhor","MarketYard, Chakan","410501",true));
        addressesModelList.add(new AddressesModel("Sanket Bhor","MarketYard, Chakan","41501",false));
        addressesModelList.add(new AddressesModel("abc","Chakan","10501",false));
        addressesModelList.add(new AddressesModel("xyz","MarketYard","0501",false));
        addressesModelList.add(new AddressesModel("abc","Market","401",false));
        addressesModelList.add(new AddressesModel("Sanket Bhor","MarketYard, Chakan","410501",false));

        int mode = getIntent().getIntExtra("MODE",-1);
        if (mode == SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }else{
            deliverHereBtn.setVisibility(View.GONE);
        }
        addressAdapter = new AddressAdapter(addressesModelList,mode);
        myAddressRecyclerView.setAdapter(addressAdapter);
        ((SimpleItemAnimator)myAddressRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressAdapter.notifyDataSetChanged();
    }

    public static void refreshItem(int deselect,int select){
        addressAdapter.notifyItemChanged(deselect);
        addressAdapter.notifyItemChanged(select);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}