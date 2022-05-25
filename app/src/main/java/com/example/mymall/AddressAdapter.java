package com.example.mymall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.mymall.DeliveryActivity.SELECT_ADDRESS;
import static com.example.mymall.MyAccountFragment.MANAGE_ADDRESS;
import static com.example.mymall.MyaddressesActivity.refreshItem;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    private List<AddressesModel> addressesModelList;
    private int MODE;
    private int preSelectedPosition = -1;

    public AddressAdapter(List<AddressesModel> addressesModelList,int MODE) {
        this.addressesModelList = addressesModelList;
        this.MODE = MODE;
    }

    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder viewHolder, int position) {
        String name = addressesModelList.get(position).getFullName();
        String address = addressesModelList.get(position).getAddress();
        String pincode = addressesModelList.get(position).getPincode();
        Boolean selected = addressesModelList.get(position).getSelected();
        viewHolder.setData(name,address,pincode,selected,position);
    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView fullname;
        private TextView address;
        private TextView pincode;
        private ImageView icon;
        private LinearLayout optionContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullname = itemView.findViewById(R.id.name_1);
            address = itemView.findViewById(R.id.address_1);
            pincode = itemView.findViewById(R.id.pincode_1);
            icon = itemView.findViewById(R.id.icon_view);
            optionContainer = itemView.findViewById(R.id.option_container);
        }
        private void setData(String username, String userAddress, String userPincode, Boolean selected, final int position){
            fullname.setText(username);
            address.setText(userAddress);
            pincode.setText(userPincode);

            if (MODE == SELECT_ADDRESS){
                icon.setImageResource(R.drawable.correct_sign);
                if (selected){
                    icon.setVisibility(View.VISIBLE);
                    preSelectedPosition = position;
                }else {
                    icon.setVisibility(View.GONE);
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (preSelectedPosition != position) {
                            addressesModelList.get(position).setSelected(true);
                            addressesModelList.get(preSelectedPosition).setSelected(false);
                            refreshItem(preSelectedPosition, position);
                            preSelectedPosition = position;
                        }
                    }
                });
            }else if (MODE == MANAGE_ADDRESS){
                optionContainer.setVisibility(View.GONE);
                icon.setImageResource(R.mipmap.vertical_dots);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        optionContainer.setVisibility(View.VISIBLE);
                        refreshItem(preSelectedPosition,preSelectedPosition);
                        preSelectedPosition = position;
                    }
                });
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshItem(preSelectedPosition,preSelectedPosition);
                        preSelectedPosition = -1;
                    }
                });
            }
        }
    }
}
