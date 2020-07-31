package com.example.rajakakamall.listadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rajakakamall.R;
import com.example.rajakakamall.models.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    OnItemListener onItemListener;
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Product> productList;

    //getting the context and product list with constructor
    public ProductsAdapter(Context mCtx, List<Product> productList,OnItemListener onItemListener) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.onItemListener=onItemListener;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view,onItemListener);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Product product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewMrp.setText(String.valueOf(product.getMrp()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView textViewTitle,  textViewPrice, textViewMrp;
        ImageView imageView;
        OnItemListener onItemListener;

        public ProductViewHolder(View itemView,OnItemListener onItemListener) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewMrp=itemView.findViewById(R.id.textViewMrp);
            imageView = itemView.findViewById(R.id.imageView);
            this.onItemListener=onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener
    {
        void onItemClick(int position);
    }
}