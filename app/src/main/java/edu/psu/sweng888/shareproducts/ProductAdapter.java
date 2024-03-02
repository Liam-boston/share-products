package edu.psu.sweng888.shareproducts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final List<Product> products;
    private int selectedPosition;
    public ProductAdapter(List<Product> products) {
        this.products = products;
        this.selectedPosition = -1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);

        // concatenate price value
        String price = "$" + product.getPrice().toString() + ".00";

        // display product values
        holder.nameTextView.setText(product.getName());
        holder.descriptionTextView.setText(product.getDescription());
        holder.sellerTextView.setText(product.getSeller());
        holder.priceTextView.setText(price);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        public TextView nameTextView, descriptionTextView, sellerTextView, priceTextView;
        public CardView itemCard;

        public ViewHolder(View productView) {
            super(productView);
            context = productView.getContext();

            // initialize class variables
            nameTextView = productView.findViewById(R.id.nameTextView);
            descriptionTextView = productView.findViewById(R.id.descriptionTextView);
            sellerTextView = productView.findViewById(R.id.sellerTextView);
            priceTextView = productView.findViewById(R.id.priceTextView);
            itemCard = productView.findViewById(R.id.itemCard);

            // when an item is selected, open new ProductDetailView
            itemCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setSingleSelection(getAdapterPosition());

                    Intent intent = new Intent(context, ProductDetailView.class);
                    intent.putExtra("selected_product", products.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }

        private void setSingleSelection(int position) {
            if (position == RecyclerView.NO_POSITION) {
                return;
            }

            notifyItemChanged(selectedPosition);
            selectedPosition = position;
            notifyItemChanged(selectedPosition);
        }
    }
}
