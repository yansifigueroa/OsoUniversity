package edu.ujcv.progra1;

public class alumno {
    private String nombre;
    private Ficha ficha1;
    private Ficha ficha2;
    private int especialidad1;
    private int especialidad2;

    public alumno(String nombre, int especialidad1, int especialidad2) {
        this.nombre = nombre;
        this.especialidad1 = especialidad1;
        this.especialidad2 = especialidad2;
        this.ficha1 = null;
        this.ficha2 = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ficha getFicha1() {
        return ficha1;
    }

    public void setFicha1(Ficha ficha1) {
        this.ficha1 = ficha1;
    }

    public Ficha getFicha2() {
        return ficha2;
    }

    public void setFicha2(Ficha ficha2) {
        this.ficha2 = ficha2;
    }

    public int getEspecialidad1() {
        return especialidad1;
    }

    public void setEspecialidad1(int especialidad1) {
        this.especialidad1 = especialidad1;
    }

    public int getEspecialidad2() {
        return especialidad2;
    }

    public void setEspecialidad2(int especialidad2) {
        this.especialidad2 = especialidad2;
    }
}