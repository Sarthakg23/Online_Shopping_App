package com.example.sarthak_goyal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class Partner_Preview extends AppCompatActivity {

    AlertDialog.Builder builder;

    TextView n,ad,m,e,a,dt,dl,vn;

    String id,name,add,pin,mob,email,vehicle_type,driving_licence,vehicle_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner__preview);

        Intent i=getIntent();
        id=i.getStringExtra("id");
        name=i.getStringExtra("name");
        add=i.getStringExtra("add");
        pin=i.getStringExtra("pin");
        mob=i.getStringExtra("mob");
        email=i.getStringExtra("email");
        vehicle_type=i.getStringExtra("vehicle_type");
        driving_licence=i.getStringExtra("driving_licence");
        vehicle_number=i.getStringExtra("vehicle_number");
        Uri image_uri = Uri.parse(i.getStringExtra("image_path"));

        ImageView imageView=findViewById(R.id.imageview_partner);

        imageView.setImageURI(image_uri);

        n=findViewById(R.id.prev_name_partner);
        ad=findViewById(R.id.prev_aadhar_partner);
        m=findViewById(R.id.prev_mob_partner);
        e=findViewById(R.id.prev_email_partner);
        a=findViewById(R.id.prev_address_partner);
        dt=findViewById(R.id.prev_dt_partner);
        dl=findViewById(R.id.prev_dl_partner);
        vn=findViewById(R.id.prev_vn_partner);

        n.setText(name);
        ad.setText(id);
        m.setText(mob);
        e.setText(email);
        a.setText(add+","+pin);
        dt.setText(vehicle_type);
        dl.setText(driving_licence);
        vn.setText(vehicle_number);


        HorizontalStepView hv;

        hv=findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("Profile\nDetails",1);
        StepBean stepBean1 = new StepBean("Vehicle\nDetails",1);
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



        Button b=findViewById(R.id.button3);
        builder = new AlertDialog.Builder(this);

       final CheckBox cb=findViewById(R.id.checkBox3);
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
