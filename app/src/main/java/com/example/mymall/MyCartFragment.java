package com.example.mymall;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {



    public MyCartFragment() {

    }

    private RecyclerView cartItemRecyclerView;
    private Button continueBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemRecyclerView = view.findViewById(R.id.cart_items_recycler_view);
        continueBtn = view.findViewById(R.id.cart_continue_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_babypampers,"Baby Pampers","Rs. 300/-","Rs. 400/-",1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_babypampers,"Baby Pampers","Rs. 300/-","Rs. 400/-",2));
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_maggi,"Maggie","Rs. 499/-","Rs. 599/-",1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.h_s_maggi,"Maggie","Rs. 499/-","Rs. 599/-",2));
        cartItemModelList.add(new CartItemModel(1,"Price (4 items)","Rs. 1998/-","Free","You have saved Rs. 400/- on this Order.","Rs. 1598/-"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deliveryIntent = new Intent(getContext(),AddAddressActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });

        return view;
    }
}