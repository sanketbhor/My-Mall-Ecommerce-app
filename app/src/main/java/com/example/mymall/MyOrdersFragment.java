package com.example.mymall;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MyOrdersFragment extends Fragment {

    public MyOrdersFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrderRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);

        myOrderRecyclerView = view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myOrderRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.h_s_cococola,2,"Coco cola minipack","Delivered after 5pm"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.h_s_babypampers,3,"Baby Pampers","Delivered after 5pm"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.h_s_maggi,4,"Maggie","Delivered after 5pm"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.h_s_kissanfruitjam,1,"Kissan Fruit Jam","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.h_s_mountaindew,0,"Mountain dew","Cancelled"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrderRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();

    return view;
    }
}