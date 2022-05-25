package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerView;
    private Button changeOrAddNewAddressBtn;
    public static final int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryRecyclerView = findViewById(R.id.delivery_recycler_view);
        changeOrAddNewAddressBtn = findViewById(R.id.change_or_add_address_btn);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_babypampers,"Baby Pampers","Rs. 300/-","Rs. 400/-",1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_babypampers,"Baby Pampers","Rs. 300/-","Rs. 400/-",2));
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_maggi,"Maggie","Rs. 499/-","Rs. 599/-",1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_maggi,"Maggie","Rs. 499/-","Rs. 599/-",2));
        cartItemModelList.add(new CartItemModel(1,"Price (4 items)","Rs. 1998/-","Free","You have saved Rs. 400/- on this Order.","Rs. 1598/-"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeOrAddNewAddressBtn.setVisibility(View.VISIBLE);
        changeOrAddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myAddressIntent = new Intent(DeliveryActivity.this,MyaddressesActivity.class);
                myAddressIntent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(myAddressIntent);
            }
        });

    }
        @Override
        public boolean onOptionsItemSelected(@NonNull  MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home){
                finish();
                return true;
            }
            return super.onOptionsItemSelected(item);

    }
}