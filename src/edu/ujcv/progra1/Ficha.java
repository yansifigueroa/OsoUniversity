package edu.ujcv.progra1;

public class Ficha {

    private int especialidad;
    private int codigo;

    public Ficha(int especialidad, int codigo) {
        this.especialidad = especialidad;
        this.codigo = codigo;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
