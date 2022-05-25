package com.example.mymall;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartItemModel> cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            case CartItemModel.CART_ITEM:
                View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout, viewGroup, false);
                return new CartItemViewHolder(cartItemView);
            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout, viewGroup, false);
                return new CartTotalAmountViewHolder(cartTotalView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (cartItemModelList.get(position).getType()) {
            case CartItemModel.CART_ITEM:
                int resource = cartItemModelList.get(position).getProductImage();
                String title = cartItemModelList.get(position).getProductTitle();
                String productPrice = cartItemModelList.get(position).getProductPrice();
                String cuttedPrice = cartItemModelList.get(position).getCuttedPrice();

                ((CartItemViewHolder)viewHolder).setItemsDetails(resource,title,productPrice,cuttedPrice);
                break;
            case CartItemModel.TOTAL_AMOUNT:
                String totalItems = cartItemModelList.get(position).getTotalItems();
                String totalItemsPrice = cartItemModelList.get(position).getTotalItemPrice();
                String deliveryPrice = cartItemModelList.get(position).getDeliveryPrice();
                String totalAmount = cartItemModelList.get(position).getTotalAmount();
                String savedAmount = cartItemModelList.get(position).getSavedAmount();

                ((CartTotalAmountViewHolder)viewHolder).setTotalAmounts(totalItems,totalItemsPrice,deliveryPrice,totalAmount,savedAmount);

                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;
        private TextView productCuttedPrice;
        private TextView productQuantity;


        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_titlee);
            productPrice = itemView.findViewById(R.id.product_pricee);
            productCuttedPrice = itemView.findViewById(R.id.cutted_pricee);
            productQuantity = itemView.findViewById(R.id.product_quantity);
        }

        private void setItemsDetails(int resources, String title, String productPriceText, String cuttedPrice) {
            productImage.setImageResource(resources);
            productTitle.setText(title);
            productPrice.setText(productPriceText);
            productCuttedPrice.setText(cuttedPrice);
            productQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog quantityDailog = new Dialog(itemView.getContext());
                    quantityDailog.setContentView(R.layout.quantity_dailog);
                    quantityDailog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    quantityDailog.setCancelable(false);
                    final EditText quantityNumber = quantityDailog.findViewById(R.id.quantity_number);
                    Button cancelBtn = quantityDailog.findViewById(R.id.dailog_cancel_btn);
                    Button okBtn = quantityDailog.findViewById(R.id.dailog_ok_btn);

                    cancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            quantityDailog.dismiss();
                        }
                    });
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            productQuantity.setText("Qty: = " +quantityNumber.getText());
                            quantityDailog.dismiss();
                        }
                    });
                    quantityDailog.show();
                }
            });
        }

    }

    class CartTotalAmountViewHolder extends RecyclerView.ViewHolder {

        private TextView totalItems;
        private TextView totalItemsPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView savedAmount;

        public CartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItems = itemView.findViewById(R.id.total_items);
            totalItemsPrice = itemView.findViewById(R.id.total_items_price);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            totalAmount = itemView.findViewById(R.id.total_price);
            savedAmount = itemView.findViewById(R.id.saved_amount);
        }

        private void setTotalAmounts(String totalItemText,String totalItemPriceText,String deliveryPriceText,String totalAmountText, String savedAmountText) {
          totalItems.setText(totalItemText);
          totalItemsPrice.setText(totalItemPriceText);
          deliveryPrice.setText(deliveryPriceText);
          totalAmount.setText(totalAmountText);
          savedAmount.setText(savedAmountText);
        }
    }
}
