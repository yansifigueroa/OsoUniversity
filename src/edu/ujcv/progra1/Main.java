package edu.ujcv.progra1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Ficha> o = new Stack<Ficha>();
        Stack<Ficha> n = new Stack<Ficha>();
        Stack<Ficha> p = new Stack<Ficha>();

        // llenar

        for (int i = 1; i <= 20; i++) {
            o.push(new Ficha(Constantes. primer_parcial, i));
            n.push(new Ficha(Constantes. segundo_parcial, i));
            p.push(new Ficha(Constantes. tercer_parcial, i));
        }

        System.out.println("primer parcial");
        mostrar(o);
        System.out.println("segundo parcial");
        mostrar(n);
        System.out.println("tercer parcial");
        mostrar(p);

        Queue<alumno> alumnos = new LinkedList<alumno>();

        alumnos.add(new alumno("Nombre1", Constantes.primer_parcial, Constantes.aprobado));
        alumnos.add(new alumno("Nombre2", Constantes.tercer_parcial, Constantes.reprobado));
        alumnos.add(new alumno("Nombre3", Constantes.segundo_parcial, Constantes.aprobado));
        alumnos.add(new alumno("Nombre4", Constantes.primer_parcial, Constantes.reprobado));
        alumnos.add(new alumno("Nombre5", Constantes.primer_parcial, Constantes.reprobado));
        alumnos.add(new alumno("Nombre6", Constantes.tercer_parcial, Constantes.reprobado));
        alumnos.add(new alumno("Nombre7", Constantes.segundo_parcial, Constantes.reprobado));
        alumnos.add(new alumno("Nombre8", Constantes.segundo_parcial, Constantes.reprobado));
        alumnos.add(new alumno("Nombre9", Constantes.segundo_parcial, Constantes.reprobado));
        alumnos.add(new alumno("Nombre10", Constantes.segundo_parcial, Constantes.reprobado));

        System.out.println("ALUMNOS");
        mostrar(alumnos);

        // Solución 1
        asignarFichas(o, n, p, alumnos);


        System.out.println("primer parcial");
        mostrar(o);
        System.out.println("segundo parcial");
        mostrar(n);
        System.out.println("tercer parcial");
        mostrar(p);

        // Solución 2
        // Calcular cual es la especialidad mas requerida
        calcularEspecidadMasRequerida(o, n, p);

        // Solución 3
        // Realizar el metodo atender para devolver la ficha a su lugar


        alumno alumn = alumnos.remove();
        System.out.println("> alumno: " + alumn.getNombre());
        atender(alumn, o, p, n);

    }

    private static void atender(alumno alumn, Stack<Ficha> o, Stack<Ficha> p, Stack<Ficha> n) {
        if (alumn.getEspecialidad1() == Constantes.primer_parcial) {
            Ficha fi = alumn.getFicha1();
            o.push(fi);
            // reset
            alumn.setFicha1(null);
            alumn.setEspecialidad1(Constantes.reprobado);
        } else if (alumn.getEspecialidad1() == Constantes.segundo_parcial) {
            Ficha fi = alumn.getFicha1();
            n.push(fi);
            // reset
            alumn.setFicha1(null);
            alumn.setEspecialidad1(Constantes.reprobado);
        } else if (alumn.getEspecialidad1() == Constantes.segundo_parcial) {
            Ficha fi = alumn.getFicha1();
            n.push(fi);
            // reset
            alumn.setFicha1(null);
            alumn.setEspecialidad1(Constantes.reprobado);
        }
        if (alumn.getEspecialidad2() != Constantes.reprobado) {
            if (alumn.getEspecialidad2() == Constantes.aprobado) {
                Ficha fi = alumn.getFicha2();
                o.push(fi);
                // reset
                alumn.setFicha2(null);
                alumn.setEspecialidad2(Constantes.reprobado);
            } else if (alumn.getEspecialidad2() == Constantes.tercer_parcial) {
                Ficha fi = alumn.getFicha2();
                p.push(fi);
                // reset
                alumn.setFicha2(null);
                alumn.setEspecialidad2(Constantes.reprobado);
            } else if (alumn.getEspecialidad2() == Constantes.segundo_parcial) {
                Ficha fi = alumn.getFicha2();
                n.push(fi);
                // reset
                alumn.setFicha2(null);
                alumn.setEspecialidad2(Constantes.reprobado);
            }
        }
    }

    private static void calcularEspecidadMasRequerida(Stack<Ficha> o, Stack<Ficha> n, Stack<Ficha> p) {

        int no = o.size();
        int np = p.size();
        int nn = n.size();

        if (no < np && no < nn) {
            System.out.println("primer parcial es más requerido");
        }
        if (np < no && np < nn) {
            System.out.println("tercer parcial es más requerido");
        }
        if (nn < no && nn < np) {
            System.out.println("segundo parcial es más requerido");
        }


    }

    private static void asignarFichas(Stack<Ficha> o, Stack<Ficha> n, Stack<Ficha> p, Queue<alumno> alumnos) {

        int m = alumnos.size();
        for (int i = 0; i < m; i++) {
            alumno alumn = alumnos.remove();

            if (alumn.getEspecialidad1() == Constantes.segundo_parcial) {
                Ficha fi = n.pop();
                alumn.setFicha1(fi);
            } else if (alumn.getEspecialidad1() == Constantes.primer_parcial) {
                Ficha fi = o.pop();
                alumn.setFicha1(fi);
            } else if (alumn.getEspecialidad1() == Constantes.tercer_parcial) {
                Ficha fi = p.pop();
                alumn.setFicha1(fi);
            }


            if (alumn.getEspecialidad2() != Constantes.reprobado) {
                if (alumn.getEspecialidad2() == Constantes.aprobado) {
                    Ficha fi = n.pop();
                    alumn.setFicha2(fi);
                } else if (alumn.getEspecialidad2() == Constantes.primer_parcial) {
                    Ficha fi = o.pop();
                    alumn.setFicha2(fi);
                } else if (alumn.getEspecialidad2() == Constantes.tercer_parcial) {
                    Ficha fi = p.pop();
                    alumn.setFicha2(fi);
                }
            }

            alumnos.add(alumn);
        }

    }

    private static void mostrar(Stack<Ficha> o) {

        Stack<Ficha> temp = new Stack<Ficha>();

        while (!o.isEmpty()) {
            Ficha fi = o.pop();
            System.out.println(" Ficha: " + fi.getEspecialidad() + " " + fi.getCodigo());
            temp.push(fi);
        }
        while (!temp.isEmpty()) {
            Ficha fi = temp.pop();
            o.push(fi);
        }
    }

    public static void mostrar(Queue<alumno> cola) {
        int n = cola.size();
        for (int i = 0; i < n; i++) {
            alumno alumn = cola.remove();
            System.out.println(" alumno: " + alumn.getNombre() + " Especialidades: " + alumn.getEspecialidad1() + ", " + alumn.getEspecialidad2());
            cola.add(alumn);
        }
    }
}
