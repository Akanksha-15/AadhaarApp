package com.example.aadhaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    TextView name,age,phone,email,address,gender,lange,langh;
    Intent intent;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent=getIntent();
        //name=findViewById(R.id.name1);
        //age=findViewById(R.id.age1);
        //phone=findViewById(R.id.phone1);
        /*email=findViewById(R.id.email1);
        address=findViewById(R.id.address1);*/
        //gender=findViewById(R.id.gender1);
        //lange=findViewById(R.id.lange1);
        //langh=findViewById(R.id.langh1);
        //img=findViewById(R.id.img);


        /*String d1=intent.getStringExtra("username");
        String d2=intent.getStringExtra("age");
        String d3=intent.getStringExtra("phone");
        String d4=intent.getStringExtra("email");
        String d5=intent.getStringExtra("address");
        String d6=intent.getStringExtra("gender");
        String d7=intent.getStringExtra("lange");
        String d8=intent.getStringExtra("langh");
        name.setText("user name is"+d1);
        age.setText("user age is"+d2);
        phone.setText("user phone"+d3);
        email.setText("email is "+d4);
        address.setText("address is "+d5); 
        gender.setText("gender "+d6);
        langh.setText("language is "+d7);
        lange.setText(""+d8);
        */


        Bundle bundle=intent.getExtras();
        String name=bundle.getString("name");
        String phone=bundle.getString("phone");
        String age=bundle.getString("age");
        String gender=bundle.getString("gen");



        Toast.makeText(this, ""+name+phone+age+gender, Toast.LENGTH_SHORT).show();
       //convert byte array to bitmap
        byte[] byteArray=bundle.getByteArray("img");
        Bitmap bmp=BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        img.setImageBitmap(bmp);
    }

}
