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

public class ProductSpecificationFragment extends Fragment {


    public ProductSpecificationFragment() {
        // Required empty public constructor
    }


    private RecyclerView productSpecificationRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_product_specification, container, false);

        productSpecificationRecyclerView = view.findViewById(R.id.product_specification_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        productSpecificationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mixed Spices","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Noodle Powder","33.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Flavour","10.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Sugar And Salt","5.3%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Oil","7.2%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Thickner","15.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Minerals","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Display"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mixed Spices","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Noodle Powder","33.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Flavour","10.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Sugar And Salt","5.3%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Oil","7.2%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Thickner","15.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Minerals","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Details"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mixed Spices","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Noodle Powder","33.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Flavour","10.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Sugar And Salt","5.3%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Oil","7.2%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Thickner","15.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Minerals","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mixed Spices","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Noodle Powder","33.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Flavour","10.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Sugar And Salt","5.3%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Oil","7.2%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Thickner","15.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Minerals","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Display"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mixed Spices","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Noodle Powder","33.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Flavour","10.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Sugar And Salt","5.3%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Oil","7.2%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Thickner","15.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Minerals","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Details"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mixed Spices","23.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Noodle Powder","33.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Flavour","10.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Sugar And Salt","5.3%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Oil","7.2%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Thickner","15.6%"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Minerals","23.6%"));

        ProductSpecificationAdapter productSpecificationAdapter = new ProductSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecyclerView.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();

        return view;
    }

}