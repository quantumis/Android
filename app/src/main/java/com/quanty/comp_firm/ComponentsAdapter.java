package com.quanty.comp_firm;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ComponentsAdapter extends BaseAdapter {

    private Context mContext;
    private List<Components> mComponentsList;

    public ComponentsAdapter(Context mContext, List<Components> mComponentsList) {
        this.mContext = mContext;
        this.mComponentsList = mComponentsList;
    }

    @Override
    public int getCount() {
        return mComponentsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mComponentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mComponentsList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.item_component,null);

        ImageView imgSource = v.findViewById(R.id.imageViewPhoto);
        TextView txtname = v.findViewById(R.id.textViewName);
        TextView txtcategory = v.findViewById(R.id.textViewCategory);
        TextView txtprice = v.findViewById(R.id.textViewPriceR);

        Components currentComponent = mComponentsList.get(position);

        imgSource.setImageBitmap(currentComponent.getBitmapSource());
        txtname.setText(currentComponent.getModel());
        txtcategory.setText(currentComponent.getIdC());
        txtprice.setText((int) currentComponent.getPrice_R());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetails = new Intent(mContext, Detail_Activity.class);

                intentDetails.putExtra("component", currentComponent);

                mContext.startActivity(intentDetails);
            }
        });

        return v;
    }
}
