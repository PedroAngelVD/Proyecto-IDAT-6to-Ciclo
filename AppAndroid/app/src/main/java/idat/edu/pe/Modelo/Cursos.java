package idat.edu.pe.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Cursos implements Parcelable {

    private String id_curso, curso;

    public Cursos(String id_curso, String curso) {
        this.id_curso = id_curso;
        this.curso = curso;
    }

    protected Cursos(Parcel in) {
        id_curso = in.readString();
        curso = in.readString();
    }

    public static final Creator<Cursos> CREATOR = new Creator<Cursos>() {
        @Override
        public Cursos createFromParcel(Parcel in) {
            return new Cursos(in);
        }

        @Override
        public Cursos[] newArray(int size) {
            return new Cursos[size];
        }
    };

    public String getId_curso() {
        return id_curso;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_curso);
        parcel.writeString(curso);
    }
}
