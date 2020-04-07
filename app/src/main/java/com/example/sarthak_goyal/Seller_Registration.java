package com.example.sarthak_goyal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class Seller_Registration extends AppCompatActivity {

    EditText shop_name,shop_pin,shop_loc,shop_cat,shop_mob,shop_email,shop_gst;
    TextView front_path,interior_path;

    String ad,n,a,p,m,e;

   Uri front_uri,interior_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__registration);

        shop_name=findViewById(R.id.shop_name);
        shop_pin=findViewById(R.id.shop_pincode);
        shop_loc=findViewById(R.id.shop_location);
        shop_cat=findViewById(R.id.shop_category);
        shop_mob=findViewById(R.id.shop_number);
        shop_email=findViewById(R.id.shop_email);
        shop_gst=findViewById(R.id.shop_gst);

        front_path=findViewById(R.id.image_partner);
        interior_path=findViewById(R.id.interiorimage_path);

        Intent i=getIntent();

         ad=i.getStringExtra("id");
         n=i.getStringExtra("name");
         a=i.getStringExtra("add");
         p=i.getStringExtra("pin");
         m=i.getStringExtra("mob");
         e=i.getStringExtra("email");

        Toast.makeText(getApplicationContext(),"Aadhar ="+ad+" Name ="+n+" Add ="+a+" Pin = "+p+" Mob = "+m+" Email= "+e,Toast.LENGTH_SHORT).show();


        Button upload_front=findViewById(R.id.btn_image);
        Button upload_interior=findViewById(R.id.btn_interior);

        upload_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,10);
            }
        });

        upload_interior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,20);
            }
        });

        Button register = findViewById(R.id.register_seller);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s_name=shop_name.getText().toString();
                final  String s_pin=shop_pin.getText().toString();
                final String s_loc=shop_loc.getText().toString();
                final String s_cat=shop_cat.getText().toString();
                final String s_mob=shop_mob.getText().toString();
                final String s_email=shop_email.getText().toString();
                final String s_gst=shop_gst.getText().toString();
                Intent i = new Intent(getApplicationContext(),Seller_Preview.class);
                i.putExtra("id", ad);
                i.putExtra("name", n);
                i.putExtra("add", a);
                i.putExtra("pin", p);
                i.putExtra("mob", m);
                i.putExtra("email", e);
                i.putExtra("s_name",s_name);
                i.putExtra("s_pin",s_pin);
                i.putExtra("s_loc",s_loc);
                i.putExtra("s_cat",s_cat);
                i.putExtra("s_mob",s_mob);
                i.putExtra("s_email",s_email);
                i.putExtra("s_gst",s_gst);
                i.putExtra("front_path", front_uri.toString());
                i.putExtra("interior_path",interior_uri.toString());
                Toast.makeText(getApplicationContext(),"Aadhar ="+ad+" Name ="+n+" Add ="+a+" Pin = "+p+" Mob = "+m+" Email= "+e+"S name = "+s_name+" S pin ="+s_pin+" S loc="+s_loc+" S cat = "+s_cat+" S mob= "+s_mob+" S email ="+s_email+" S gst = "+s_gst+"FP ="+front_path+" IP= "+interior_path,Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        HorizontalStepView hv;

        hv=findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("Owner\nDetails",1);
        StepBean stepBean1 = new StepBean("Shop\nDetails",-1);
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

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case 10:
                if(resultCode==RESULT_OK) {
                    front_uri = data.getData();
                    String path=data.getData().getPath();
                    front_path.setText(path);
                }
                break;
            case 20:
                if(resultCode==RESULT_OK) {
                    interior_uri = data.getData();
                    String path = data.getData().getPath();
                    interior_path.setText(path);
                }
                break;
        }
    }
}
