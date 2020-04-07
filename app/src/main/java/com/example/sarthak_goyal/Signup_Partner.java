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

public class Signup_Partner extends AppCompatActivity {

    EditText aadhar,name,address,pin,mobile,email,password,repassword;

    String a,n,ad,p,m,e,pa,rp;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__partner);

        aadhar=findViewById(R.id.aadhar_partner);
        name=findViewById(R.id.prev_name_partner);
        address=findViewById(R.id.address_partner);
        pin=findViewById(R.id.pincode_partner);
        mobile=findViewById(R.id.mobile_partner);
        email=findViewById(R.id.email_partner);
        password=findViewById(R.id.password_partner);
        repassword=findViewById(R.id.repassword_partner);



        Button next = findViewById(R.id.partner_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = aadhar.getText().toString();
                n = name.getText().toString();
                ad = address.getText().toString();
                p = pin.getText().toString();
                m = mobile.getText().toString();
                e = email.getText().toString();
                pa = password.getText().toString();
                rp = repassword.getText().toString();
                if(pa.equals(rp))
                {
                    Intent i = new Intent(getApplicationContext(), Partner_Registration.class);
                    i.putExtra("id", a);
                    i.putExtra("name", n);
                    i.putExtra("add", ad);
                    i.putExtra("pin", p);
                    i.putExtra("mob", m);
                    i.putExtra("email", e);
                    startActivity(i);
                }
                else
                Toast.makeText(getApplicationContext(),"Password Mismatch!",Toast.LENGTH_SHORT).show();
            }
        });



        HorizontalStepView hv;

        hv=findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("Profile\nDetails",-1);
        StepBean stepBean1 = new StepBean("Vehicle\nDetails",-1);
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
