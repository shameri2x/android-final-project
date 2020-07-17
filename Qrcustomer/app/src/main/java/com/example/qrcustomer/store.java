package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
 import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class store extends AppCompatActivity {

    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ArrayList<Stores> shop = new ArrayList<>();

        Stores s1 = new Stores(R.drawable.hadosh,"Hadosh kitchen", "Shop",10);
        Stores s2 = new Stores(R.drawable.xcite,"X-cite", "Shop",5);
        Stores s3 = new Stores(R.drawable.nike,"Nike", "Shop",3.3);
        Stores s4= new Stores(R.drawable.adidas,"Adidas", "Shop",5);
        Stores s5 = new Stores(R.drawable.hm,"H&M", "Shop",2.4);
        Stores s6 = new Stores(R.drawable.zara,"ZARA", "Shop",5);
        Stores s7 = new Stores(R.drawable.aldo,"ALDO", "Shop",2.3);
        Stores s8 = new Stores(R.drawable.puma,"PUMA", "Shop",3.5);
        Stores s9 = new Stores(R.drawable.foot,"Foot locker", "Shop",4);
        Stores s10 = new Stores(R.drawable.dior,"DIOR", "Shop",2.8);
        Stores s11 = new Stores(R.drawable.tomy,"Tommy Hilfiger", "Shop",3.5);
        Stores s12 = new Stores(R.drawable.calvin,"Calvin Klein", "Shop",5);



        shop.add(s1);
        shop.add(s2);
        shop.add(s3);
        shop.add(s4);
        shop.add(s5);
        shop.add(s6);
        shop.add(s7);
        shop.add(s8);
        shop.add(s9);
        shop.add(s10);
        shop.add(s11);
        shop.add(s12);


        RecyclerView rv = findViewById(R.id.RecyclerView);

        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        Adapter adapter = new Adapter(shop,this);
        rv.setAdapter(adapter);


        @SuppressLint("ResourceAsColor") AccountHeader hr = new AccountHeaderBuilder()
                .withActivity (this)
                .withHeaderBackground (R.drawable.header)
                .withTextColorRes (R.color.colorAccent)
                .addProfiles(new ProfileDrawerItem().withName ("My profile").withEmail(null).withIcon (R.drawable.aaa))
                .build ();

        PrimaryDrawerItem item1 = new PrimaryDrawerItem() .withIdentifier(1) .withName ("تسجيل دخول").withIcon (R.drawable.aaa);

        PrimaryDrawerItem item2 = new PrimaryDrawerItem() .withIdentifier(2) .withName ("المحلات").withIcon (R.drawable.aaa);

        PrimaryDrawerItem item3 = new PrimaryDrawerItem() .withIdentifier(3) .withName ("الشروط").withIcon (R.drawable.aaa);

        SecondaryDrawerItem item5 = new SecondaryDrawerItem () .withIdentifier(5) .withName ("الاسئلة").withIcon (R.drawable.aaa);

        SecondaryDrawerItem item6 = new SecondaryDrawerItem () .withIdentifier(6) .withName ("التواصل").withIcon (R.drawable.aaa);

        SecondaryDrawerItem item7 = new SecondaryDrawerItem () .withIdentifier(7) .withName ("تسجيل خروج").withIcon (R.drawable.aaa);


        Toolbar toolBar = findViewById (R.id.toolbar);



        new DrawerBuilder()
                .withActivity (this)
                .withToolbar (toolBar)
                .withAccountHeader (hr)
                .addDrawerItems(item1)
                .addDrawerItems(item2)
                .addDrawerItems(item3)
                .addDrawerItems().addStickyDrawerItems()
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(item5)
                .addDrawerItems(item6)
                .addDrawerItems(item7)
                .addDrawerItems(new DividerDrawerItem())


                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (drawerItem.getIdentifier ()==1) {
                            Intent a = new Intent (store.this,sign.class);
                            startActivity (a);

                        }

                        if (drawerItem.getIdentifier ()==2) {
                            Intent b = new Intent (store.this,store.class);
                            startActivity (b);

                        }

                        if(drawerItem.getIdentifier ()==3) {

                            Intent c = new Intent (store.this, Terms.class);
                            startActivity (c);
                        }


                        if(drawerItem.getIdentifier ()==5) {

                            Intent e = new Intent (store.this, ask.class);
                            startActivity (e);
                        }

                        if(drawerItem.getIdentifier ()==6) {

                            Intent e = new Intent (store.this, support.class);
                            startActivity (e);
                        }


                        if(drawerItem.getIdentifier ()==7) {

                            Intent f = new Intent (store.this,sign.class);
                            startActivity (f);
                        }

                        return false;
                    }
                })

                .build ();

    }
}

