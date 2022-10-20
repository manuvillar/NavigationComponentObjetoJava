package com.example.navigationcomponentobjeto;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    String Nombre;
    String Apellidos;
    Integer telefono;

    public Persona(String nombre, String apellidos, Integer telefono) {
        Nombre = nombre;
        Apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    protected Persona(Parcel in) {
        Nombre = in.readString();
        Apellidos = in.readString();
        if (in.readByte() == 0) {
            telefono = null;
        } else {
            telefono = in.readInt();
        }
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Nombre);
        parcel.writeString(Apellidos);
        if (telefono == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(telefono);
        }
    }
}
