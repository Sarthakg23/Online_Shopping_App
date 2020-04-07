package com.example.sarthak_goyal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class Signup_Seller extends AppCompatActivity {

    EditText id,name,add,pin,mob,email,pass,repass;

    String ad,n,a,p,m,e,pa,rpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__seller);

        Button next=findViewById(R.id.seller_next);

        id=findViewById(R.id.aadhar_seller);
        name=findViewById(R.id.name_seller);
        add=findViewById(R.id.address_seller);
        pin=findViewById(R.id.pincode_seller);
        mob=findViewById(R.id.mobile_seller);
        email=findViewById(R.id.email_seller);
        pass=findViewById(R.id.password_seller);
        repass=findViewById(R.id.repassword_seller);



        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ad=id.getText().toString();
                n=name.getText().toString();
                a=add.getText().toString();
                p=pin.getText().toString();
                m=mob.getText().toString();
                e=email.getText().toString();
                pa=pass.getText().toString();
                rpa=repass.getText().toString();

                if(pa.equals(rpa)) {

                    Intent i = new Intent(getApplicationContext(), Seller_Registration.class);
                    i.putExtra("id", ad);
                    i.putExtra("name", n);
                    i.putExtra("add", a);
                    i.putExtra("pin", p);
                    i.putExtra("mob", m);
                    i.putExtra("email", e);
                    i.putExtra("pass",pa);
                    Toast.makeText(getApplicationContext(),"Aadhar ="+ad+" Name ="+n+" Add ="+a+" Pin = "+p+" Mob = "+m+" Email= "+e,Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Password Mismatch!",Toast.LENGTH_SHORT).show();
            }
        });


        HorizontalStepView hv;

        hv=findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("Owner\nDetails",-1);
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
}
