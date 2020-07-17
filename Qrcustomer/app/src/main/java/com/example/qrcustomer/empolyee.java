package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class empolyee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empolyee);

        @SuppressLint("ResourceAsColor") AccountHeader hr = new AccountHeaderBuilder()
                .withActivity (this)
                .withHeaderBackground (R.drawable.header)
                .withTextColorRes (R.color.colorAccent)
                .addProfiles(new ProfileDrawerItem().withName ("My profile").withEmail(null).withIcon (R.drawable.aaa))
                .build ();

        PrimaryDrawerItem item1 = new PrimaryDrawerItem() .withIdentifier(1) .withName ("تسجيل دخول").withIcon (R.drawable.aaa);

        PrimaryDrawerItem item2 = new PrimaryDrawerItem() .withIdentifier(2) .withName ("المحلات").withIcon (R.drawable.aaa);

        PrimaryDrawerItem item3 = new PrimaryDrawerItem() .withIdentifier(3) .withName ("الحجز").withIcon (R.drawable.aaa);

        PrimaryDrawerItem item4 = new PrimaryDrawerItem() .withIdentifier(4) .withName ("الاعدادت").withIcon (R.drawable.aaa);

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
                .addDrawerItems(item4)
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
                            Intent a = new Intent (empolyee.this,sign.class);
                            startActivity (a);

                        }

                        if (drawerItem.getIdentifier ()==2) {
                            Intent b = new Intent (empolyee.this,store.class);
                            startActivity (b);

                        }

                        if(drawerItem.getIdentifier ()==3) {

                            Intent c = new Intent (empolyee.this, Terms.class);
                            startActivity (c);
                        }

                        if(drawerItem.getIdentifier ()==4) {

                            Intent d = new Intent (empolyee.this, store.class);
                            startActivity (d);
                        }

                        if(drawerItem.getIdentifier ()==5) {

                            Intent e = new Intent (empolyee.this, ask.class);
                            startActivity (e);
                        }

                        if(drawerItem.getIdentifier ()==6) {

                            Intent e = new Intent (empolyee.this, support.class);
                            startActivity (e);
                        }


                        if(drawerItem.getIdentifier ()==7) {

                            Intent f = new Intent (empolyee.this,sign.class);
                            startActivity (f);
                        }

                        return false;
                    }
                })

                .build ();

    }
}
