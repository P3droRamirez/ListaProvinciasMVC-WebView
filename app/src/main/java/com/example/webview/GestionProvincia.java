package com.example.webview;

import java.util.ArrayList;
import java.util.List;

public class GestionProvincia {

    public static List<Provincia> listaPronvincias = new ArrayList<>();

    public GestionProvincia() {
    }

    public static List<Provincia> getListaPronvincias() {
        return listaPronvincias;
    }

    public static void setListaPronvincias(List<Provincia> listaPronvincias) {
        GestionProvincia.listaPronvincias = listaPronvincias;
    }
    public static void addProvincia(Provincia provincia){
        listaPronvincias.add(provincia);
        GestionProvincia.setListaPronvincias(listaPronvincias);
    }

    public static void ordenarPorNombre(List<Provincia> listaProvincia){
        listaProvincia.sort((provincia1,provincia2)->provincia1.getNombre().compareToIgnoreCase(provincia2.getNombre()));
    }
    public static void ordenarPorNumHab(List<Provincia> listaProvincia){
        listaProvincia.sort((provincia1,provincia2)->provincia1.getNumHabitantes() - provincia2.getNumHabitantes());
    }

    public static void cargaInicialProvincias(){
        Provincia p;
        listaPronvincias = new ArrayList<>();

        p= new Provincia(40000,"Sevilla","Sevilla",R.drawable.icon_sevilla);
        listaPronvincias.add(p);
        p = new Provincia(67647,"Cadiz","Jerez de la Frontera",R.drawable.icon_cadiz);
        listaPronvincias.add(p);
        p = new Provincia(7990,"Cordoba","Palma del Rio",R.drawable.icon_cordoba);
        listaPronvincias.add(p);
        p = new Provincia(34663,"Grnada","Almuñecar",R.drawable.icon_granada);
        listaPronvincias.add(p);
        p = new Provincia(33375,"Malaga","Fuengirola",R.drawable.icon_malaga);
        listaPronvincias.add(p);
    }
}
