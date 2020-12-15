package idat.edu.pe.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Mensualidad implements Parcelable {

    private String cod_mensualidad, vencimiento;

    public Mensualidad(String cod_mensualidad, String vencimiento) {
        this.cod_mensualidad = cod_mensualidad;
        this.vencimiento = vencimiento;
    }

    protected Mensualidad(Parcel in) {
        cod_mensualidad = in.readString();
        vencimiento = in.readString();
    }

    public static final Creator<Mensualidad> CREATOR = new Creator<Mensualidad>() {
        @Override
        public Mensualidad createFromParcel(Parcel in) {
            return new Mensualidad(in);
        }

        @Override
        public Mensualidad[] newArray(int size) {
            return new Mensualidad[size];
        }
    };

    public String getCod_mensualidad() {
        return cod_mensualidad;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cod_mensualidad);
        parcel.writeString(vencimiento);
    }
}
