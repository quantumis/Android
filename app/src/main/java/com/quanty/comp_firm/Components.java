package com.quanty.comp_firm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

public class Components implements Parcelable {
    private int id;
    private String idC;
    private String idM;
    private String Model;
    private int Quantity;
    private double Price_R;
    private String Image;

    public Components(int id, String idC, String idM, String model, int quantity, double price_R, String image) {
        this.id = id;
        this.idC = idC;
        this.idM = idM;
        this.Model = model;
        this.Quantity = quantity;
        this.Price_R = price_R;
        this.Image = image;
    }

    protected Components(Parcel in) {
        id = in.readInt();
        idC = in.readString();
        idM = in.readString();
        Model = in.readString();
        Quantity = in.readInt();
        Price_R = in.readDouble();
        Image = in.readString();
    }

    public static final Creator<Components> CREATOR = new Creator<Components>() {
        @Override
        public Components createFromParcel(Parcel in) {
            return new Components(in);
        }

        @Override
        public Components[] newArray(int size) {
            return new Components[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getIdM() {
        return idM;
    }

    public void setIdM(String idM) {
        this.idM = idM;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice_R() {
        return Price_R;
    }

    public void setPrice_R(double price_R) {
        Price_R = price_R;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Bitmap getBitmapSource(){
        byte[] array = Base64.decode(getImage(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(array,0,array.length);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(idC);
        dest.writeString(idM);
        dest.writeString(Model);
        dest.writeInt(Quantity);
        dest.writeDouble(Price_R);
        dest.writeString(Image);
    }
}
