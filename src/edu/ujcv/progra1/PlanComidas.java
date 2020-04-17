package edu.ujcv.progra1;

import java.util.ArrayList;
import java.util.List;

public class PlanComidas {
    private List<String> menu;




    public PlanComidas(){
        menu = new ArrayList<String>();
        menu.add("desayuno Tipico");
        menu.add("baleadas");
        menu.add("pupusas");
        menu.add("catrachas");
    }
    // CRUD

    public void agregarComida(String comida){

        menu.add(comida);

    }

    public void mostrarComidas(int page, int size){

        System.out.println("menu de opciones \n\t\tpagina:"+(page+1));
        for (int i = page * size ; i < menu.size() && i < page * size + size ; i++) {
            System.out.println(i +". "+ menu.get(i));
        }
    }

    public void mostrarComida(int idx){

        System.out.println(menu.get(idx));
    }

    public void EditarComida(int idx, String nuevaComida){
        menu.set(idx,nuevaComida);
    }

    public void BorrarComida(int idx){
        menu.remove(idx);

    }



}
