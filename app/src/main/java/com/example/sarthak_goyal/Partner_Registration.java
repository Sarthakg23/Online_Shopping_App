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

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class Partner_Registration extends AppCompatActivity {

    EditText vehicle_type,driving_licence,vehicle_number;
    TextView image_path;

    String a,n,m,ad,pin,e,vt,dl,vn;

    Uri imageuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner__registration);

        Intent i=getIntent();

        a=i.getStringExtra("id");
        n=i.getStringExtra("name");
        ad=i.getStringExtra("add");
        pin=i.getStringExtra("pin");
        m=i.getStringExtra("mob");
        e=i.getStringExtra("email");

        vehicle_type=findViewById(R.id.vehicle_type);
        driving_licence=findViewById(R.id.driving_license);
        vehicle_number=findViewById(R.id.vehicle_number);

        image_path=findViewById(R.id.image_path);

        Button image=findViewById(R.id.btn_image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,10);
            }
        });

        Button register = findViewById(R.id.register_partner);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vt=vehicle_type.getText().toString();
                dl=driving_licence.getText().toString();
                vn=vehicle_number.getText().toString();
                Intent i=new Intent(getApplicationContext(),Partner_Preview.class);
                i.putExtra("id", a);
                i.putExtra("name", n);
                i.putExtra("add", ad);
                i.putExtra("pin", pin);
                i.putExtra("mob", m);
                i.putExtra("email", e);
                i.putExtra("vehicle_type",vt);
                i.putExtra("driving_licence",dl);
                i.putExtra("vehicle_number",vn);
                i.putExtra("image_path",imageuri.toString());
                startActivity(i);
            }
        });


        HorizontalStepView hv;

        hv=findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("Profile\nDetails",1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    imageuri = data.getData();
                    String path = data.getData().getPath();
                    image_path.setText(path);
                }
                break;
        }
    }
}
