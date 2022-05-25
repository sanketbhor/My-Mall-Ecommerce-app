package com.example.mymall;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {

    private List<WishListModel> wishListModelList;
    private Boolean wishlist;

    public WishListAdapter(List<WishListModel> wishListModelList,Boolean wishlist) {
        this.wishListModelList = wishListModelList;
        this.wishlist = wishlist;
    }

    @NonNull
    @Override
    public WishListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishListAdapter.ViewHolder viewHolder, int position) {
        String resource = wishListModelList.get(position).getProductImage();
        String title = wishListModelList.get(position).getProductTitle();
        String rating = wishListModelList.get(position).getRating();
        long totalRatings = wishListModelList.get(position).getTotalRatings();
        String  productPrice = wishListModelList.get(position).getProductPrice();
        String cuttedPrice = wishListModelList.get(position).getCuttedPrice();
        boolean paymentMethod = wishListModelList.get(position).isCOD();
        viewHolder.setData(resource,title,rating,totalRatings,productPrice,cuttedPrice,paymentMethod);

    }

    @Override
    public int getItemCount() {
        return wishListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView productTitle;
        private TextView rating;
        private TextView totalRatings;
        private View priceCut;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageButton deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.wishlist_product_image);
            productTitle = itemView.findViewById(R.id.wishlist_product_title);
            rating = itemView.findViewById(R.id.tv_product_rating_miniview);
            totalRatings = itemView.findViewById(R.id.wishlist_total_ratings);
            priceCut = itemView.findViewById(R.id.wishlist_price_cut);
            productPrice = itemView.findViewById(R.id.wishlist_product_price);
            cuttedPrice = itemView.findViewById(R.id.wishlist_cutted_price);
            paymentMethod = itemView.findViewById(R.id.wishlist_payment_method);
            deleteBtn = itemView.findViewById(R.id.wishlist_delete_btn);

        }
        private void setData(String resource, String title, String averageRate,long totalRatingNo,String price, String cuttedPriceValue, boolean COD){
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.mipmap.app_icon)).into(productImage);
            productTitle.setText(title);
            rating.setText(averageRate);
            totalRatings.setText("("+totalRatingNo+") ratings");
            productPrice.setText("Rs."+price+"/-");
            cuttedPrice.setText("Rs."+cuttedPriceValue+"/-");
            if (COD){
                paymentMethod.setVisibility(View.VISIBLE);
            }else {
                paymentMethod.setVisibility(View.INVISIBLE);
            }
            if (wishlist){
                deleteBtn.setVisibility(View.VISIBLE);
            }else{
                deleteBtn.setVisibility(View.GONE);
            }
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),"delete",Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }
    }
}


