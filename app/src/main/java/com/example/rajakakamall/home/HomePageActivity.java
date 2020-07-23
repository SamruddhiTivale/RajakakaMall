package com.example.rajakakamall.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajakakamall.R;
import com.example.rajakakamall.drawer.ExpandableListDataPump;
import com.example.rajakakamall.listadapters.CustomExpandableListAdapter;
import com.example.rajakakamall.listadapters.ProductsAdapter;
import com.example.rajakakamall.models.Product;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomePageActivity extends AppCompatActivity
        implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private ImageView navToggleBtn;
    private TextView my_profile;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    DrawerLayout drawerLayout;
    CardView cardView;

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "LED TV 18 SAMSUNG",
                        "18 inch, 1.35 kg",
                        4.3,
                        24000,
                        R.drawable.img1));

        productList.add(
                new Product(
                        1,
                        "OVEN ",
                        "15*10 inch, Gray, 10.659 kg",
                        4.3,
                        30000,
                        R.drawable.img2));

        productList.add(
                new Product(
                        1,
                        "Air Cooler",
                        "20.3 inch, White, 12.35 kg",
                        4.3,
                        12000,
                        R.drawable.img3));

        //creating recyclerview adapter
        ProductsAdapter adapter = new ProductsAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);





        // get the listview
        expandableListView = (ExpandableListView) findViewById(R.id.list_group);

        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
                setVisible(true);
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPosition) + " -> "
                        + expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition), Toast.LENGTH_SHORT
                ).show();

                return false;
            }
        });
        mainMethod();
    }




    @Override
    protected void onResume() {
        super.onResume();
    }

    private void mainMethod(){
        drawerLayout= findViewById(R.id.drawer_layout);

        // sub helper methods
        initWidgets();

    }
    private void initWidgets() {

        navToggleBtn = findViewById(R.id.nav_toggle_btn);
        my_profile=findViewById(R.id.my_profile);
        navToggleBtn.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_toggle_btn) {
            // Handle the camera action
            drawerLayout.openDrawer(GravityCompat.START);

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case (R.id.nav_toggle_btn): {
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            }


        }
    }


    }



