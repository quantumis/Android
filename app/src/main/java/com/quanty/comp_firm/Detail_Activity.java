package com.quanty.comp_firm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Components currentComponents = getIntent().getParcelableExtra("component");
        ImageView imgPhoto = findViewById(R.id.DetailImageView);
        TextView txtname = findViewById(R.id.textViewDetailName);
        TextView txtmanufacturer = findViewById(R.id.textViewManufacturer);
        TextView txtquanty = findViewById(R.id.textViewQuantity);
        TextView txtcategory = findViewById(R.id.textViewCategory);

        imgPhoto.setImageBitmap(currentComponents.getBitmapSource());
        txtname.setText(currentComponents.getModel());
        txtmanufacturer.setText(currentComponents.getIdM());
        txtquanty.setText(currentComponents.getQuantity());
        txtcategory.setText(currentComponents.getIdC());
    }
}