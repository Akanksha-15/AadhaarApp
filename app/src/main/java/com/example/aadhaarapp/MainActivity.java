package com.example.aadhaarapp;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,age,phone; RadioGroup rdgender; CheckBox hindi,english;  Button btn,click;  Intent intent;
    ImageView img; Bitmap bitmap;
    byte[] byteArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.num);
        //email=findViewById(R.id.email);
        //gadrs=findViewById(R.id.adrs);

        rdgender=findViewById(R.id.rdgender);

        btn=findViewById(R.id.submit);



        hindi=findViewById(R.id.hindi);
        english=findViewById(R.id.english);

        img=findViewById(R.id.imageview);

        click=findViewById(R.id.clk);
        click.setOnClickListener(this);

    }




    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.submit:
            {
                int id = rdgender.getCheckedRadioButtonId();
                RadioButton rb = rdgender.findViewById(id);
                String gendertype = rb.getText().toString();
                //this code is used to access more than one radio button
                String nm = name.getText().toString();
                String ag = age.getText().toString();
                String ph = phone.getText().toString();
                //String em=email.getText().toString();
                //        String ad=adrs.getText().toString();


                Intent intent = new Intent(this, Detail.class);
                Bundle bundle = new Bundle();   //it is use to store different class of data type
                bundle.putString("name", nm);
                bundle.putString("phone", ph);
                bundle.putString("age", ag);
                bundle.putString("gen", gendertype);

                //convert bitmap to bytearray

                bundle.putByteArray("img", byteArray);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            case R.id.clk:
            {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,2);
            }
            break;
        }






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null) {
            Bundle b = data.getExtras();
            Bitmap bitmap = (Bitmap) b.get("data");
            img.setImageBitmap(bitmap);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();
        }
        //this.finish();

    }


    public void gender(View view)
    {

    }

    public void hind(View view)
    {


    }

    public void eng(View view)
    {

    }
}
