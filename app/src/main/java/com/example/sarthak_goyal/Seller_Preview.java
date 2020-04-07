package com.example.sarthak_goyal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Seller_Preview extends AppCompatActivity {

    AlertDialog.Builder builder;

    String id,n,a,p,m,e,sname,spin,sloc,scat,smob,semail,sgst,fp,ip;

    TextView shop_name,shop_add,shop_mob,shop_email,shop_gst,name,address,mobile,email,aadhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__preview);

        Intent i=getIntent();
        id=i.getStringExtra("id");
        n=i.getStringExtra("name");
        a=i.getStringExtra("add");
        p=i.getStringExtra("pin");
        m=i.getStringExtra("mob");
        e=i.getStringExtra("email");
        sname=i.getStringExtra("s_name");
        spin=i.getStringExtra("s_pin");
        sloc=i.getStringExtra("s_loc");
        scat=i.getStringExtra("s_cat");
        smob=i.getStringExtra("s_mob");
        semail=i.getStringExtra("s_email");
        sgst=i.getStringExtra("s_gst");


        Toast.makeText(getApplicationContext(),"Aadhar ="+id+" Name ="+n+" Add ="+a+" Pin = "+p+" Mob = "+m+" Email= "+e+"S name = "+sname+" S pin ="+spin+" S loc="+sloc+" S cat = "+scat+" S mob= "+smob+" S email ="+semail+" S gst = "+sgst+"FP ="+fp+" IP= "+ip,Toast.LENGTH_SHORT).show();

        shop_name=findViewById(R.id.prev_shopname);
        shop_add=findViewById(R.id.preview_shopaddress);
        shop_mob=findViewById(R.id.prev_shopmob);
        shop_email=findViewById(R.id.prev_shopemail);
        shop_gst=findViewById(R.id.prev_shopgst);

        name=findViewById(R.id.prev_name);
        address=findViewById(R.id.prev_add);
        mobile=findViewById(R.id.prev_mob);
        email=findViewById(R.id.prev_email);
        aadhar=findViewById(R.id.prev_aadhar);

        String final_shop_add=sloc+", "+spin;

        shop_name.setText(sname);
        shop_add.setText(final_shop_add);
        shop_mob.setText(smob);
        shop_email.setText(semail);
        shop_gst.setText(sgst);

        name.setText(n);
        address.setText(a);
        mobile.setText(m);
        email.setText(e);
        aadhar.setText(id);

        Uri front_uri = Uri.parse(i.getStringExtra("front_path"));
        Uri interior_uri = Uri.parse(i.getStringExtra("interior_path"));

        /*try {
            Bitmap interior_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), interior_uri);
            Bitmap front_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), front_uri);
            ImageView front=findViewById(R.id.front_imageview);
            ImageView interior=findViewById(R.id.interior_imageview);

            front.setImageBitmap(front_bitmap);
            interior.setImageBitmap(interior_bitmap);
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/

        ImageView front=findViewById(R.id.front_imageview);
        ImageView interior=findViewById(R.id.interior_imageview);

        front.setImageURI(front_uri);
        interior.setImageURI(interior_uri);



        HorizontalStepView hv;

        hv=findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("Owner\nDetails",1);
        StepBean stepBean1 = new StepBean("Shop\nDetails",1);
        StepBean stepBean2 = new StepBean("Preview\nand\nSubmit",-1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);

        hv
                .setStepViewTexts(stepsBeanList)
                .setTextSize(12)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_green_dark))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(getApplicationContext(), android.R.color.darker_gray))
                .setStepViewComplectedTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.check))//StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.default_icon))//StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.attention));//StepsViewIndicator AttentionIcon



       Button b=findViewById(R.id.button2);
        builder = new AlertDialog.Builder(this);

        final CheckBox cb=findViewById(R.id.checkBox2);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if (cb.isChecked()) {

                   builder.setMessage("Thank You for connect with Us.\nPlease Download and install your\nAdmin Panel")
                           .setCancelable(false)
                           .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   finish();
                                   Toast.makeText(getApplicationContext(), "You choose Cancel",
                                           Toast.LENGTH_SHORT).show();
                               }
                           })
                           .setNegativeButton("Download", new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   //  Action for 'NO' Button
                                   dialog.cancel();
                                   Toast.makeText(getApplicationContext(), "You choose Download",
                                           Toast.LENGTH_SHORT).show();
                               }
                           });
                   //Creating dialog box
                   AlertDialog alert = builder.create();
                   //Setting the title manually
                   alert.setTitle("");
                   alert.show();
               }

               else
                   Toast.makeText(getApplicationContext(),"Please tick the checkbox",Toast.LENGTH_SHORT).show();
           }
       });
    }
}

