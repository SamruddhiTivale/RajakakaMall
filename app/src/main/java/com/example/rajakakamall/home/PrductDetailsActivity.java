package com.example.rajakakamall.home;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.rajakakamall.R;
import com.example.rajakakamall.listadapters.ProductImagesAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrductDetailsActivity extends AppCompatActivity {

    private static boolean ADD_TO_WISHLIST=false;

    private ViewPager viewPagerImages;
    private TabLayout tabLayoutImages;
    private FloatingActionButton wishlistbtn;
    private TextView txttitle,txtprice,txtmrp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prduct_details);

        txttitle=(TextView)findViewById(R.id.txtproductdetailstitle);
        txtprice=(TextView)findViewById(R.id.txtproductdetailsprice);
        txtmrp=(TextView)findViewById(R.id.txtproductdetailsmrp);
        viewPagerImages=(ViewPager)findViewById(R.id.viewpager_product_images);
        tabLayoutImages=(TabLayout)findViewById(R.id.tablayout_view_pager);

        wishlistbtn=(FloatingActionButton)findViewById(R.id.detailsfloatingActionButton);
        tabLayoutImages.setupWithViewPager(viewPagerImages,true);

        setDetails();

    }

    public void setDetails()
    {
        List<Integer> productImages = new ArrayList<>();

        Intent intent=getIntent();
        int productImage=intent.getExtras().getInt("ProductImage");

        productImages.add(productImage);
        productImages.add(R.drawable.img2);
        productImages.add(R.drawable.img3);
        productImages.add(R.drawable.img4);

        String title= Objects.requireNonNull(intent.getExtras()).getString("Title");
        txttitle.setText(title);

        Double price=intent.getExtras().getDouble("Price");
        txtprice.setText(String.valueOf(price));

        Double mrp=intent.getExtras().getDouble("MRP");
        txtmrp.setText(String.valueOf(mrp));


        ProductImagesAdapter productImagesAdapter=new ProductImagesAdapter(productImages);
        viewPagerImages.setAdapter(productImagesAdapter);
    }


    public void addedtoWishlist()
    {
       wishlistbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (ADD_TO_WISHLIST)
               {
                   wishlistbtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#708090")));
               }
               else{
                   wishlistbtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorAccent));
               }
           }
       }) ;

    }
}


