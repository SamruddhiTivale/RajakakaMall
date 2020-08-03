package com.example.rajakakamall.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.rajakakamall.R;
import com.example.rajakakamall.listadapters.ProductImagesAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PrductDetailsActivity extends AppCompatActivity {

    private static boolean ADD_TO_WISHLIST=false;

    private ViewPager viewPagerImages;
    private TabLayout tabLayoutImages;
    private FloatingActionButton wishlistbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prduct_details);

        viewPagerImages=(ViewPager)findViewById(R.id.viewpager_product_images);
        tabLayoutImages=(TabLayout)findViewById(R.id.tablayout_view_pager);

        wishlistbtn=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        tabLayoutImages.setupWithViewPager(viewPagerImages,true);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.img1);
        productImages.add(R.drawable.img2);
        productImages.add(R.drawable.img3);
        productImages.add(R.drawable.img4);

        ProductImagesAdapter productImagesAdapter=new ProductImagesAdapter(productImages);
        viewPagerImages.setAdapter(productImagesAdapter);
    }


    public void addedtoWishlist()
    {
        if(ADD_TO_WISHLIST)
        {

        }
        else {}

    }
}


